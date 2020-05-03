package com.miguel.Practica.Agenda;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import com.google.gson.Gson;
import com.miguel.Practica.Agenda.Contacto;

public class AgendaTest {

	
	Agenda agenda = null;
	Contacto contacto = null;
	Contacto contacto2 = null;
	Contacto contactovacio;
	Json json = null;
	
	@Before
	public void Initialize()
	{
		agenda = new Agenda();
		contacto = new Contacto("Luis", "Llamazares", "ufv", "666666666",  "g@gmail.com", "g");
		contacto2 = new Contacto("Luis", "Llamazares", "ufv", "666666666",  "g", "g");
	}
	
	
	@Test
	public void AgendaVacia()
	{
		int expected = 0;
		assertEquals(expected, agenda.getAgendasize());
	}
	
	
//	@Test
//	public void ArrayContacto()
//	{
//		ArrayList<Contacto> getContactos();
//	}
	
//	public ArrayList<Contacto> getContactos() {
//		return contactos;
//	}
	
	
	@Test
	public void InstanciarContacto()
	{
		assertEquals("Luis", contacto.getNombre());
	}
	
	@Test
	public void TestContacto()
	{
		contactovacio = new Contacto();
	}
	
	
	@Test
	public void AddContacto()
	{
		agenda.addContact(contacto);
		assertEquals(1, agenda.getAgendasize());
	}
	
	@Test
	public void DeleteContacto()
	{
		agenda.addContact("Luis", "Llamazares", "ufv", "666666666",  "g", "h");
		agenda.deleteContact("666666666");
		assertEquals(1, agenda.getAgendasize());
	}
	
	@Test
	public void ContactoExistente()
	{
		
		assertEquals(contacto.getTelefono(), contacto2.getTelefono());
	}
	
	@Test
	public void TestNombre()
	{
		assertEquals(contacto.getNombre(), contacto2.getNombre());
	}
	
	@Test
	public void TestsetNombre()
	{
		String nombre =  contacto.getNombre();
		contacto.setNombre(nombre);
	}
	
	@Test
	public void TestApellido()
	{
		assertEquals(contacto.getApellidos(), contacto2.getApellidos());
	}
	
	@Test
	public void TestsetApellido()
	{
		String apellido =  contacto.getNombre();
		contacto.setApellidos(apellido);
	}
	
	@Test
	public void TestTelefono()
	{
		assertEquals(true, contacto.isValidTelefono(contacto.getTelefono()));
		
	}
	
	@Test
	public void TestsetTelefono()
	{
		String telefono =  contacto.getNombre();
		contacto.setTelefono(telefono);
	}
	
	@Test
	public void TestEmail()
	{
		assertEquals(true, contacto.isValidEmail(contacto.getEmail()));
		
	}
	
	@Test
	public void TestsetEmail()
	{
		String email =  contacto.getNombre();
		contacto.setEmail(email);
	}
	
	@Test
	public void TestEmpresa()
	{
		assertEquals(contacto.getEmpresa(), contacto2.getEmpresa());
	}
	
	@Test
	public void TestsetEmpresa()
	{
		String empresa =  contacto.getNombre();
		contacto.setEmpresa(empresa);
	}
	
	
	@Test
	public void TestDireccion()
	{
		assertEquals(contacto.getDireccion(), contacto2.getDireccion());
	}
	
	@Test
	public void TestsetDireccion()
	{
		String direccion =  contacto.getNombre();
		contacto.setDireccion(direccion);
	}
	
	
	
	
	
	
	
//	@Test
//	public void verifySimilar() {
//		String expected = "{\"nombre\":\"Luis\"}";
//		
//		try {
//			JSONAssert.assertEquals(
//					"{\"nombre\":\"Luis\"}", expected, JSONCompareMode.LENIENT);
//		} catch (JSONException e) {
//			assertFalse(false);
//		}
//		
//	}
	
	
	
	

}
