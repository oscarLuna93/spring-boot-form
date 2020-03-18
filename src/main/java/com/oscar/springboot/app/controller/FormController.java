package com.oscar.springboot.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.oscar.springboot.app.model.domain.Usuario;
import com.oscar.springboot.app.validation.UsuarioValidador;

@Controller
@SessionAttributes("usuario")
public class FormController {
	
	@Autowired
	private UsuarioValidador validador;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validador);
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setIdentificador("12.345.213-P");
		
		model.addAttribute("titulo", "Crear Usuario");
		model.addAttribute("usuario", usuario);
		
		return "form";
	}
	
	@PostMapping("/form")
	public String procesarFormulario(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {
		model.addAttribute("titulo", "Resultado form");

		if (result.hasErrors()) {
			return "form";
		}

		model.addAttribute("usuario", usuario);
		status.setComplete();
		return "resultado";
	}
}
