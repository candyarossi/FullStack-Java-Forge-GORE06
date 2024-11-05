package com.demo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.models.Usuario;

@Repository
public interface RepositorioUsuarios extends CrudRepository<Usuario, Long>{
	// Algunos métodos abstractos
	// Queries personalizadas
	Optional<Usuario> findByEmail(String email);
}
