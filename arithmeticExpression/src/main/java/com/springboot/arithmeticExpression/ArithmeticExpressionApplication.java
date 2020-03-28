package com.springboot.arithmeticExpression;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ArithmeticExpressionApplication extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ArithmeticExpressionApplication.class);
		
	}
	public static void main(String[] args) {
		SpringApplication.run(ArithmeticExpressionApplication.class, args);
	}

}


