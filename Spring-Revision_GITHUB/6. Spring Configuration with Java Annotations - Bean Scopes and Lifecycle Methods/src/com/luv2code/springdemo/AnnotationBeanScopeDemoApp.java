package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		//load spring config file
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve the bean from spring container
		Coach theCoach=context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach=context.getBean("tennisCoach", Coach.class);
		
		//check equality
		boolean result= (theCoach == alphaCoach);
		System.out.println("\n Prointing to the same object : "+result);
		
		System.out.println("\n Memory location for theCoach : "+theCoach);
		
		System.out.println("\n Memory location for alphaCoach : "+alphaCoach);
		
		//close the context
		context.close();
	
	}

}
