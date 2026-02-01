package com.app.welcome_app.service;
import org.springframework.stereotype.Service;
@Service
public class WelcomeService {
public String getWelcomeMessage() {
	return "Welcome to Spring boot Dependency Injection";
}
}
