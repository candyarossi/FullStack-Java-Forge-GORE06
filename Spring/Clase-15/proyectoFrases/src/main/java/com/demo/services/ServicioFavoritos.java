package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.Frase;
import com.demo.models.Usuario;
import com.demo.repositories.RepositorioFrases;
import com.demo.repositories.RepositorioUsuarios;

@Service
public class ServicioFavoritos {

	@Autowired
	private RepositorioUsuarios repositorioUsuarios;

	@Autowired
	private RepositorioFrases repositorioFrases;

	public void agregarFavorito(Long idUsuario, Long idFrase) {
		Usuario usuario = this.repositorioUsuarios.findById(idUsuario).orElse(null);
		Frase frase = this.repositorioFrases.findById(idFrase).orElse(null);
		usuario.getFrasesFavoritas().add(frase);
		this.repositorioUsuarios.save(usuario);
	}

	public void quitarFavorito(Long idUsuario, Long idFrase) {
		Usuario usuario = this.repositorioUsuarios.findById(idUsuario).orElse(null);
		Frase frase = this.repositorioFrases.findById(idFrase).orElse(null);
		usuario.getFrasesFavoritas().remove(frase);
		this.repositorioUsuarios.save(usuario);
	}
}
