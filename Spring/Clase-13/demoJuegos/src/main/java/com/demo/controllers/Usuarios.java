package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.models.LoginUsuario;
import com.demo.models.Usuario;
import com.demo.services.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class Usuarios {

	@Autowired
	private ServicioUsuarios servicioUsuarios;

	@GetMapping("/")
	public String inicio(Model modelo) {
		modelo.addAttribute("usuario", new Usuario());
		modelo.addAttribute("loginUsuario", new LoginUsuario());
		return "login.jsp";
	}

	@GetMapping("/logout")
	public String logout(HttpSession sesion) {
		sesion.invalidate();
		return "redirect:/";
	}

	@PostMapping("/login")
	public String login(HttpSession sesion, @Valid @ModelAttribute("loginUsuario") LoginUsuario loginUsuario,
			BindingResult validaciones, Model modelo) {

		this.servicioUsuarios.validarLogin(validaciones, loginUsuario);
		if (validaciones.hasErrors()) {
			modelo.addAttribute("usuario", new Usuario());
			return "login.jsp";
		}

		Usuario usuario2 = servicioUsuarios.obtenerUsuarioPorEmail(loginUsuario.getEmail());
		sesion.setAttribute("nombreCompletoUsuario", usuario2.getNombre() + " " + usuario2.getApellido());
		sesion.setAttribute("emailUsuario", usuario2.getEmail());
		sesion.setAttribute("idUsuario", usuario2.getId());

		return "redirect:/getGames?page=1";
	}

	@PostMapping("/register")
	public String register(HttpSession sesion, @Valid @ModelAttribute("usuario") Usuario usuario,
			BindingResult validaciones, Model modelo) {

		this.servicioUsuarios.validarRegistro(validaciones, usuario);
		if (validaciones.hasErrors()) {
			modelo.addAttribute("loginUsuario", new LoginUsuario());
			return "login.jsp";
		}

		Usuario usuario2 = servicioUsuarios.crearUsuario(usuario);
		sesion.setAttribute("nombreCompletoUsuario", usuario2.getNombre() + " " + usuario2.getApellido());
		sesion.setAttribute("emailUsuario", usuario2.getEmail());
		sesion.setAttribute("idUsuario", usuario2.getId());

		return "redirect:/getGames?page=1";
	}

}
