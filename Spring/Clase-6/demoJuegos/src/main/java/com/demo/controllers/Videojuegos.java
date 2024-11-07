package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.rawg.InfoApi;
import com.demo.services.ServicioVideojuegos;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import com.demo.interfaces.ManejoDeFechas;
import com.demo.models.Usuario;
import com.demo.models.Videojuego;

@Controller
@RequestMapping("/api")
public class Videojuegos implements ManejoDeFechas {

	@Autowired
	private ServicioVideojuegos servicioVideojuegos;

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
		return "agregarVideojuego.jsp";
	}

	@PostMapping("/guardar")
	public String guardar(@Valid @ModelAttribute("videojuego") Videojuego videojuego, BindingResult validaciones) {
		if (validaciones.hasErrors()) {
			return "agregarVideojuego.jsp";
		}
		servicioVideojuegos.crear(videojuego);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "detalleVideojuego.jsp";
	}

}
