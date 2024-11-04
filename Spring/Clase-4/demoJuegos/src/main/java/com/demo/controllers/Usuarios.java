package com.demo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.models.Usuario;

import jakarta.servlet.http.HttpSession;

@Controller
public class Usuarios {
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	@GetMapping("/")
	public String inicio(HttpSession sesion) {
		// sesion.removeAttribute("usuario");
		// o
		sesion.invalidate();
		return "login.jsp";
	}

	@PostMapping("/login")
	public String login(RedirectAttributes flash, HttpSession sesion, @RequestParam String email,
			@RequestParam String password) {
		Usuario usuario = buscar(email);
		if (!usuario.getPassword().equals(password)) {
			flash.addFlashAttribute("errorPasswordLogin", "Contraseña incorrecta.");
			return "redirect:/";
		}
		sesion.setAttribute("usuario", usuario);
		return "redirect:/api/getGames";
	}

	@PostMapping("/register")
	public String register(RedirectAttributes flash, HttpSession sesion, @RequestParam String nombre,
			@RequestParam String apellido, @RequestParam String email, @RequestParam String password) {
		if (password.length() < 4) {
			flash.addFlashAttribute("errorPasswordRegister", "La contraseña debe contener al menos 4 caracteres");
			return "redirect:/";
		}
		Usuario newUser = new Usuario(nombre, apellido, email, password);
		usuarios.add(newUser);
		sesion.setAttribute("usuario", newUser);
		return "redirect:/api/getGames";
	}

	private Usuario buscar(String email) {
		Usuario usuario = null;
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getEmail().equals(email)) {
				usuario = usuarios.get(i);
			}
		}
		return usuario;
	}
}
