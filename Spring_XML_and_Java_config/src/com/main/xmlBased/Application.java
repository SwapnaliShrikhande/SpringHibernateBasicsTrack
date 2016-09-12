package com.main.xmlBased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
	      ApplicationContext context = 
	             new ClassPathXmlApplicationContext("Beans.xml");

	      HelloSpringXML helloObj = (HelloSpringXML) context.getBean("helloSpringXML");
	      helloObj.getMessage();
	      
	      LargestNum numObj = (LargestNum) context.getBean("largestNum");	      
	      System.out.println(numObj.getLargestNum(numObj.permutationFinder("101")));
	    }

}