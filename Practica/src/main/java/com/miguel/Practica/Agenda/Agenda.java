package com.miguel.Practica.Agenda;
import com.miguel.Practica.Agenda.Contacto;
import java.util.ArrayList;

import javax.swing.Spring;



public class Agenda {
	
	private String id;
	public ArrayList<Contacto> contactos = new ArrayList<Contacto>();

	public Agenda() {
		
	}
	/*public Agenda(String id, ArrayList<Contacto> contacto) {
		super();
		this.contactos = contacto;
		this.id = id;
	}*/
	
	/*public Agenda() {
		super();

	}*/
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public void crearContacto(String nombre, String apellidos, String empresa, int telefono, String email, String direccion) {
		Contacto contacto = new Contacto(nombre, apellidos, empresa, telefono, email, direccion);
		contactos.add(contacto);
	}

	/*public ArrayList<Contacto> getContacto() {
		return this.contactos;
	}

	public void setContacto(ArrayList<Contacto> contacto) {
		this.contacto = contacto;
	}
*/	
}