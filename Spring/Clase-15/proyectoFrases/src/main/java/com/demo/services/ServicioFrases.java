package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.Frase;
import com.demo.repositories.RepositorioFrases;

@Service
public class ServicioFrases {

	@Autowired
	private RepositorioFrases repositorio;

	// CRUD

	public Frase crear(Frase frase) {
		return this.repositorio.save(frase);
	}

	public Frase obtenerPorId(Long id) {
		return this.repositorio.findById(id).orElse(null);
	}

	public List<Frase> obtenerTodas() {
		return (List<Frase>) this.repositorio.findAll();
	}

	public Frase actualizar(Frase frase) {
		return this.repositorio.save(frase);
	}

	public void eliminarPorId(Long id) {
		this.repositorio.deleteById(id);
	}
}
