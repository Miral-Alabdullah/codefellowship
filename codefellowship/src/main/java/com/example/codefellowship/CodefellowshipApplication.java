package com.example.codefellowship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class CodefellowshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodefellowshipApplication.class, args);

	}

	@GetMapping("/")
	public String starterPage() {
		return "home.html";
	}

	@GetMapping("/login")
	public String getLogin() {
		return "signin.html";
	}

	@GetMapping("/signup")
	public String getSignUp() {
		return "signup.html";
	}
}
