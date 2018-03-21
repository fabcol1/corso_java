package org.proxima;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableCaching
public class UserRegistrationSystemApplication {
	
	final static Logger logger = Logger.getLogger(UserRegistrationSystemApplication.class);
	
	public static void main(String[] args) {
		logger.debug("#######################################");
		logger.debug("#######################################");
		logger.debug("#######################################");
		logger.debug("#######################################");
		logger.debug("#######################################");
		logger.debug("############STARTING###################");
		logger.debug("#######################################");
		logger.debug("#######################################");
		logger.debug("#######################################");
		logger.debug("#######################################");
		logger.debug("#######################################");
		SpringApplication.run(UserRegistrationSystemApplication.class, args);
	}
}
