package com.oscar.springboot.app.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.oscar.springboot.app.model.domain.Usuario;

@Controller
public class FormController {
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("titulo", "Crear Usuario");
		model.addAttribute("usuario", new Usuario());
		
		return "form";
	}
	
	@PostMapping("/form")
	public String procesarFormulario(@Valid Usuario usuario, BindingResult result, Model model) {

		model.addAttribute("titulo", "Resultado form");

		if (result.hasErrors()) {
			return "form";
		}

		model.addAttribute("usuario", usuario);

		return "resultado";
	}
}
