/**
 * 
 */
package cgd.framework.dbsetup;

import static morphis.framework.commons.LogHandling.display;
import static org.apache.commons.lang3.StringUtils.join;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import cgd.framework.DataSerializationModule;
import cgd.framework.envelope.CgdEnvelope;
import cgd.gh.persistence.database.TbghWebserviceMessages;
import morphis.framework.base.IDataObject;
import morphis.framework.commons.StringHandling;
import morphis.framework.configuration.Config;
import morphis.framework.datatypes.arrays.IArray;
import morphis.framework.datatypes.fields.IField;
import morphis.framework.datatypes.reflection.DataFactory;
import morphis.framework.datatypes.reflection.Layout;
import morphis.framework.datatypes.reflection.Layout.Element;
import morphis.framework.datatypes.reflection.Layout.ElementKind;
import morphis.framework.persistence.relational.BaseTableHandler;
import morphis.framework.persistence.relational.ConnectionManager;
import morphis.framework.persistence.relational.NamedStatement;
import morphis.framework.server.controller.PersistenceCode;
import morphis.framework.utils.ReflectionUtils;

/**
 * @author joao.goncalves
 *
 */
public class RunMessageTestsProgram {
	public static void main(String[] args) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new DataSerializationModule());
		
		RunMessageTestsProgram prog = new RunMessageTestsProgram(objectMapper);
		prog.runTests(args);
	}
	
	private ObjectMapper objectMapper;
	
	private RunMessageTestsProgram(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}
	
	private void runTests(String[] criteria) throws Exception {
		TbghWebserviceMessages handler = (TbghWebserviceMessages)findHandler("TBGH_WEBSERVICE_MESSAGES");

		String stmt = "select * from pgowndb.tbgh_webservice_messages";
		if (criteria.length > 0) {
			stmt += " where " + join(criteria, " ");
		}
		stmt += " order by prog_name";
		
		handler.openCursor(new NamedStatement(ConnectionManager.getConnection(), stmt));
		while (handler.fetchCursor() == PersistenceCode.NORMAL) {
			String programName = handler.getCursorReturnedString("prog_name");
			String msgIn = handler.getCursorReturnedBytes("msg_inp");
			String msgOut = handler.getCursorReturnedBytes("msg_out");
			
			runTest(programName, msgIn, msgOut);
		}
		handler.closeCursor();
	}
	
	private void runTest(String programName, String msgIn, String msgOut) {
		display(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		display("program: ", programName, "...");

		try {
			Class programClass = findServiceClass(programName);
			
			String controllerName = String.format("%s.controllers.%sController", programClass.getPackage().getName(), programClass.getSimpleName());
			Class controllerClass = ReflectionUtils.findClass(controllerName);
			
			CgdEnvelope envIn = getEnvelope(programClass, "In", msgIn);
			CgdEnvelope envOut = getEnvelope(programClass, "Out", msgOut);
	
			Object controller = ReflectionUtils.newInstance(controllerClass);
			Method callMethod = ReflectionUtils.findMethod(controllerClass, "call" + programClass.getSimpleName(), envIn.getClass().getInterfaces()[0]);
			
			display("calling...");

			CgdEnvelope envRet = (CgdEnvelope)callMethod.invoke(controller, envIn);

			display("done");

			displayEnvelope("input", envIn);
			displayEnvelope("expected", envOut);
			displayEnvelope("returned", envRet);

			displayEnvelopeDiffs(envOut, envRet);
		}
		catch (Exception e) {
			display("exception (stack trace below):");
			e.printStackTrace();
		}
	}
	
	private void displayEnvelope(String header, CgdEnvelope env) throws Exception {
		String json = objectMapper.writeValueAsString(env);
		display(header, ": ", json);
	}
	
	private class Diff {
		public Object out;
		public Object ret;

		public Element element;
		public int index;
		public List<Diff> children;
		
		public Diff(Element element) {
			this.element = element;
			this.index = -1;
			this.children = new ArrayList<>();
		}
		
		public Diff(Object out, Object ret, Element element) {
			this(element);

			this.out = out;
			this.ret = ret;
		}
		
		public Diff(Object out, Object ret, Element element, int index) {
			this(out, ret, element);
			
			this.index = index;
		}
	}
	
	private void displayEnvelopeDiffs(CgdEnvelope out, CgdEnvelope ret) {
		Diff diff = getDiffs(out, ret);
		if (diff == null) {
			display("result: no differences found");
		}
		else {
			display("diffs: expected -> returned");
			displayDiffs(diff, 0);
		}
	}

	private void displayDiffs(Diff diff, int level) {
		Element e = diff.element;
		if (e != null) {
			String s = StringHandling.repeatChar('\t', level);
			
			if (diff.index < 0)
				s += e.name;
			else
				s += String.format("[%d]", diff.index);
			
			if (diff.children.isEmpty()) {
				s += String.format(": %s -> %s", diffValue(diff.out), diffValue(diff.ret));
			}				
			
			display(s);
		}
		
		for (Diff child : diff.children) {
			displayDiffs(child, level + 1);
		}
	}
	
	private String diffValue(Object value) {
		if (value instanceof IField)
			value = ((IField)value).getRaw();
		return value.toString();
	}
	
	private Diff getDiffs(CgdEnvelope out, CgdEnvelope ret) {
		Diff diff = new Diff(null);
		
		collectDiffs(diff, out, ret);
		
		return diff.children.isEmpty() ? null : diff;
	}
	
	private void collectDiffs(Diff parent, IDataObject out, IDataObject ret) {
		Layout la = out.getLayout();
		Layout lb = ret.getLayout();
		
		for (Element a : la.elements) {
			if (!a.isData())
				continue;
			
			ElementKind kind = a.kind;

			Element b = lb.elements[a.index];
			
			Object val_a = out.getStorage(a);
			Object val_b = ret.getStorage(b);
			
			if (kind == ElementKind.SIMPLE) {
				if (((IField)val_a).isDifferent(val_b))
					parent.children.add(new Diff(val_a, val_b, a));
			}
			else {
				Diff self = new Diff(a);
				
				if (kind == ElementKind.STRUCTURED) {
					collectDiffs(self, (IDataObject)val_a, (IDataObject)val_b);
				}
				else {
					IArray<?> vals_a = (IArray<?>)val_a;
					IArray<?> vals_b = (IArray<?>)val_b;
					
					int len_a = vals_a.length();
					int len_b = vals_b.length();
					
					for (int i = 1; i <= len_a; ++i) {
						val_a = vals_a.get(i);
						
						if (i > len_b) {
							self.children.add(new Diff(val_a, null, a, i));
						}
						else {
							val_b = vals_b.get(i);
							
							if (kind == ElementKind.SIMPLE_LIST) {
								if (((IField)val_a).isDifferent(val_b))
									self.children.add(new Diff(val_a, val_b, a, i));
							}
							else {
								Diff entry = new Diff(a);
								
								collectDiffs(entry, (IDataObject)val_a, (IDataObject)val_b);
								if (!entry.children.isEmpty()) {
									entry.index = i;
									
									self.children.add(entry);
								}
							}
						}
					}
					
					for (int i = len_a; i < len_b; ++i) {
						val_b =  vals_b.get(i);
						
						self.children.add(new Diff(null, val_b, a, i));
					}
				}
				
				if (!self.children.isEmpty()) {
					parent.children.add(self);
				}
			}
		}
	}
	
	private CgdEnvelope getEnvelope(Class programClass, String direction, String message) {
		Class envClass = ReflectionUtils.findClass(programClass.getName() + "$Envelope" + direction);
		CgdEnvelope env = (CgdEnvelope)DataFactory.newDataObject(envClass);
		
		Element mensagemElement = env.getLayout().getElement("mensagem");
		Element msgElement = mensagemElement.layout.getElement("msg" + direction);
		
		int offset = mensagemElement.offset + msgElement.offset;
		int size = msgElement.size;
		
		String val = message.substring(0, offset + size);
		
		int delta = 1300 - size;
		if (delta < 0)
			val += StringHandling.spaces(-delta);
		
		val += message.substring(offset + 1300);
		
		env.deserialize(val);
				
		return env;
	}
	
	private Class findServiceClass(String programName) {
		String programClassName = programName.substring(0, 1).toUpperCase() + programName.substring(1).toLowerCase();
		for (String servicePackage : Config.servicePackages) {
			Class c = ReflectionUtils.findClass((servicePackage + "." + programClassName).toString());
			if (c != null)
				return c;
		}
		return null;
	}
	
	public BaseTableHandler findHandler(String tableName) {
		String className = "";
		String[] tablePartNames = tableName.split("\\_+"); 
		for (String tablePartName : tablePartNames) {
			tableName = tablePartName.substring(0, 1).toUpperCase() + tablePartName.substring(1).toLowerCase();
			className += tableName; 
		}
		for (String tablePackage : Config.tablePackages) {
			try {
				return  (BaseTableHandler)ReflectionUtils.newInstance(ReflectionUtils.findClass(tablePackage + "." + className));
			} 
			catch (Exception e) {
				// ignore
			}
		}
		return null;
	}
}
