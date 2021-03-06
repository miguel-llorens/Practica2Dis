package com.miguel.Practica.Agenda;
import static org.junit.Assert.*;
import java.util.UUID;
import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class AppTest {

	
	Agenda agenda = null;
	Contacto contacto = null;
	Contacto contacto2 = null;
	Contacto contactovacio;
	Json json = null;
	
	@Before
	public void Initialize()
	{
		agenda = new Agenda();
		json = new Json();
		contacto = new Contacto("Luis", "Llamazares", "ufv", "666666666",  "g@gmail.com", "g",UUID.randomUUID().toString());
		contacto2 = new Contacto("Luis", "Llamazares", "ufv", "666666666",  "g", "g",UUID.randomUUID().toString());
	}
	
	
	@Test
	public void AgendaVacia()
	{
		int expected = 0;
		assertEquals(expected, agenda.getAgendasize());
	}
	
	
	@Test
	public void ArrayContacto()
	{
		assertEquals(agenda.getContactos(), agenda.getContactos());
	}
	
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
		agenda.addContact("Luis", "Llamazares", "ufv", "666666666",  "g", "h",UUID.randomUUID().toString());
		agenda.deleteContact(contacto);
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
	
	
	@Test
	public void JsonTestWrite() {
		
		assertTrue(json.escribirJson(agenda));
	}
	
	@Test
	public void JsonTestRead() throws FileNotFoundException {
		
		File jsonfile = new File("contactos.json");
		
		json.leerJson(jsonfile);
	}
	
}
