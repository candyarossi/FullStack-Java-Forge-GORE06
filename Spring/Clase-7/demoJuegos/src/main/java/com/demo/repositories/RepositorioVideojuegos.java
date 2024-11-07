package com.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.models.Videojuego;

@Repository
public interface RepositorioVideojuegos extends CrudRepository<Videojuego, Long> {

}
