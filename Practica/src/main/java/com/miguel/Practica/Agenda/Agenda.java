package com.miguel.Practica.Agenda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.vaadin.ui.Dependency.Type;



public class Agenda {
	
	
	private ArrayList<Contacto> contactos = new ArrayList<>();

	
	public Agenda() {
		//super();
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
	
	
	public void deleteContact(String telefono) {
		contactos.remove(telefono);
	}


	public Object getAgendasize() {
		return contactos.size();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public void escribirJson() {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (Writer writer = new FileWriter("contactos.json")) {
            gson.toJson(contactos, writer);
        } catch (IOException e) {}
	}
	public void leerJson() {
		Gson gson = new Gson();
		File	archivo  = new File("Output.json");
		FileReader fr = new FileReader(archivo);
    	Type userListType = new TypeToken<ArrayList<Contacto>>(){}.getType();
    	try {
			BufferedReader br = new BufferedReader(fr);
			//contacts = gson.fromJson(fr, userListType);
			 contactos = gson.fromJson(userJson, userListType);  
		   //String linea = br.readLine();
		   System.out.println(contacts.get(0));
    	} catch (Exception ex) {
    	    ex.printStackTrace();
    	}
	}*/
	
	
}