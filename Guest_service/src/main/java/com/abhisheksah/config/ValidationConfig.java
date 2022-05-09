package com.abhisheksah.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidationConfig {
	//this is an event listner name--ValidatingMongoEventListener
	@Bean
	public ValidatingMongoEventListener validationMongoEventListener() {
		return new ValidatingMongoEventListener(validator());
	}
	
	
	//this event listner call a method called LocalValidatorFactoryBean
	@Bean
	public LocalValidatorFactoryBean validator() {
		return new LocalValidatorFactoryBean();
	}
}
