package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;


@Component
//@Scope("prototype")
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	
  public TennisCoach() {
		System.out.println(">>TennisCoach : inside default constructor");
	}

 
  
  
/*  @Autowired
	public TennisCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}*/
  
  
  
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice your backhand volley";
	}

	
	
	/*//define setter method or any method
	
	@Autowired
	public void doSomeCrazyStuff(FortuneService fortuneService) {
		System.out.println(">>TennisCoach : inside doSomeCrazyStuff() method");
		this.fortuneService = fortuneService;
	}*/

	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
