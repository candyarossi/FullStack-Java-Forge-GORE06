package com.demo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.demo")
@EnableJpaRepositories("com.demo.repositories")
@EntityScan("com.demo.models")
public class DemoJuegosApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoJuegosApplication.class, args);
	}

	// GET -> Read / Leer-Obtener
	// POST -> Create / Crear
	// PUT -> Update / Modificación
	// DELETE -> Eliminar

	// CRUD -> Create/Read/Update/Delete
}
