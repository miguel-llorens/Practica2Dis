package com.miguel.Practica;

import java.util.Set;

import javax.servlet.annotation.WebServlet;

import com.miguel.Practica.Agenda.Agenda;
import com.miguel.Practica.Agenda.Contacto;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Binder;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
	
	Agenda agenda = new Agenda();
	TextField find = new TextField();
    Grid<Contacto> contactList = new Grid<>(Contacto.class);
    Button botonNewContact = new Button("Nuevo Contacto");
    ContactForm contactForm = new ContactForm(agenda);	
    
    
    @Override
    protected void init(VaadinRequest request) {
    	agenda.addContact("Pablo", "Garcia","garcilados", "662506", "xsds", "sdfsd");
    	agenda.addContact("Luis", "Llamazares","vagabundo", "668", "loloito", "asd");

        configureComponents();
        buildLayout();
    }

    
    
    private void configureComponents() {
    	
    	botonNewContact.addClickListener(e -> contactForm.newContact());
    	
    	
    	find.setPlaceholder("Busca un contacto");
    	find.setValueChangeMode(ValueChangeMode.EAGER);
    	find.addValueChangeListener(e -> refreshContacts());
    	contactList.setItems(agenda.getContactos());
    	contactList.removeColumn("id");
    	contactList.removeColumn("empresa");
    	contactList.removeColumn("email");
    	contactList.removeColumn("direccion");
    	contactList.setColumnOrder("nombre","apellidos","telefono");
    	contactList.setSelectionMode(Grid.SelectionMode.SINGLE);
    	contactList.addSelectionListener(e -> {
    		Set<Contacto> setectedContact = contactList.getSelectedItems();
    		
    		if(!setectedContact.isEmpty()) {
        		contactForm.editContact(contactList.getSelectedItems().iterator().next());
    		}
    	});
    	
    	
    }
    
    private void buildLayout() {
        HorizontalLayout actions = new HorizontalLayout(find, botonNewContact);
        actions.setWidth("100%");
        find.setWidth("100%");
        actions.setExpandRatio(find, 1);

        VerticalLayout left = new VerticalLayout(actions, contactList);
        left.setSizeFull();
        contactList.setSizeFull();
        left.setExpandRatio(contactList, 1);

        HorizontalLayout mainLayout = new HorizontalLayout(left, contactForm);
        mainLayout.setSizeFull();
        mainLayout.setExpandRatio(left, 1);

        // Split and allow resizing
        setContent(mainLayout);
    }


    void refreshContacts() {
        refreshContacts(find.getValue());
    }
    
    private void refreshContacts(String stringFilter) {
        contactList.getDataProvider().refreshAll();
        
    }
    
    
    
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}