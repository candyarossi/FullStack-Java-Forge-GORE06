package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.Comentario;
import com.demo.repositories.RepositorioComentarios;

@Service
public class ServicioComentarios {

	@Autowired
	private RepositorioComentarios repositorioComentarios;

	public Comentario crear(Comentario comentario) {
		return this.repositorioComentarios.save(comentario);
	}
}
