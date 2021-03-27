package com.walter.backendninja.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.walter.backendninja.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {
	
	private static final Log LOGGER = LogFactory.getLog(Example3Controller.class);
	
	public static final String FORM_VIEW = "form";
	public static final String RESULT_VIEW = "result";
	
	/*
	//forma 1
	@GetMapping("/")
	public String redirect() {
		return "redirect:/example3/showForm";
	}
	*/
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/example3/showForm");
	}

	@GetMapping("/showForm")
	public String showForm(Model model) {
		LOGGER.info("INFO TRACE");
		LOGGER.warn("WARN TRACE");
		LOGGER.error("ERROR TRACE");
		LOGGER.debug("DEBUG TRACE");
		model.addAttribute("person", new Person());
		return FORM_VIEW;
	}
	
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {
		ModelAndView mov = new ModelAndView();
		if(bindingResult.hasErrors()) {
			System.out.println("Entro al If");
			mov.setViewName(FORM_VIEW);
		}else {
			System.out.println("Entro al else");
			mov.setViewName(RESULT_VIEW);
			mov.addObject("person", person);
		}
		return mov;
	}
	
	
}
