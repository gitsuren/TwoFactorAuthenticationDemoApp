package com.suru;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MyController {
	
	@RequestMapping("/")
	public String hello(){
		return "Hola!!!";
	}
	
	@RequestMapping("/play")
	public ModelAndView play(){
		return new ModelAndView("index");
	}
	
	@RequestMapping("/PlayHere")
	public ModelAndView playhere(){
		return new ModelAndView("PlayHere");
	}
	
	@RequestMapping(value = "/ajaxHost", method = RequestMethod.GET)
	public ModelAndView check(@RequestParam(value = "one") String one,
			@RequestParam(value = "two") String two,
			@RequestParam(value = "three") String three,
			@RequestParam(value = "four") String four,
			@RequestParam(value = "word") String word){
		return new ModelAndView("ajaxHost");
	}

}
