package org.proxima;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class ApplicationPropertiesUtil {

	 @Bean(name = "pathName")
	    public ReloadableResourceBundleMessageSource messageSource() {
	            ReloadableResourceBundleMessageSource messageBundle =
	                            new ReloadableResourceBundleMessageSource();
	            messageBundle.setBasename("classpath:application");
	            messageBundle.setDefaultEncoding("UTF-8");
	            return messageBundle;
	    }

}
