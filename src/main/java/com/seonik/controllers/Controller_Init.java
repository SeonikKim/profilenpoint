package com.seonik.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller_Init {

	@GetMapping("/")
	public String main() {
		return "/main.html";
	}
	
}