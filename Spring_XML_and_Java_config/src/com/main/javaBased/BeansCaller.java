package com.main.javaBased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansCaller {
	@Bean 
	   public HelloSpringAnnotation helloSpringAnnotation(){
	      return new HelloSpringAnnotation();
	   }
	
	@Bean
		public LargestNum getLargestNum() {
			return new LargestNum();
		}
}