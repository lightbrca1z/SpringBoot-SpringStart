package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/")
	public ModelAndView index(ModelAndView mav) {
		String[] data = {"Windows","macOS","Linux","ChromeOS"};
		mav.setViewName("index");
		mav.addObject("title", "Groovy templates");
		mav.addObject("msg", "This is smaple message!!");
		mav.addObject("data", data);
		return mav;
	}
}
