package com.miguel.Practica;

import javax.servlet.annotation.WebServlet;

import com.miguel.Practica.Agenda.Agenda;
import com.miguel.Practica.Agenda.Contacto;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
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
public class NavigatorUI extends UI {
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	Agenda agenda = new Agenda();
   
        final HorizontalLayout hlayout = new HorizontalLayout();
        final VerticalLayout vlayout = new VerticalLayout();
        final TextField name = new TextField();
        name.setValue("Name");
        //name.setClearButtonVisible(true);
        final TextField surname = new TextField();
        final TextField business = new TextField();
        final TextField number = new TextField();
        final TextField email= new TextField();
        final TextField adress = new TextField();
        Button button = new Button("Add Contact");
        
        Grid<Contacto> grid = new Grid<>();
        grid.setWidth("100%");
    	grid.setItems(agenda.getContacto());
    	grid.addColumn(Contacto::getNombre).setCaption("Name");
    	grid.addColumn(Contacto::getApellidos).setCaption("Surname");
    	grid.addColumn(Contacto::getEmpresa).setCaption("Business");
    	grid.addColumn(Contacto::getTelefono).setCaption("Number");
    	grid.addColumn(Contacto::getEmail).setCaption("Email");
    	grid.addColumn(Contacto::getDireccion).setCaption("Adress");
    	
        
        button.addClickListener(e -> {
        	agenda.crearContacto(name.getValue(), surname.getValue(), business.getValue(), Integer.parseInt(number.getValue()), email.getValue(), adress.getValue());
        	grid.setItems(agenda.getContacto());
        	vlayout.addComponent(new Label("Contact Add " + name.getValue()
                   + ", it works!"));
        });
        
        hlayout.addComponents(name,surname,business,number,email,adress,button);
        vlayout.addComponents(hlayout, grid);
    	setContent(vlayout);
     
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = NavigatorUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
