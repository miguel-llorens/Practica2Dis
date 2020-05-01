package com.miguel.Practica.Agenda;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class Agenda {
	
	
	private ArrayList<Contacto> contactos = new ArrayList<>();

	
	public Agenda() {
		super();
	}
	

	

	public ArrayList<Contacto> getContactos() {
		return contactos;
	}


	public void addContact(String nombre, String apellidos, String empresa, String telefono,String email, String direccion) {
		
		Contacto nuevoContacto = new Contacto(nombre, apellidos, empresa, telefono, email, direccion);
		contactos.add(nuevoContacto);
	}
	
	public void addContact(Contacto nuevoContacto) {	
		contactos.add(nuevoContacto);
	}
	
	
	public void deleteContact(int index) {
		contactos.remove(index);
	}
	public void escribirJson() {
		/*Gson gson = new Gson();
		String json = gson.toJson(contactos);
		try (Writer writer = new FileWriter("Output.json")) {
            writer.write(json);
        } catch (IOException e) {}*/
		
		try (Writer writer = new FileWriter("contactos.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(contactos, writer);
        } catch (IOException e) {}
	}
	public void leerJson() {
		
	}
	
	
}