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
	mav.setViewName("index");
	mav.addObject("msg", "メッセージだよ！");
	return mav;
	}
}
