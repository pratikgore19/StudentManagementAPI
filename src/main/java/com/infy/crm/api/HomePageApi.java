package com.infy.crm.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studentCrm")
public class HomePageApi {

	@GetMapping("")
	public String homePage() {
		return "Welcome to Student Management App";
	}
}
