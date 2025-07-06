package com.seonik.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller_Init {

	@GetMapping("/")//메인
	public String main() {
		return "main";
	}

	@GetMapping("/proj1")//프로젝트1 메인
	public String proj1() {
		return"proj1";
	}
	
	@GetMapping("/proj2")//프로젝트2 메인
	public String proj2() {
		return"proj2";
	}
}