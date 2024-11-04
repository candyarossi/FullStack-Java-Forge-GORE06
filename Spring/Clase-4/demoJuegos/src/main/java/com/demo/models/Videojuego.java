package com.demo.models;

import java.time.LocalDate;
import java.util.ArrayList;

import com.demo.interfaces.ManejoDeFechas;

public class Videojuego implements ManejoDeFechas{
	// TODO Agregar id con sus getters y setters, modificar constructor y toString;
	private int id;
	private String nombre;
	private String descripcion;
	private String portada;
	private LocalDate fecha_lanzamiento;
	private double rating;
	private ArrayList<String> generos;
	private ArrayList<String> plataformas;

	public Videojuego(int id, String nombre, String descripcion, String portada, String fecha_lanzamiento,
			double rating, ArrayList<String> generos, ArrayList<String> plataformas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.portada = portada;
		// TODO implementar Manejo de fechas y su método
		this.fecha_lanzamiento = formatearFecha(fecha_lanzamiento);
		this.rating = rating;
		this.generos = generos;
		this.plataformas = plataformas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Videojuego [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", portada=" + portada
				+ ", fecha_lanzamiento=" + fecha_lanzamiento + ", rating=" + rating + ", generos=" + generos
				+ ", plataformas=" + plataformas + "]";
	}
}
