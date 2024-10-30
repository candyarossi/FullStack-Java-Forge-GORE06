package com.demo.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Videojuego {
	private String nombre;
	private String descripcion;
	private String portada;
	private LocalDate fecha_lanzamiento;
	private double rating;
	private ArrayList<String> generos;
	private ArrayList<String> plataformas;

	public Videojuego(String nombre, String descripcion, String portada, LocalDate fecha_lanzamiento, double rating,
			ArrayList<String> generos, ArrayList<String> plataformas) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.portada = portada;
		this.fecha_lanzamiento = fecha_lanzamiento;
		this.rating = rating;
		this.generos = generos;
		this.plataformas = plataformas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPortada() {
		return portada;
	}

	public void setPortada(String portada) {
		this.portada = portada;
	}

	public LocalDate getFecha_lanzamiento() {
		return fecha_lanzamiento;
	}

	public void setFecha_lanzamiento(LocalDate fecha_lanzamiento) {
		this.fecha_lanzamiento = fecha_lanzamiento;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public ArrayList<String> getGeneros() {
		return generos;
	}

	public void setGeneros(ArrayList<String> generos) {
		this.generos = generos;
	}

	public ArrayList<String> getPlataformas() {
		return plataformas;
	}

	public void setPlataformas(ArrayList<String> plataformas) {
		this.plataformas = plataformas;
	}

	@Override
	public String toString() {
		return "Videojuego [nombre=" + nombre + ", descripcion=" + descripcion + ", portada=" + portada
				+ ", fecha_lanzamiento=" + fecha_lanzamiento + ", rating=" + rating + ", generos=" + generos
				+ ", plataformas=" + plataformas + "]";
	}
}
