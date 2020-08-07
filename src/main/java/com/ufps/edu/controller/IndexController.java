package com.ufps.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ufps.edu.sevice.ImagenService;

@Controller
public class IndexController {

	@Autowired
	private ImagenService imagenService;
	
	@GetMapping({"/",""})
	public String index() {
		return "index";
	}
	
	@PostMapping ("/login")
	public String login(@RequestParam String username) {
		System.out.println(username);
			return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("imagenSimon", imagenService.getImagen());
		return "home";
	}
	
	@GetMapping("/logout")
	public String salir() {
		return "index";
	}
	@GetMapping("/ufps")
	public String ufps() {
		imagenService.setImagen(null);
		return "login";
	}
	@GetMapping("/simon")
	public String simon(Model model) {
		model.addAttribute("simon", true);
		imagenService.setImagen("https://radcolombia.org/web/sites/default/files/archivos/instituciones/universidad-simon-bolivar/logo-usm.png");
		return "login";
	}
	
}
