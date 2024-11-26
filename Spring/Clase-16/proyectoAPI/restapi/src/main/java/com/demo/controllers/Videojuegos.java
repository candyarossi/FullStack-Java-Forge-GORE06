package com.demo.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.models.Videojuego;
import com.demo.rawg.InfoApi;
import com.demo.services.ServicioGeneros;
import com.demo.services.ServicioPlataformas;
import com.demo.services.ServicioVideojuegos;

@RestController
public class Videojuegos {

	@Autowired
	private ServicioVideojuegos servicioVideojuegos;

	@Autowired
	private ServicioGeneros servicioGeneros;

	@Autowired
	private ServicioPlataformas servicioPlataformas;

	@GetMapping("/todos")
	public ResponseEntity<HashMap<String, Object>> todos(@RequestParam("pagina") int pagina) {
		HashMap<String, Object> response = new HashMap<>();
		try {
			Page<Videojuego> paginaActual = servicioVideojuegos.obtenerTodosLosVideojuegos(pagina - 1, null);
			int paginasTotales = paginaActual.getTotalPages();
			response.put("videojuegosComunidad", paginaActual.getContent());
			response.put("cantPaginas", paginasTotales);
			response.put("videojuegos", InfoApi.get10Videogames(pagina));
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.I_AM_A_TEAPOT);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/generosyplataformas")
	public ResponseEntity<HashMap<String, Object>> generosyplataformas() {
		HashMap<String, Object> response = new HashMap<>();
		try {
			response.put("generos", servicioGeneros.obtenerTodos());
			response.put("plataformas", servicioPlataformas.obtenerTodas());
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.I_AM_A_TEAPOT);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/guardar")
	public ResponseEntity<Boolean> guardar(@RequestBody Videojuego videojuego) {
		try {
			servicioVideojuegos.crear(videojuego);
		} catch (Exception e) {
			return new ResponseEntity<>(false, HttpStatus.I_AM_A_TEAPOT);
		}
		return new ResponseEntity<>(true, HttpStatus.CREATED);
	}

	@PutMapping("/editar")
	public ResponseEntity<Boolean> editar(@RequestBody Videojuego videojuego) {
		try {
			servicioVideojuegos.actualizar(videojuego);
		} catch (Exception e) {
			return new ResponseEntity<>(false, HttpStatus.I_AM_A_TEAPOT);
		}
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@DeleteMapping("/eliminar")
	public ResponseEntity<Boolean> eliminar(@RequestParam("id") int id) {
		try {
			servicioVideojuegos.eliminar((long) id);
		} catch (Exception e) {
			return new ResponseEntity<>(false, HttpStatus.I_AM_A_TEAPOT);
		}
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@GetMapping("/detalle")
	public ResponseEntity<Videojuego> detalle(@RequestParam("id") int id, @RequestParam("fuente") String fuente) {
		Videojuego videojuego = new Videojuego();
		try {
			if (fuente.equals("api")) {
				videojuego = InfoApi.getVideogame(id);
			} else {
				videojuego = servicioVideojuegos.obtenerPorId((long) id);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.I_AM_A_TEAPOT);
		}
		return new ResponseEntity<>(videojuego, HttpStatus.OK);
	}
}
