package com.proyectoclase5.clases;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Persona {
	private String nombre;
	private LocalDate fechaNacimiento;
	private int edad;
	private String email;
	private int id;
	public static int incrementId = 1;

	public Persona() {
		this("", "1970-01-01", "");
	}

	public Persona(String nombre, String fechaNacimiento) {
		this(nombre, fechaNacimiento, "");
	}

	public Persona(String nombre, String fechaNacimiento, String email) {
		this.nombre = nombre;
		this.fechaNacimiento = Persona.formatearFecha(fechaNacimiento);
		this.edad = this.calcularEdad();
		this.email = email;
		this.id = Persona.incrementId++;
	}

	public static int getIncrementId() {
		return incrementId;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = Persona.formatearFecha(fechaNacimiento);
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static LocalDate formatearFecha(String fecha) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(fecha, formatter);
		return date;
	}

	private int calcularEdad() {
		Period diferencia = Period.between(this.fechaNacimiento, LocalDate.now());
		int edadCalculada = diferencia.getYears();
		return edadCalculada;
	}

	@Override
	public String toString() {
		return "Id: " + this.getId() + ", Nombre: " + this.getNombre() + ", Fecha de Nacimiento: "
				+ this.getFechaNacimiento() + ", Edad: " + this.getEdad();
	}

}