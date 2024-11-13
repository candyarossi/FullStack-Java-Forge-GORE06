package com.demo.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class LoginUsuario {

	@NotBlank(message = "Campo requerido.")
	@Email(message = "Debe ingresar un email válido.")
	private String email;

	@NotBlank(message = "Campo requerido.")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$", message = "La contraseña debe contener 8 caracteres o más, e incluir al menos una letra minúscula, una letra mayúscula y un número.")
	private String password;

	public LoginUsuario(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public LoginUsuario() {
		super();
		this.email = "";
		this.password = "";
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

}
