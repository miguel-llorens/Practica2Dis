package com.miguel.Practica.Agenda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.vaadin.ui.Dependency.Type;

public class Json {

	
	public Json() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean escribirJson(Agenda contactos) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (Writer writer = new FileWriter("contactos.json")) {
            gson.toJson(contactos, writer);
        } catch (IOException e) {}
		return true;
	}
	public Agenda leerJson(Agenda escriboAgenda, File archivo) throws FileNotFoundException {
		
//		JsonParser parser = new JsonParser();
//        FileReader fr = new FileReader("datos.json");
//        JsonElement datos = parser.parse(fr);
//        
        
        Gson gson = new Gson();
		escriboAgenda = gson.fromJson(new FileReader(archivo), Agenda.class);       
		return escriboAgenda;
	}
	
	
	
}
