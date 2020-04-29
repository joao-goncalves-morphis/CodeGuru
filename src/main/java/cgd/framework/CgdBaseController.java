package cgd.framework;

import cgd.framework.envelope.CgdEnvelope;
import morphis.framework.datatypes.reflection.DataFactory;
import morphis.framework.utils.ReflectionUtils;

public class CgdBaseController {
	public <I extends CgdEnvelope, O extends CgdEnvelope> O call(I envIn) {
		try {
			Class envInType = getEnvelopeType(envIn);
			
			Class serviceClass = envInType.getEnclosingClass();
			CgdBaseOnline service = (CgdBaseOnline)DataFactory.newDataObject(serviceClass);
			
			Class envOutType = ReflectionUtils.findClass(serviceClass.getName() + "$EnvelopeOut");
			O envOut = (O)DataFactory.newDataObject(envOutType);
			
	        envOut.setCorresponding(envIn);
	        service.setEnvelopes(envIn, envOut);
	        
	        service.run();
	
			return envOut;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private Class getEnvelopeType(CgdEnvelope envIn) {
		return envIn.getClass().getInterfaces()[0];
	}
}
