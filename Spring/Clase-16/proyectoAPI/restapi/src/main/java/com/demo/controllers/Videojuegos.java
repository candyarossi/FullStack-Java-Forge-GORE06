package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import com.demo.services.ServicioGeneros;
import com.demo.services.ServicioPlataformas;
import com.demo.services.ServicioVideojuegos;

public class Videojuegos {

	@Autowired
	private ServicioVideojuegos servicioVideojuegos;

	@Autowired
	private ServicioGeneros servicioGeneros;

	@Autowired
	private ServicioPlataformas servicioPlataformas;

}
