package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.Videojuego;
import com.demo.repositories.RepositorioVideojuegos;

@Service
public class ServicioVideojuegos {

	@Autowired
	private RepositorioVideojuegos repositorioVideojuegos;

	public List<Videojuego> obtenerTodosLosVideojuegos() {
		return (List<Videojuego>) this.repositorioVideojuegos.findAll();
	}

	public Videojuego obtenerPorId(Long id) {
		return this.repositorioVideojuegos.findById(id).orElse(null);
	}

	public Videojuego crear(Videojuego videojuego) {
		return this.repositorioVideojuegos.save(videojuego);
	}

	public Videojuego actualizar(Videojuego videojuego) {
		return this.repositorioVideojuegos.save(videojuego);
	}

	public void eliminar(Long id) {
		this.repositorioVideojuegos.deleteById(id);
	}

	public Videojuego obtenerMiVideojuego(Long id_usuario) {
		return this.repositorioVideojuegos.obtenerMiVideojuego(id_usuario).orElse(null);
	}
}
