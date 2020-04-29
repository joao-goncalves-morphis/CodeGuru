package cgd.framework;

import static morphis.framework.utils.ReflectionUtils.findClass;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.module.SimpleModule;

import morphis.framework.datatypes.serialization.json.DataDeserializer;
import morphis.framework.datatypes.serialization.json.DataSerializer;

@Service
@SuppressWarnings("serial")
public class DataSerializationModule extends SimpleModule {
	public DataSerializationModule() {
		registerEnvelopes();
	}
	
	private void registerEnvelopes() {
		ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false) {
		    @Override
		    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
		        return super.isCandidateComponent(beanDefinition) || beanDefinition.getMetadata().isAbstract();
		    }
		};
		provider.addIncludeFilter(new AssignableTypeFilter(CgdBaseOnline.class));
		
		for (BeanDefinition def : provider.findCandidateComponents("/cgd/gh/online")) {
			Class serviceClass = findClass(def.getBeanClassName());
			
			registerEnvelope(serviceClass, "EnvelopeIn");
			registerEnvelope(serviceClass, "EnvelopeOut");
		}
	}
	
	private void registerEnvelope(Class serviceClass, String name) {
		Class envClass = envelopeClass(serviceClass, name);
		if (envClass != null) {
			this.addSerializer(envClass, new DataSerializer(envClass));
			this.addDeserializer(envClass, new DataDeserializer(envClass));
		}
	}
	
	private Class envelopeClass(Class serviceClass, String name) {
		return findClass(serviceClass.getName() + "$" + name);
	}
}
