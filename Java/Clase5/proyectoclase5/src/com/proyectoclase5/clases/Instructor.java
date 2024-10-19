package com.proyectoclase5.clases;

import java.util.ArrayList;

public class Instructor extends Persona {
	private ArrayList<String> bootcamps;
	private ArrayList<Estudiante> estudiantes;

	public Instructor(String nombre, String fechaNacimiento, String email) {
		super(nombre, fechaNacimiento, email);
		this.bootcamps = new ArrayList<>();
		this.estudiantes = new ArrayList<>();
	}

	public ArrayList<String> getBootcamps() {
		return bootcamps;
	}

	public void setBootcamps(ArrayList<String> bootcamps) {
		this.bootcamps = bootcamps;
	}

	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public void agregarBootcamp(String bootcamp) {
		this.bootcamps.add(bootcamp);
	}

	public void agregarEstudiante(Estudiante estudiante) {
		this.estudiantes.add(estudiante);
	}

	@Override
	public String toString() {
		return "Instructor: \n" + super.toString() + " [bootcamps=" + bootcamps + ", estudiantes=" + estudiantes + "]";
	}

}
