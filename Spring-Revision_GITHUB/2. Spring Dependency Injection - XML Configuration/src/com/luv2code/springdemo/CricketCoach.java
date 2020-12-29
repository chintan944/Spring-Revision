package com.luv2code.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	//define fields
	private String emailAddress,team;
	
	//create no arg constructor as a diagnose msg
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor");
	}

	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast bowling for 15 minutes";
	}

	//setter method
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		System.out.println("CricketCoach: inside setter method - setFortuneService");
	}

	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		System.out.println("CricketCoach: inside setter method - setEmailAddress");
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
		System.out.println("CricketCoach: inside setter method - setTeam");
	}

	
	
}
