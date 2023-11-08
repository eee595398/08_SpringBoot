package edu.kh.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainCotroller {
	
	@RequestMapping("/")
	public String mainForward(Model model) {
		
		model.addAttribute("message", "스프링 테스트");
		
		// Spring MVC : // webapp/WEB-INF/views/coomon/main.jsp
		
		// Spring Boot(+thymeleaf 템플릿 엔진)
		// src/main/resources/templates/common/main.html
		
		
		
		return "common/main";
	}
	
}
