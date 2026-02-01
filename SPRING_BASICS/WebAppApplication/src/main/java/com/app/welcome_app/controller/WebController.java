package com.app.welcome_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.welcome_app.service.WelcomeService;

import com.app.welcome_app.service.WelcomeService;

@RestController
public class WebController {
	private final WelcomeService welcomeService;

	public WebController(WelcomeService welcomeService) {
		super();
		this.welcomeService = welcomeService;
	}
	@GetMapping("/welcome")
	public String getwelcome() {
		return welcomeService.getWelcomeMessage();
	}

}
