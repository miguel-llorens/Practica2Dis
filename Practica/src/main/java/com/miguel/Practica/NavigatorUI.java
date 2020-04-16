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
        final TextField name = new TextField("type name:");
        final TextField surname = new TextField("type surname:");
        final TextField business = new TextField("type business:");
        final TextField number = new TextField("type number:");
        final TextField email= new TextField("type email:");
        final TextField adress = new TextField("type adress:");
        

        Button button = new Button("Add Contact");
        button.addClickListener(e -> {
        	agenda.crearContacto(name.getValue(), surname.getValue(), business.getValue(), Integer.parseInt(number.getValue()), email.getValue(), adress.getValue());
            vlayout.addComponent(new Label("Thanks " + surname.getValue()
                   + ", it works!"));
        });
        /*Grid<Contacto> grid = new Grid<>(Contacto.class);
        grid.setItems(contactos);

        grid.removeColumnByKey("id");

        // The Grid<>(Person.class) sorts the properties and in order to
        // reorder the properties we use the 'setColumns' method.
        grid.setColumns("firstName", "lastName", "age", "address",
                "phoneNumber");*/
        hlayout.addComponents(name, surname, business, number, email, adress);
        vlayout.addComponents(hlayout, button);
        //surname, business, number, email, adress, 
        setContent(vlayout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = NavigatorUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
