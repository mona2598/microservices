package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicalController 
{
	@GetMapping("/medicalInfo")
	public String getAllData()
	{
		return " Medical Report";
	}

}
