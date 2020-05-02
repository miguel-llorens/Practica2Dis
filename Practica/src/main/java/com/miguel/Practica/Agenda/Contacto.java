package com.miguel.Practica.Agenda;

import java.util.regex.Pattern;

import org.hamcrest.Matcher;

public class Contacto {

	private String id;
	private String nombre;
	private String apellidos;
	private String empresa;
	private String telefono;
	private String email;
	private String direccion;

	public Contacto() {
		// TODO Auto-generated constructor stub
	}

	public Contacto(String nombre, String apellidos, String empresa, String telefono, String email, String direccion) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.empresa = empresa;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isValidTelefono(String s) {
		// The given argument to compile() method
		// is regular expression. With the help of
		// regular expression we can validate mobile
		// number.
		// 1) Begins with 0 or 91
		// 2) Then contains 7 or 8 or 9.
		// 3) Then contains 9 digits
		Pattern p = Pattern.compile("[0-9]{9}");

		// Pattern class contains matcher() method
		// to find matching between given number
		// and regular expression
		java.util.regex.Matcher m = p.matcher(s);
		return (m.find() && m.group().equals(s));
	}

	public boolean isValidEmail(String s) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

}
