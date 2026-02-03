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
	String msg = """
	<div class="border border-primary">
	<h2>Message</h2>
	<p>this is sample Message!!</p>
	</div>
	""";
	mav.addObject("msg", msg);
	return mav;
	}
}
