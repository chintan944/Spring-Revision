package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	
	String firstName;
	String lastName;
	String country;
	String favoriteLanguage;
	String[] operatingSystem;
	
	LinkedHashMap<String,String> countryOptions;
	
	public Student() {
		// populate country ooptions : used ISO country code
		
		countryOptions = new LinkedHashMap<>();
		
		countryOptions.put("BR","Brazil");
		countryOptions.put("FR","Germany");
		countryOptions.put("DE","France");
		countryOptions.put("IN","India");
		countryOptions.put("US","United States of America");
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}
	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}
	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}
	public String[] getOperatingSystem() {
		return operatingSystem;
	}
	public void setOperatingSystem(String[] operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	 	

}
