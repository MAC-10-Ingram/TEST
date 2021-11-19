package com.happyhouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntroController {

	@GetMapping(value = "/")
	public String home() {
	    return "index";
	}
}
