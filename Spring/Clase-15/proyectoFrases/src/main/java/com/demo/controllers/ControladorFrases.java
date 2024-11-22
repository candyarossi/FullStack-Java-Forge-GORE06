package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.demo.models.Frase;
import com.demo.services.ServicioFavoritos;
import com.demo.services.ServicioFrases;
import com.demo.services.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorFrases {

	@Autowired
	private ServicioFrases servicio;

	@Autowired
	private ServicioFavoritos servicioFavoritos;

	@Autowired
	private ServicioUsuarios servicioUsuarios;

	@GetMapping("/frases") // todas las frases
	public String mostrarFrases(HttpSession sesion, Model modelo) {
		Long idUsuario = (Long) sesion.getAttribute("idUsuario");
		if (idUsuario == null) {
			return "redirect:/";
		}
		modelo.addAttribute("frases", this.servicio.obtenerTodas());
		modelo.addAttribute("favsUsuario", this.servicioUsuarios.obtenerPorId(idUsuario).getFrasesFavoritas());
		return "frases.jsp";
	}

	@GetMapping("/form/agregar") // vista de form de creación
	public String agregar(HttpSession sesion, Model modelo) {
		if (sesion.getAttribute("nombreCompleto") == null) {
			return "redirect:/";
		}
		modelo.addAttribute("frase", new Frase());
		return "agregar.jsp";
	}

	@GetMapping("/form/editar/{id}") // vista de form de edición
	public String editar(@PathVariable("id") Long id, HttpSession sesion, Model modelo,
			@ModelAttribute("frase") Frase frase) {
		if (sesion.getAttribute("nombreCompleto") == null) {
			return "redirect:/";
		}
		modelo.addAttribute("frase", this.servicio.obtenerPorId(id));
		return "editar.jsp";
	}

	@PostMapping("/guardar") // procesar form de creación
	public String guardar(HttpSession sesion, @Valid @ModelAttribute("frase") Frase frase, BindingResult validaciones) {
		if (sesion.getAttribute("nombreCompleto") == null) {
			return "redirect:/";
		}
		if (validaciones.hasErrors()) {
			return "agregar.jsp";
		}
		this.servicio.crear(frase);
		return "redirect:/frases";
	}

	@PutMapping("/actualizar/{id}") // procesar form de edición
	public String actualizar(@PathVariable("id") Long id, HttpSession sesion,
			@Valid @ModelAttribute("frase") Frase frase, BindingResult validaciones) {
		if (sesion.getAttribute("nombreCompleto") == null) {
			return "redirect:/";
		}
		if (validaciones.hasErrors()) {
			return "editar.jsp";
		}
		this.servicio.actualizar(frase);
		return "redirect:/frases";
	}

	@DeleteMapping("/eliminar/{id}") // eliminar una frase
	public String eliminar(@PathVariable("id") Long id, HttpSession sesion) {
		if (sesion.getAttribute("nombreCompleto") == null) {
			return "redirect:/";
		}
		this.servicio.eliminarPorId(id);
		return "redirect:/frases";
	}

	@GetMapping("/detalle/{id}") // vista de detalle
	public String detalle(@PathVariable("id") Long id, HttpSession sesion, Model modelo) {
		if (sesion.getAttribute("nombreCompleto") == null) {
			return "redirect:/";
		}
		modelo.addAttribute("frase", this.servicio.obtenerPorId(id));
		return "detalle.jsp";
	}

	// Extras para Cinturón Negro / Medalla Oro

	@GetMapping("/favoritos") // vista de favoritos
	public String vistaFavoritos(HttpSession sesion, Model modelo) {
		Long idUsuario = (Long) sesion.getAttribute("idUsuario");
		if (idUsuario == null) {
			return "redirect:/";
		}
		modelo.addAttribute("favsUsuario", this.servicioUsuarios.obtenerPorId(idUsuario).getFrasesFavoritas());
		return "favoritos.jsp";
	}

	@PostMapping("/agregarFav/{id}") // acción de añadir fav
	public String agregarFavorito(HttpSession sesion, @PathVariable("id") Long idFrase) {
		Long idUsuario = (Long) sesion.getAttribute("idUsuario");
		if (idUsuario == null) {
			return "redirect:/";
		}
		System.out.println("1");
		this.servicioFavoritos.agregarFavorito(idUsuario, idFrase);
		System.out.println("2");
		return "redirect:/frases";
	}

	@DeleteMapping("/quitarFav/{id}") // acción de borrar fav
	public String quitarFavorito(HttpSession sesion, @PathVariable("id") Long idFrase) {
		Long idUsuario = (Long) sesion.getAttribute("idUsuario");
		if (idUsuario == null) {
			return "redirect:/";
		}
		this.servicioFavoritos.quitarFavorito(idUsuario, idFrase);
		return "redirect:/frases";
	}

}
