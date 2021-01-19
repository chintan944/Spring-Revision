package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	//need a controller method to show the initial HTML from
	@RequestMapping("/showForm")
	public String showForm(){
		return "helloworld-form";
	}
		
	//need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm(){
		return "helloworld";
	}
	
	//new controller method to read the data and add the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model)
	{
		//read the request parameter from the HTML form
		String theName=request.getParameter("studentName");
		
		//covert all data to caps
		theName = theName.toUpperCase();
		
		//create a messasge
		String result= "Yo! "+theName;
		
		//add message to model
		model.addAttribute("message", result);
		
				
		return "helloworld";
	}
	
	
	
	//Use of @RequestParam  
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName")String theName, Model model)
	{
		
		
		//covert all data to caps
		theName = theName.toUpperCase();
		
		//create a messasge
		String result= "Hey My Friend from v3! "+theName;
		
		//add message to model
		model.addAttribute("message", result);
		
				
		return "helloworld";
	}
}