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
	
<<<<<<< Updated upstream
	public Agenda() {
		super();

	}
=======
	
>>>>>>> Stashed changes
	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
<<<<<<< Updated upstream

	public ArrayList<Contacto> getContacto() {
		return contacto;
=======
	
	
	public void deleteContact(Contacto deletContatc) {
		contactos.remove(deletContatc);
>>>>>>> Stashed changes
	}

	public void setContacto(ArrayList<Contacto> contacto) {
		this.contacto = contacto;
	}



	
}