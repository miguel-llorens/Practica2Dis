package com.miguel.Practica;

import com.miguel.Practica.Agenda.Agenda;
import com.miguel.Practica.Agenda.Contacto;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Binder;
import com.vaadin.data.ValidationException;
import com.vaadin.data.converter.StringToIntegerConverter;
import com.vaadin.data.validator.EmailValidator;
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

public class ContactForm extends FormLayout{
	
    enum State{
    	INVISIBLE,
    	NEW_CONTACT,
    	EDIT_CONTACT
    }
    	
	
	Button save = new Button("Save", this::save);
    Button cancel = new Button("Cancel", this::cancel);
    TextField nombre = new TextField("Nombre");
    TextField apellido = new TextField("Apellidos");
    TextField telefono = new TextField("Telefono");
    TextField email = new TextField("Email");
    TextField empresa = new TextField("Empresa");

    
    State currentState = State.INVISIBLE;
    
    Agenda agenda;
    Contacto contacto;
    Binder<Contacto> binder;
    
    

	public ContactForm(Agenda agendaPasada) {
		
		agenda = agendaPasada;
		
		binder = new Binder<>();
		
		
		
		//binder.forField(email).withValidator(new EmailValidator(
			//"No parece una direccion de correo valida"))
			//.bind(Contacto::getEmail, Contacto::setEmail);

		binder.forField(nombre).withValidator(
		    name -> name.length() >= 3,
		    "Debe contener minimo tres caracteres")
		  .bind(Contacto::getNombre, Contacto::setNombre);
		
		binder.forField(telefono)
			.withConverter(
			    new StringToIntegerConverter("Debe ser un número"))
			 .bind(Contacto::getTelefono, Contacto::setTelefono);
		
		binder.forField(apellido)
		  .bind(
		    Contacto::getApellidos,
		    Contacto::setApellidos);
		
		binder.forField(empresa)
		  .bind(
		    Contacto::getEmpresa,
		    Contacto::setEmpresa);
		
		configureComponents();
        buildLayout();
	}

	private void configureComponents() {
        /*
         * Highlight primary actions.
         *
         * With Vaadin built-in styles you can highlight the primary save button
         * and give it a keyboard shortcut for a better UX.
         */
        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
        save.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        setVisible(false);
    }
	
	
	
	private void buildLayout() {
        setSizeUndefined();
        setMargin(true);

        HorizontalLayout actions = new HorizontalLayout(save, cancel);
        actions.setSpacing(true);

        addComponents(actions, nombre, apellido, telefono, email, empresa);
    }
	
	public void editContact(Contacto contacto) {
		currentState = State.EDIT_CONTACT;
		setVisible(true);
	}
	
	public void newContact() {
		currentState = State.NEW_CONTACT;
		contacto = new Contacto();
		
		
		
		setVisible(true);
		
	}
	
	public void save(Button.ClickEvent event) {
		
	    try {
	        binder.writeBean(contacto);
	        // A real application would also save the updated person
	        // using the application's backend
			if (currentState == State.NEW_CONTACT) {
				agenda.addContact(contacto);
			}
	      } catch (ValidationException e) {
	        Notification.show("Person could not be saved, " +
	          "please check error messages for each field.");
	      }

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
