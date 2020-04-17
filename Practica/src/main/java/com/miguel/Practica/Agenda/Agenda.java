package com.miguel.Practica.Agenda;

import java.util.ArrayList;



public class Agenda {
	
	
	private ArrayList<Contacto> contactos = new ArrayList<>();

	
	public Agenda() {
		super();
	}
	

	

	public ArrayList<Contacto> getContactos() {
		return contactos;
	}


	public void addContact(String nombre, String apellidos, String empresa, int telefono,String email, String direccion) {
		
		Contacto nuevoContacto = new Contacto(nombre, apellidos, empresa, telefono, email, direccion);
		contactos.add(nuevoContacto);
	}
	
	public void deleteContact(int index) {
		contactos.remove(index);
	}
	
	
	
}