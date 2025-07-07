package com.seonik.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller_Init {

	private final String tossClientKey;

	public Controller_Init(@Value("${tossPayments.clientKey}") String tossClientKey) {
		this.tossClientKey = tossClientKey;
	}

	@GetMapping("/") // 메인
	public String main() {
		return "main";
	}

	@GetMapping("/proj1") // 프로젝트1 메인
	public String proj1() {
		return "proj1";
	}

	@GetMapping("/proj1/detail")
	public String detail() {
		return "detail";
	}

	@GetMapping("/proj2") // 프로젝트2 메인
	public String proj2(Model model) {
		model.addAttribute("clientKey", tossClientKey);
		return "proj2";
	}
}