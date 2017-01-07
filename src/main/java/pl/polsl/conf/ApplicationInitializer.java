package pl.polsl.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import pl.polsl.ApplicationConfig;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	   @Override
	   protected Class<?>[] getRootConfigClasses() {
	           return new Class[] { ApplicationConfig.class };
	   }

	   @Override
	   protected Class<?>[] getServletConfigClasses() {
	           return null;
	   }

	   @Override
	   protected String[] getServletMappings() {
	           return new String[] { "/" };
	   }    
	}
