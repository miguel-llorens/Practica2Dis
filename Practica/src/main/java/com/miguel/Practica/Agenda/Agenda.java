package com.miguel.Practica.Agenda;

import java.util.ArrayList;



public class Agenda {
	
	private String id;
	private ArrayList<Contacto> contacto;

	
	public Agenda(String id, ArrayList<Contacto> contacto) {
		super();
		this.contacto = contacto;
		this.id = id;
	}
	
	public Agenda() {
		super();

	}
	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Contacto> getContacto() {
		return contacto;
	}

	public void setContacto(ArrayList<Contacto> contacto) {
		this.contacto = contacto;
	}



	
}