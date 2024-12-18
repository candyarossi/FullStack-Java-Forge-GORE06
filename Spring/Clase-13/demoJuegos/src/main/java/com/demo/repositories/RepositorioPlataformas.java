package com.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.models.Plataforma;

@Repository
public interface RepositorioPlataformas extends CrudRepository<Plataforma, Long> {

}
