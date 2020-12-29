package com.luv2code.springdemo;

public class BaseballCoach implements Coach{
	
	//define private field for dependency
	private FortuneService fortuneService;
	
	//define constructor dependency
	
	public BaseballCoach(FortuneService theFortuneService) {
		super();
		fortuneService = theFortuneService;
	}

	public String getDailyWorkout(){
		return "Spend 30 minutes on batting practice";
	}

	public String getDailyFortune() {
		
		// use my fortuneservice to get a fortune
		return fortuneService.getFortune();
	}

}
