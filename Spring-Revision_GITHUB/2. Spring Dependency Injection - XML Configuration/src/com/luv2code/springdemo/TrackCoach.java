package com.luv2code.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;
	
	
	public TrackCoach() {
	}

	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run a hard 5k";
	}

	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Just Do It: " + fortuneService.getFortune();
	}

}