package com.noman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping(value={"/","/welcome"},method=RequestMethod.GET)
	public ModelAndView doWelcome(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "Spring Security Hello World");
		mv.addObject("message", "This is welcome page!");
		mv.setViewName("hello");
		
		return mv;
		
	}

	@RequestMapping(value="/admin",method=RequestMethod.GET)
	public ModelAndView doAdmin(){
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("title", "Spring Security Hello World");
		mv.addObject("message", "This is protected page!");
		mv.setViewName("admin");
		
		return mv ;
	}
	
	@RequestMapping(value ="/login", method=RequestMethod.GET)
	public ModelAndView doLogin(@RequestParam(value="error",required=false) String error,
			@RequestParam(value="logout",required=false) String logout){
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;
		
	}
}
