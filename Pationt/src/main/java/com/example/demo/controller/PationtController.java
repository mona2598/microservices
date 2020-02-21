package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PationtController 
{
	@GetMapping("/patientData")
	public String getData()
	{
		return"hello patient";
	}

}
