package com.duongnv30.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "HomeControllerOfWeb")
public class HomeController {
	
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
<<<<<<< HEAD:src/main/java/com/duongnv30/controller/HomeController.java
		ModelAndView mav = new ModelAndView("home");
=======
		ModelAndView mav = new ModelAndView("web/home");
		return mav;
	}
	
	@RequestMapping(value = "/spring-mvc", method = RequestMethod.GET)
	public ModelAndView springMVCPage() {
		ModelAndView mav = new ModelAndView("springmvc");
>>>>>>> duongnv30:src/main/java/com/duongnv30/controller/web/HomeController.java
		return mav;
	}
	
	@RequestMapping(value = "/spring-mvc", method = RequestMethod.GET)
	public ModelAndView springMVCPage() {
		ModelAndView mav = new ModelAndView("springmvc");
		return mav;
	}
	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
}
