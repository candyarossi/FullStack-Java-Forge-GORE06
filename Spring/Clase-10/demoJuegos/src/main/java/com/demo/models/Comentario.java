package com.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "comentarios")
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 10, max = 400, message = "Debe contener entre 10 y 400 caracteres.")
	private String mensaje;

	@ManyToOne
	@JoinColumn(name = "id_videojuego")
	private Videojuego videojuego;

	public Comentario() {
		super();
		this.id = 0l;
		this.mensaje = "";
		this.videojuego = new Videojuego();
	}

	public Comentario(Long id, String mensaje, Videojuego videojuego) {
		super();
		this.id = id;
		this.mensaje = mensaje;
		this.videojuego = videojuego;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Videojuego getVideojuego() {
		return videojuego;
	}

	public void setVideojuego(Videojuego videojuego) {
		this.videojuego = videojuego;
	}

	@Override
	public String toString() {
		return "Comentario [id=" + id + ", mensaje=" + mensaje + ", videojuego=" + videojuego + "]";
	}
}
