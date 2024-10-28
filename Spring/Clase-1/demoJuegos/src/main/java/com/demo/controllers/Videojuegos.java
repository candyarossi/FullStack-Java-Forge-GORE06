package com.demo.controllers;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.interfaces.ManejoDeFechas;
import com.demo.models.Videojuego;

@RestController
@RequestMapping("/api")
public class Videojuegos implements ManejoDeFechas {
	private ArrayList<Videojuego> videojuegos;

	public Videojuegos() {
		this.videojuegos = new ArrayList<>();

		Videojuego v1 = new Videojuego("Silent Hill 2",
				"Having received a letter from his deceased wife, James heads to where they shared so many memories, in the hope of seeing her one more time: Silent Hill.",
				"", formatearFecha("2024-10-08"), 4.8, new ArrayList(Arrays.asList("Adventure", "Action")),
				new ArrayList(Arrays.asList("PC", "PlayStation")));
		Videojuego v2 = new Videojuego("Outlast",
				"Outlast follows the story of investigative journalist Miles Upshur, that got the lead on the inhuman experiments, performed on the asylum patients.",
				"", formatearFecha("2013-09-03"), 4.5, new ArrayList(Arrays.asList("Indie", "Action")),
				new ArrayList(Arrays.asList("PC", "PlayStation", "Xbox", "Nintendo")));
		Videojuego v3 = new Videojuego("Resident Evil 2",
				"The story follows the survivors of a zombie virus outbreak in the fictional Raccoon City.", "",
				formatearFecha("2019-01-25"), 4.3, new ArrayList(Arrays.asList("Shooter", "Action", "Adventure")),
				new ArrayList(Arrays.asList("PC", "PlayStation", "Xbox", "Nintendo")));

		this.videojuegos.add(v1);
		this.videojuegos.add(v2);
		this.videojuegos.add(v3);
	}

	// @RequestMapping("/saludo")
	// @RequestMapping(value = "/saludo", method = RequestMethod.GET)
	@GetMapping("/saludo")
	// http://localhost:8080/api/saludo
	public String inicio() {
		return "Hola Spring Boot!";
	}

	@GetMapping("/verJuegos")
	// http://localhost:8080/api/verJuegos
	public String verJuegos() {
		String str = "";
		for (int i = 0; i < videojuegos.size(); i++) {
			str += videojuegos.get(i).toString();
		}
		return str;
	}

	// Parámetros de Consulta -> Query String
	@GetMapping("/verJuego")
	// http://localhost:8080/api/verJuego?nombre=Outlast
	public String verJuegoPorNombre1(@RequestParam(value = "nombre") String nombre) {
		String str = buscar(nombre).toString();
		return str;
	}

	// Variables de Ruta -> Path Variables
	@GetMapping("/verJuego/{nombre}")
	// http://localhost:8080/api/verJuego/Outlast
	public String verJuegoPorNombre2(@PathVariable("nombre") String nombre) {
		String str = buscar(nombre).toString();
		return str;
	}

	private Videojuego buscar(String nombre) {
		Videojuego v = null;
		for (int i = 0; i < videojuegos.size(); i++) {
			if (videojuegos.get(i).getNombre().equalsIgnoreCase(nombre)) {
				v = videojuegos.get(i);
			}
		}
		return v;
	}
}
