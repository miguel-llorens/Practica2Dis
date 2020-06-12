package com.miguel.Practica;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.UUID;

import com.miguel.Practica.Agenda.Agenda;
import com.miguel.Practica.Agenda.Contacto;
import com.miguel.Practica.Agenda.Json;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Binder;
import com.vaadin.data.ValidationException;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ContactForm extends FormLayout {

	enum State {
		INVISIBLE, NEW_CONTACT, EDIT_CONTACT
	}

	Button save = new Button("Save", this::save);
	Button delete = new Button("Delete", this::delete);
	Button cancel = new Button("Cancel", this::cancel);
	TextField nombre = new TextField("Nombre");
	TextField apellido = new TextField("Apellidos");
	TextField telefono = new TextField("Telefono");
	TextField email = new TextField("Email");
	TextField empresa = new TextField("Empresa");
	TextField direccion = new TextField("Direccion");
	
	
	State currentState = State.INVISIBLE;

	Json json;
	Agenda agenda;
	Contacto contacto;
	Binder<Contacto> binder;
	String id = UUID.randomUUID().toString();
	
	public ContactForm(Agenda agendaPasada, Json jsonPasado) {

		agenda = agendaPasada;

		json = jsonPasado;

		binder = new Binder<>();
		
		

		binder.forField(email).bind(Contacto::getEmail, Contacto::setEmail);

		binder.forField(nombre).withValidator(name -> name.length() >= 3, "Debe contener minimo tres caracteres")
				.bind(Contacto::getNombre, Contacto::setNombre);

//		
		
		
		binder.forField(telefono)
				.withValidator(new RegexpValidator("Esto no es un numero de telefono", "^[0-9]{2,3}-? ?[0-9]{6,7}$"))
				.bind(Contacto::getTelefono, Contacto::setTelefono);

		binder.forField(apellido).bind(Contacto::getApellidos, Contacto::setApellidos);

		binder.forField(empresa).bind(Contacto::getEmpresa, Contacto::setEmpresa);
		
		binder.forField(direccion).bind(Contacto::getDireccion, Contacto::setDireccion);
		
		
	
		configureComponents();
		buildLayout();
	}

	private void configureComponents() {
		/*
		 * Highlight primary actions.
		 *
		 * With Vaadin built-in styles you can highlight the primary save button and
		 * give it a keyboard shortcut for a better UX.
		 */
		save.setStyleName(ValoTheme.BUTTON_PRIMARY);
		delete.setStyleName(ValoTheme.BUTTON_DANGER);
		save.setClickShortcut(ShortcutAction.KeyCode.ENTER);
		setVisible(false);
	}

	private void buildLayout() {
		setSizeUndefined();
        setMargin(true);
        
        VerticalLayout vertical = new VerticalLayout ();
        addComponents(nombre, apellido, telefono, email, empresa);
        HorizontalLayout actions = new HorizontalLayout(save, cancel);
        actions.setSpacing(true);
        addComponents(actions);
        HorizontalLayout eliminar = new HorizontalLayout(delete);
        
        addComponents(eliminar);
	}

	public void editContact(Contacto contactoEdit) {
		currentState = State.EDIT_CONTACT;
		contacto = contactoEdit;

		binder.readBean(contacto);

		setVisible(true);
	}

	public void newContact() {
		currentState = State.NEW_CONTACT;
		contacto = new Contacto();
		binder.readBean(contacto);

		setVisible(true);

	}
	
	public void save(Button.ClickEvent event) {

		try {
			binder.writeBean(contacto);
			// A real application would also save the updated person
			// using the application's backend
			if (currentState == State.NEW_CONTACT) {
				
				contacto.setId(UUID.randomUUID().toString());
				agenda.addContact(contacto);
				
			}
		} catch (ValidationException e) {
			Notification.show("No hemos podido guardar el contacto, " + "puede haber errores en algun campo.");
		}
		json.escribirJson(agenda);
		Notification.show("JSON generado con éxito");
		getUI().contactList.getDataProvider().refreshAll();
		currentState = State.INVISIBLE;
		setVisible(false);

	}

	public void delete(Button.ClickEvent event) {
		
		if (currentState == State.EDIT_CONTACT) {
			agenda.deleteContact(contacto);
			
		}

	    json.escribirJson(agenda);
		getUI().contactList.getDataProvider().refreshAll();
		currentState = State.INVISIBLE;
		setVisible(false);
	}

	public void cancel(Button.ClickEvent event) {

		currentState = State.INVISIBLE;
		setVisible(false);
	}

	@Override
	public MyUI getUI() {
		return (MyUI) super.getUI();
	}

}
