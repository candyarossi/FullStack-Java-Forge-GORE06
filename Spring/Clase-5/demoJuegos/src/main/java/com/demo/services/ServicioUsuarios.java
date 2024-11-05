package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.Usuario;
import com.demo.repositories.RepositorioUsuarios;

@Service
public class ServicioUsuarios {

	@Autowired
	private RepositorioUsuarios repositorioUsuarios;

	public List<Usuario> obtenerTodosLosUsuarios() {
		return (List<Usuario>) this.repositorioUsuarios.findAll();
	}

	public Usuario obtenerUsuarioPorId(Long id) {
		return this.repositorioUsuarios.findById(id).orElse(null);
	}

	public Usuario obtenerUsuarioPorEmail(String email) {
		return this.repositorioUsuarios.findByEmail(email).orElse(null);
	}

	public Usuario crearUsuario(Usuario usuario) {
		return this.repositorioUsuarios.save(usuario);
	}
}
