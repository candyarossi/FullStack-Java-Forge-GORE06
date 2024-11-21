package com.demo.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.demo.models.LoginUsuario;
import com.demo.models.Usuario;
import com.demo.repositories.RepositorioUsuarios;

@Service
public class ServicioUsuarios {

	@Autowired
	private RepositorioUsuarios repositorio;

	// C -> Create
	public Usuario crear(Usuario usuario) {
		String hashPassword = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
		usuario.setPassword(hashPassword);
		return this.repositorio.save(usuario);
	}

	// R -> Read
	public List<Usuario> obtenerTodos() {
		return (List<Usuario>) this.repositorio.findAll();
	}

	public Usuario obtenerPorId(Long id) {
		return this.repositorio.findById(id).orElse(null);
	}

	public Usuario obtenerPorEmail(String email) {
		return this.repositorio.findByEmail(email).orElse(null);
	}

	// U -> Update
	public Usuario actualizar(Usuario usuario) {
		return this.repositorio.save(usuario);
	}

	// D -> Delete
	public void eliminarPorId(Long id) {
		this.repositorio.deleteById(id);
	}

	// Validamos en el registro si coinciden las contraseñas
	public BindingResult validarRegistro(BindingResult validaciones, Usuario usuario) {
		if (!usuario.getPassword().equals(usuario.getConfirmarPassword())) {
			validaciones.rejectValue("confirmarPassword", "passwordNoCoincide", "La contraseñas no coinciden.");
		}
		return validaciones;
	}

	// Validamos en el login si encontramos el email de usuario
	// Y si coinciden las contraseñas
	public BindingResult validarLogin(BindingResult validaciones, LoginUsuario usuario) {
		Usuario usuarioDb = this.obtenerPorEmail(usuario.getEmail());
		if (usuarioDb == null) {
			validaciones.rejectValue("email", "emailNoRegistrado",
					"El email ingresado no se encuentra en nuestra base de datos.");
		} else {
			if (!BCrypt.checkpw(usuario.getPassword(), usuarioDb.getPassword())) {
				validaciones.rejectValue("password", "passwordIncorrecta", "Contraseña incorrecta.");
			}
		}
		return validaciones;
	}

}
