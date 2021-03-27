package com.walter.backendninja.controller;

import java.util.ArrayList;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.walter.backendninja.component.ExampleComponent;
import com.walter.backendninja.model.Person;
import com.walter.backendninja.service.ExampleService;

@Controller
@RequestMapping("/example")
public class ExampleControlller {
	
	
	public static final String EXAMPLE_VIEW = "example";
	
	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;
	
	
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;
	
	//primera forma
	@GetMapping("/exampleString")
	//@RequestMapping(value="/exampleString", method = RequestMethod.GET)
	public String exampleString(Model model) {
		exampleComponent.sayHello();
		model.addAttribute("people",exampleService.getListPeople());
		return EXAMPLE_VIEW;
	}
	
	
	//Segunda forma
	@GetMapping("/exampleMAV")
	//@RequestMapping(value="/exampleMAV", method = RequestMethod.GET)
	public ModelAndView exampleMAV() { 
		ModelAndView mov = new ModelAndView(EXAMPLE_VIEW);
		mov.addObject("people",exampleService.getListPeople());
		
		return   mov;
	}
	
	

	

}
