package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.repository.PersonRepository;

import com.example.demo.entry.Person;

@Controller
public class HelloController {
	
	@Autowired
	PersonRepository repository;
	
	@GetMapping("/")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("title", "Hello Page!");
		mav.addObject("msg", "this is JPA sample data.");
		Iterable<Person> list = repository.findAll();
		mav.addObject("data", list);
		return mav;
	}

}
