package com.demo.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "El campo es requerido.")
	@Size(min = 3, message = "Debe contener al menos 3 caracteres.")
	private String nombre;

	@NotBlank(message = "El campo es requerido.")
	@Size(min = 3, message = "Debe contener al menos 3 caracteres.")
	private String apellido;

	@Column(unique = true)
	@NotBlank(message = "El campo es requerido.")
	@Email(message = "Debe ser un correo electrónico válido.")
	private String email;

	@NotBlank(message = "El campo es requerido.")
	@Size(min = 8, message = "Debe contener al menos 8 caracteres.")
	private String password;

	@Transient
	private String confirmarPassword;

	@OneToMany(mappedBy = "creador")
	private List<Frase> frases;

	@ManyToMany
	@JoinTable(name = "favoritos", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_frase"))
	private List<Frase> frasesFavoritas;

	public Usuario() {
		super();
		this.id = 0l;
		this.nombre = "";
		this.apellido = "";
		this.email = "";
		this.password = "";
		this.confirmarPassword = "";
		this.frases = null;
	}

	public Usuario(Long id, String nombre, String apellido, String email, String password, String confirmarPassword,
			List<Frase> frases) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.confirmarPassword = confirmarPassword;
		this.frases = frases;
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

	public List<Frase> getFrases() {
		return frases;
	}

	public void setFrases(List<Frase> frases) {
		this.frases = frases;
	}

	public List<Frase> getFrasesFavoritas() {
		return frasesFavoritas;
	}

	public void setFrasesFavoritas(List<Frase> frasesFavoritas) {
		this.frasesFavoritas = frasesFavoritas;
	}

}
