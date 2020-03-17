package com.oscar.springboot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {
	
	@GetMapping("/form")
	public String form(Model model) {
		return "form";
	}
	
	@PostMapping("/form")
	public String procesarFormulario(Model model) {
		return "resultado";
	}
}
