package com.luv2code.springdemo;

import org.springframework.stereotype.Component;


@Component
public class TennisCoach implements Coach {
    
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice your backhand volley";
	}

}
