package cgd;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ch.qos.logback.core.util.Duration;

@SpringBootApplication
@ComponentScan(basePackages={ "morphis.framework", "cgd"})
public class WebApp extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(WebApp.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
					.addMapping(Config.cors.urlPattern)
					.allowedOrigins(Config.cors.allowedOrigins)
					.allowCredentials(Config.cors.allowCredentials);
			}
		};
    }

// For setting webserver properties 
//	@Bean
//	public ConfigurableServletWebServerFactory webServerFactory() {
//		TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
//		factory.setPort(8080);
//		return factory;
//	}
	
	
	
	
}

