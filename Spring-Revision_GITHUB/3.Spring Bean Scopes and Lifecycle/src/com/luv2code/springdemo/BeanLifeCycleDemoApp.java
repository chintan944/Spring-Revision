package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		
		//load configuration file
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		//retrieve bean from spring container 
				
		Coach theCoach = (Coach) context.getBean("myCoach",Coach.class);
		
		Coach alphaCoach = (Coach) context.getBean("myCoach",Coach.class);
		
		//check if they are the same
		boolean result= (theCoach == alphaCoach);
		
		//Print the results
		System.out.println("\nPointing to the same object: "+result);
		
		System.out.println("\nMemory location for theCoach: "+theCoach);
		
		System.out.println("\nMemory location for alphaCoach: "+alphaCoach);
		
		//close the context
				context.close();


	}

}
