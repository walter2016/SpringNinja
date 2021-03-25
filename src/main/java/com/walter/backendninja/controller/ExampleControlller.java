package com.walter.backendninja.controller;

import java.util.ArrayList;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.walter.backendninja.model.Person;

@Controller
@RequestMapping("/example")
public class ExampleControlller {
	
	
	public static final String EXAMPLE_VIEW = "example";
	
	//primera forma
	@GetMapping("/exampleString")
	//@RequestMapping(value="/exampleString", method = RequestMethod.GET)
	public String exampleString(Model model) {
		model.addAttribute("people",getPeople());
		return EXAMPLE_VIEW;
	}
	
	
	//Segunda forma
	@GetMapping("/exampleMAV")
	//@RequestMapping(value="/exampleMAV", method = RequestMethod.GET)
	public ModelAndView exampleMAV() { 
		ModelAndView mov = new ModelAndView(EXAMPLE_VIEW);
		mov.addObject("people",getPeople());
		
		return   mov;
	}
	
	
	private List<Person> getPeople(){
		List<Person> people = new ArrayList<>();
		people.add(new Person("Walter", 25));
		people.add(new Person("Alex", 30));
		people.add(new Person("Jose", 95));
		people.add(new Person("Francisco", 65));
		
		return people;
	}
	

}
