package com.miguel.Practica;

import com.miguel.Practica.Agenda.Agenda;
import com.miguel.Practica.Agenda.Contacto;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class ContactForm extends FormLayout{
	
	Button save = new Button("Save", this::save);
    Button cancel = new Button("Cancel", this::cancel);
    TextField nombre = new TextField("Nombre");
    TextField apellido = new TextField("Apellidos");
    TextField telefono = new TextField("Telefono");
    TextField email = new TextField("Email");
    TextField empresa = new TextField("Empresa");
    
    

	public ContactForm() {
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
	
	
	
	
	public void save(Button.ClickEvent event) {
		
	}
	
	public void cancel(Button.ClickEvent event) {
		
	}
}
