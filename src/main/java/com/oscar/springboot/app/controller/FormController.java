package com.oscar.springboot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.oscar.springboot.app.model.domain.Usuario;

@Controller
public class FormController {
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("titulo", "Crear Usuario");
		
		return "form";
	}
	
	@PostMapping("/form")
	public String procesarFormulario(Usuario usuario, Model model) {
		model.addAttribute("titulo", "Resultado form");
		model.addAttribute("usuario", usuario);

		return "resultado";
	}
}
