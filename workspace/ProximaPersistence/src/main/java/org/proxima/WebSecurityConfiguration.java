/**
 * 
 */
package org.proxima;

import org.apache.log4j.Logger;
import org.proxima.rest.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * @author maurizio
 *
 */
@Configuration
@EnableWebSecurity
// @EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	final static Logger logger = Logger.getLogger(WebSecurityConfiguration.class);

//	@Autowired
//	private UserService userService;
	@Autowired
	private LoginService loginService;
	// @Override
	// protected void configure(AuthenticationManagerBuilder
	// authenticationManagerBuilder) throws Exception {
	// logger.info("SpringSecurityConfiguration_Database.configure - START");
	// authenticationManagerBuilder.userDetailsService(userService);
	// }
	//
	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// logger.info("SpringSecurityConfiguration_Database.configure - START");
	// http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
	// .antMatchers("/api/user/**").authenticated().and().httpBasic().realmName("User
	// Registration System")
	// .and().csrf().disable();
	// }
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		logger.info("SpringSecurityConfiguration_Database.configureGlobal - START");
//		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("user")
//				.password("password").roles("USER");
//		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("admin")
//				.password("password").roles("USER", "ADMIN");
		auth.userDetailsService(loginService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("SpringSecurityConfiguration_Database.configure - START");
//		http.httpBasic().and().authorizeRequests()
//		        .antMatchers(HttpMethod.GET, "/api/user/").hasRole("USER")
//				.antMatchers(HttpMethod.GET, "/api/user/**").hasRole("USER")
////				.antMatchers(HttpMethod.POST, "/api/user/").hasRole("USER")
//				.antMatchers(HttpMethod.PUT, "/api/user/**").hasRole("USER")
//				.antMatchers(HttpMethod.DELETE, "/api/user/**").hasRole("ADMIN")
//				.antMatchers(HttpMethod.GET, "/template/home.html").permitAll()
//				.antMatchers(HttpMethod.GET, "/template/login.html").permitAll()
//				.antMatchers(HttpMethod.GET, "/").permitAll()
//				.antMatchers(HttpMethod.POST, "/api/user/").permitAll()
//				
////				.and().formLogin().loginPage("/").permitAll()
//				.and().csrf()
////				.disable()
//				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		
		
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//		    .and().authorizeRequests()
//		    .antMatchers("/api/user/**").authenticated()
//		    .antMatchers("/api/user/orderByLastname").authenticated()
//		    .and().httpBasic().realmName("User Registration System")
//			.and().csrf().disable();
		
		
		
		
//		

		
		http
        .httpBasic()
                .realmName("User Registration System")
        .and()
        .authorizeRequests().antMatchers("/template/login.html", "/template/home.html","/").permitAll()
//                .anyRequest().authenticated()
                .and().csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
////		
	}

}
