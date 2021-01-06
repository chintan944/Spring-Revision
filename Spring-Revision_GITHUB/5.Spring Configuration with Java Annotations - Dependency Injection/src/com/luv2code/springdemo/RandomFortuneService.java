package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	//create an array of strings
	private String data[]={
			"Beware of the wolf in sheep's clothing",
			"Diligence is the mother of good luck",
			"The journey is the reward"
	};
	
	//create new random generator
	private Random myRandom = new Random();
	
				
	public String getFortune() {
		//pick random string from an array
		int index=myRandom.nextInt(data.length);		
		String theFortune=data[index];		
		return theFortune;
	}

}
