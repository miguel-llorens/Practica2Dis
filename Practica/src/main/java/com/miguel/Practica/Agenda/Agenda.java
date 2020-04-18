package com.miguel.Practica.Agenda;
import com.google.gson.Gson;
import com.miguel.Practica.Agenda.Contacto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
		//asdas
	}

	public void setId(String id) {
		this.id = id;
	}
	public void crearContacto(String nombre, String apellidos, String empresa, int telefono, String email, String direccion) {
		Contacto contacto = new Contacto(nombre, apellidos, empresa, telefono, email, direccion);
		contactos.add(contacto);
	}

	public ArrayList<Contacto> getContacto() {
		return this.contactos;
	}
	//Leer Fichero
		public void LeerJson() {
			 
			   try {
				   
				   File	archivo  = new File("agenda.json");
				   FileReader fr = new FileReader(archivo);
				   
				   BufferedReader br = new BufferedReader(fr);
				   
				   String linea = br.readLine();
				   System.out.println(linea);
		}catch(IOException e) {
			   System.out.println("Errors");
		   }
			   
		}
		//Escribir Fichero
		public void GuardarJson(ArrayList<Contacto> contactos) {
		
			Gson gson = new Gson();
			String jsonAgenda = gson.toJson(contactos);
			 try {
				 
				 FileWriter myObj = new FileWriter("agenda.json");
				 myObj.write(jsonAgenda);
				 myObj.close();
				System.out.println("Correct writing");
				
			 }catch(IOException e) {
				   System.out.println("Errors");
			   }
		}

	
	
/*
	public void setContacto(ArrayList<Contacto> contacto) {
		this.contacto = contacto;
	}
*/	
}