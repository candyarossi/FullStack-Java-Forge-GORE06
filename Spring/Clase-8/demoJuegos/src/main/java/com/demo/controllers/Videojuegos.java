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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.rawg.InfoApi;
import com.demo.services.ServicioComentarios;
import com.demo.services.ServicioGeneros;
import com.demo.services.ServicioPlataformas;
import com.demo.services.ServicioVideojuegos;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import com.demo.interfaces.ManejoDeFechas;
import com.demo.models.Comentario;
import com.demo.models.Usuario;
import com.demo.models.Videojuego;

@Controller
@RequestMapping("/api")
public class Videojuegos implements ManejoDeFechas {

	@Autowired
	private ServicioVideojuegos servicioVideojuegos;

	@Autowired
	private ServicioComentarios servicioComentarios;

	@Autowired
	private ServicioGeneros servicioGeneros;

	@Autowired
	private ServicioPlataformas servicioPlataformas;

	@GetMapping("/getGames")
	public String getGames(HttpSession sesion, Model modelo) {
		Usuario usuario = (Usuario) sesion.getAttribute("usuario");
		if (usuario == null) {
			return "login.jsp";
		}
		try {
			modelo.addAttribute("videojuegos", InfoApi.get10Videogames(1));
			modelo.addAttribute("videojuegosComunidad", servicioVideojuegos.obtenerTodosLosVideojuegos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "videojuegos.jsp";
	}

	@GetMapping("/form/agregar")
	public String agregar(Model modelo) {
		modelo.addAttribute("videojuego", new Videojuego());
		modelo.addAttribute("generos", servicioGeneros.obtenerTodos());
		modelo.addAttribute("plataformas", servicioPlataformas.obtenerTodas());
		return "agregarVideojuego.jsp";
	}

	@PostMapping("/guardar")
	public String guardar(@Valid @ModelAttribute("videojuego") Videojuego videojuego, BindingResult validaciones,
			Model modelo) {
		if (validaciones.hasErrors()) {
			modelo.addAttribute("generos", servicioGeneros.obtenerTodos());
			modelo.addAttribute("plataformas", servicioPlataformas.obtenerTodas());
			return "agregarVideojuego.jsp";
		}
		servicioVideojuegos.crear(videojuego);
		return "redirect:/api/getGames";
	}

	@GetMapping("/form/editar/{id}")
	public String editar(@PathVariable("id") Long id, @ModelAttribute("videojuego") Videojuego videojuego,
			Model modelo) {
		modelo.addAttribute("videojuego", servicioVideojuegos.obtenerPorId(id));
		modelo.addAttribute("generos", servicioGeneros.obtenerTodos());
		modelo.addAttribute("plataformas", servicioPlataformas.obtenerTodas());
		return "editarVideojuego.jsp";
	}

	@PutMapping("/actualizar")
	public String actualizar(@Valid @ModelAttribute("videojuego") Videojuego videojuego, BindingResult validaciones,
			Model modelo) {
		if (validaciones.hasErrors()) {
			modelo.addAttribute("generos", servicioGeneros.obtenerTodos());
			modelo.addAttribute("plataformas", servicioPlataformas.obtenerTodas());
			return "editarVideojuego.jsp";
		}
		servicioVideojuegos.actualizar(videojuego);
		return "redirect:/api/getGames";
	}

	@DeleteMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		servicioVideojuegos.eliminar(id);
		return "redirect:/api/getGames";
	}

	// '?fuente=db' o '?fuente=api'
	@GetMapping("/detalle/{id}")
	public String detalle(@PathVariable("id") int id, @RequestParam("fuente") String fuente, Model modelo) {
		Videojuego videojuego = null;
		try {
			if (fuente.equals("api")) {
				videojuego = InfoApi.getVideogame(id);
			} else {
				videojuego = servicioVideojuegos.obtenerPorId((long) id);
			}
			modelo.addAttribute("videojuego", videojuego);
			modelo.addAttribute("comentario", new Comentario());
			modelo.addAttribute("fuente", fuente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "detalleVideojuego.jsp";
	}

	@PostMapping("/comentar")
	public String comentar(@Valid @ModelAttribute("comentario") Comentario comentario, BindingResult validaciones) {
		if (validaciones.hasErrors()) {
			return "detalleVideojuego.jsp";
		}
		servicioComentarios.crear(comentario);
		return "redirect:/api/getGames";
	}

}
