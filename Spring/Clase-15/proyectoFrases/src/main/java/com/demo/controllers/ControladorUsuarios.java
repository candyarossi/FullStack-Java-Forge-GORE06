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
public class ControladorUsuarios {

	@Autowired
	private ServicioUsuarios servicio;

	@GetMapping("/") // form de login
	public String formLogin(Model modelo) {
		modelo.addAttribute("loginUsuario", new LoginUsuario());
		return "login.jsp";
	}

	@GetMapping("/registro") // form de registro
	public String formRegistro(Model modelo) {
		modelo.addAttribute("usuario", new Usuario());
		return "register.jsp";
	}

	@GetMapping("/logout") // cierre de sesión
	public String logOut(HttpSession sesion) {
		sesion.invalidate();
		return "redirect:/";
	}

	@PostMapping("/login") // procesar info del login
	public String logIn(@Valid @ModelAttribute("loginUsuario") LoginUsuario loginUsuario, BindingResult validaciones,
			Model modelo, HttpSession sesion) {
		this.servicio.validarLogin(validaciones, loginUsuario);
		if (validaciones.hasErrors()) {
			return "login.jsp";
		}
		Usuario usuario = this.servicio.obtenerPorEmail(loginUsuario.getEmail());
		sesion.setAttribute("nombreCompleto", usuario.getNombre() + " " + usuario.getApellido());
		sesion.setAttribute("idUsuario", usuario.getId());
		return "redirect:/frases";
	}

	@PostMapping("/register") // procesar info del registro
	public String register(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult validaciones, Model modelo,
			HttpSession sesion) {
		this.servicio.validarRegistro(validaciones, usuario);
		if (validaciones.hasErrors()) {
			return "register.jsp";
		}
		Usuario usuario2 = this.servicio.crear(usuario);
		sesion.setAttribute("nombreCompleto", usuario2.getNombre() + " " + usuario2.getApellido());
		sesion.setAttribute("idUsuario", usuario2.getId());
		return "redirect:/frases";
	}

}
