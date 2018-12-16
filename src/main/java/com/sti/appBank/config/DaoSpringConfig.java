package com.sti.appBank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.sti.appBank.dao.AccountDao;
import com.sti.appBank.dao.CustomerDao;
import com.sti.appBank.dao.TransactionDao;
import com.sti.appBank.dao.impl.AccountImpl;
import com.sti.appBank.dao.impl.CustomerImpl;
import com.sti.appBank.dao.impl.TransactionImpl;

@Configuration
public class DaoSpringConfig {
	
	@Bean
	public CustomerDao customerDao() {
		return new CustomerImpl();
	}
	
	@Bean
	public AccountDao accountDao() {
		return new AccountImpl();
	}
	
	@Bean
	public TransactionDao TransactionDao() {
		return new TransactionImpl();
	}
	
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("*")
						.allowedHeaders("*");
			}
		};
	}
	
}