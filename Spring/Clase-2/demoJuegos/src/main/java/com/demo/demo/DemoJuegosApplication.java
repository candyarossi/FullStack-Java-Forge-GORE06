package com.demo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.demo")
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
