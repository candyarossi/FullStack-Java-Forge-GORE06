package com.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.models.Frase;

@Repository
public interface RepositorioFrases extends CrudRepository<Frase, Long> {

}
