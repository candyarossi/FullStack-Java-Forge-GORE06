package com.proyectoclase5.clases;

import java.util.ArrayList;
import java.util.Random;

import com.proyectoclase5.interfaces.CalculosMatematicos;

public class Estudiante extends Persona implements CalculosMatematicos {
	private int nroLegajo;
	private String bootcamp;
	private String cohorte;
	private ArrayList<Integer> calificaciones;
	public static ArrayList<Integer> legajos = new ArrayList<>();

	public Estudiante(String nombre, String fechaNacimiento, String email, String bootcamp, String cohorte) {
		super(nombre, fechaNacimiento, email);
		// Persona(nombre, fechaNacimiento, email);
		this.nroLegajo = this.generarNroLegajo();
		this.bootcamp = bootcamp;
		this.cohorte = cohorte;
		this.calificaciones = new ArrayList<>();
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

	public ArrayList<Integer> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(ArrayList<Integer> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public static ArrayList<Integer> getLegajos() {
		return legajos;
	}

	private int generarNroLegajo() {
		Random random = new Random();
		int numeroRandom = 1000 + random.nextInt(9000);
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

	@Override
	public double calcularPromedio() {
		int suma = 0;
		for (int i = 0; i < this.calificaciones.size(); i++) {
			suma += this.calificaciones.get(i);
		}
		return suma / this.calificaciones.size();
	}

	@Override
	public String verCalificaciones() {
		return this.getNombre() + ": " + this.getCalificaciones();
	}

}
