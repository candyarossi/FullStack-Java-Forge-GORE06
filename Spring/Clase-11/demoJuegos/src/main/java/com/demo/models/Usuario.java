package com.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// @Column(nullable = false)
	@NotBlank(message = "Este es un campo requerido.")
	@Size(min = 3, message = "Debe contener al menos 3 caracteres.")
	private String nombre;

	// @Column(nullable = false)
	@NotBlank(message = "Este es un campo requerido.")
	@Size(min = 3, message = "Debe contener al menos 3 caracteres.")
	private String apellido;

	// @Column(nullable = false, unique = true)
	@NotBlank(message = "Este es un campo requerido.")
	@Email(message = "Debe ingresar un email válido.")
	private String email;

	// @Column(nullable = false)
	@NotBlank(message = "Este es un campo requerido.")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$", message = "La contraseña debe contener 8 caracteres o más, e incluir al menos una letra minúscula, una letra mayúscula y un número.")
	private String password;

	@Transient
	private String confirmarPassword;

	public Usuario() {
		super();
		this.id = 0l;
		this.nombre = "";
		this.apellido = "";
		this.email = "";
		this.password = "";
		this.confirmarPassword = "";
	}

	public Usuario(String nombre, String apellido, String email, String password, String confirmarPassword) {
		super();
		this.id = 0l;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.confirmarPassword = confirmarPassword;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmarPassword() {
		return confirmarPassword;
	}

	public void setConfirmarPassword(String confirmarPassword) {
		this.confirmarPassword = confirmarPassword;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", password=" + password
				+ "]";
	}
}
