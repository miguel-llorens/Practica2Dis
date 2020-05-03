package com.miguel.Practica.Agenda;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.miguel.Practica.Agenda.Contacto;

public class AgendaTest {

	
	Agenda agenda = null;
	Contacto contacto = null;
	Contacto contacto2 = null;
	
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
	
	@Test
	public void InstanciarContacto()
	{
		assertEquals("Luis", contacto.getNombre());
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
	public void TestTelefono()
	{
		assertEquals(true, contacto.isValidTelefono(contacto.getTelefono()));
		
	}
	
	@Test
	public void TestEmail()
	{
		assertEquals(true, contacto.isValidEmail(contacto.getEmail()));
		
	}
	

}
