package com.proyectoclase5.clases;

import java.util.ArrayList;
import java.util.Random;

public class Estudiante extends Persona {
	private int nroLegajo;
	private String bootcamp;
	private String cohorte;
	public static ArrayList<Integer> legajos = new ArrayList<>();

	public Estudiante(String nombre, String fechaNacimiento, String email, String bootcamp, String cohorte) {
		super(nombre, fechaNacimiento, email);
		// Persona(nombre, fechaNacimiento, email);
		this.nroLegajo = this.generarNroLegajo();
		this.bootcamp = bootcamp;
		this.cohorte = cohorte;
		Estudiante.legajos.add(this.nroLegajo);
	}

	public String getBootcamp() {
		return bootcamp;
	}

	public void setBootcamp(String bootcamp) {
		this.bootcamp = bootcamp;
	}

	public String getCohorte() {
		return cohorte;
	}

	public void setCohorte(String cohorte) {
		this.cohorte = cohorte;
	}

	public int getNroLegajo() {
		return nroLegajo;
	}

	public static ArrayList<Integer> getLegajos() {
		return legajos;
	}

	private int generarNroLegajo() {
		Random random = new Random();
		int numeroRandom = 1000 + random.nextInt(9000); // 0 - 9999
		// 1234
		// 6789
		// 1234
		if (Estudiante.legajos.contains(numeroRandom)) {
			this.generarNroLegajo();
		}
		return numeroRandom;
	}

	@Override
	public String toString() {
		return "Estudiante: " + super.toString() + " [nroLegajo=" + nroLegajo + ", bootcamp=" + bootcamp + ", cohorte="
				+ cohorte + "]";
	}

}
