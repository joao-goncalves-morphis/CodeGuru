/**
 * 
 */
package cgd.framework.processes;
import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;

import morphis.framework.processes.ProcessLoader;
public class CustomProcessLoader extends ProcessLoader {
	
	
	public static void main(String[] args) {
		Map<String, Object> customParameters = new HashMap<>();
		int aLen = args.length;
		String job;
		if (aLen == 0)
			job = "TESTES1"; // TESTES1 TESTES2
		else
			job = args[0].trim();
		
		if (aLen > 1) {
			if((aLen - 1) %2 != 0 && aLen != 2) 
				System.console().printf("Invalid number of arguments %s - args format: JOBNAME <parName1> <parValue1> <parName2> <parValue2> ...", aLen); 
			if (aLen == 2)
				customParameters.put(args[0].trim(), args[1].trim());
			for (int i = 1; i < aLen - 1; i++) { 
				
				customParameters.put(args[i].trim(), args[i + 1].trim());
			}
		}
		
		ProcessLoader.loadJson(job, customParameters);
	}
	
}