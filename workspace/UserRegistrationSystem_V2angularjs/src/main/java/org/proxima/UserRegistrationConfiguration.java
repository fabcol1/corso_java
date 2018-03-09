/**
 * 
 */
package org.proxima;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * @author maurizio
 *
 */
@Configuration
public class UserRegistrationConfiguration {
    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource messageSource() {
            ReloadableResourceBundleMessageSource messageBundle =
                            new ReloadableResourceBundleMessageSource();
            messageBundle.setBasename("classpath:messages");
            messageBundle.setDefaultEncoding("UTF-8");
            return messageBundle;
    }
}
