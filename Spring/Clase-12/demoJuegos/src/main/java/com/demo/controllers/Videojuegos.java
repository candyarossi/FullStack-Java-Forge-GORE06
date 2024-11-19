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
import org.springframework.web.multipart.MultipartFile;

import com.demo.rawg.InfoApi;
import com.demo.services.ServicioComentarios;
import com.demo.services.ServicioGeneros;
import com.demo.services.ServicioPlataformas;
import com.demo.services.ServicioVideojuegos;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import com.demo.interfaces.ManejoDeFechas;
import com.demo.models.Comentario;
import com.demo.models.Videojuego;

@Controller
@RequestMapping("/")
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
		if (sesion.getAttribute("idUsuario") == null) {
			return "redirect:/";
		}
		try {
			modelo.addAttribute("videojuegos", InfoApi.get10Videogames(1));
			modelo.addAttribute("videojuegosComunidad", servicioVideojuegos.obtenerTodosLosVideojuegos());
			modelo.addAttribute("miVideojuego",
					servicioVideojuegos.obtenerMiVideojuego((Long) sesion.getAttribute("idUsuario")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "videojuegos.jsp";
	}

	@GetMapping("/form/agregar")
	public String agregar(HttpSession sesion, Model modelo) {
		if (sesion.getAttribute("idUsuario") == null) {
			return "redirect:/";
		}
		modelo.addAttribute("videojuego", new Videojuego());
		modelo.addAttribute("generos", servicioGeneros.obtenerTodos());
		modelo.addAttribute("plataformas", servicioPlataformas.obtenerTodas());
		return "agregar.jsp";
	}

	@PostMapping("/guardar")
	public String guardar(HttpSession sesion, @Valid @ModelAttribute("videojuego") Videojuego videojuego,
			BindingResult validaciones, Model modelo, @RequestParam("imagen") MultipartFile imagen) {
		if (sesion.getAttribute("idUsuario") == null) {
			return "redirect:/";
		}
		if (validaciones.hasErrors()) {
			modelo.addAttribute("generos", servicioGeneros.obtenerTodos());
			modelo.addAttribute("plataformas", servicioPlataformas.obtenerTodas());
			return "agregar.jsp";
		}
		try {
			if (!imagen.isEmpty()) {
				String nombreImg = Imagenes.uploadImg(imagen);
				videojuego.setPortada(nombreImg);
			}
			servicioVideojuegos.crear(videojuego);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/getGames";
	}

	@GetMapping("/form/editar/{id}")
	public String editar(HttpSession sesion, @PathVariable("id") Long id,
			@ModelAttribute("videojuego") Videojuego videojuego, Model modelo) {
		if (sesion.getAttribute("idUsuario") == null) {
			return "redirect:/";
		}
		modelo.addAttribute("videojuego", servicioVideojuegos.obtenerPorId(id));
		modelo.addAttribute("generos", servicioGeneros.obtenerTodos());
		modelo.addAttribute("plataformas", servicioPlataformas.obtenerTodas());
		return "editar.jsp";
	}

	@PutMapping("/actualizar")
	public String actualizar(HttpSession sesion, @Valid @ModelAttribute("videojuego") Videojuego videojuego,
			BindingResult validaciones, Model modelo, @RequestParam("imagen") MultipartFile imagen) {
		if (sesion.getAttribute("idUsuario") == null) {
			return "redirect:/";
		}
		if (validaciones.hasErrors()) {
			modelo.addAttribute("generos", servicioGeneros.obtenerTodos());
			modelo.addAttribute("plataformas", servicioPlataformas.obtenerTodas());
			return "editar.jsp";
		}

		try {
			if (!imagen.isEmpty()) {
				boolean imgBorrada = Imagenes.deleteImg(videojuego.getPortada());
				if (imgBorrada) {
					String nombreImg = Imagenes.uploadImg(imagen);
					videojuego.setPortada(nombreImg);
				}
			}

			servicioVideojuegos.actualizar(videojuego);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/getGames";
	}

	@DeleteMapping("/eliminar/{id}")
	public String eliminar(HttpSession sesion, @PathVariable("id") Long id) {
		if (sesion.getAttribute("idUsuario") == null) {
			return "redirect:/";
		}
		servicioVideojuegos.eliminar(id);
		return "redirect:/getGames";
	}

	// '?fuente=db' o '?fuente=api'
	@GetMapping("/detalle/{id}")
	public String detalle(HttpSession sesion, @PathVariable("id") int id, @RequestParam("fuente") String fuente,
			Model modelo) {
		if (sesion.getAttribute("idUsuario") == null) {
			return "redirect:/";
		}
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
		return "detalle.jsp";
	}

	@PostMapping("/comentar/{id}")
	public String comentar(HttpSession sesion, @PathVariable("id") Long id, Model modelo,
			@Valid @ModelAttribute("comentario") Comentario comentario, BindingResult validaciones) {
		if (sesion.getAttribute("idUsuario") == null) {
			return "redirect:/";
		}
		if (validaciones.hasErrors()) {
			modelo.addAttribute("videojuego", servicioVideojuegos.obtenerPorId(id));
			modelo.addAttribute("fuente", "db");
			return "detalle.jsp";
		}
		servicioComentarios.crear(comentario);
		return "redirect:/detalle/" + id + "?fuente=db";
	}

}
