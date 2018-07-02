package com.converter.Component;

import com.vaadin.server.AbstractClientConnector;
import com.vaadin.server.AbstractExtension;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.TextField;

@UIScope
@SpringComponent
@SuppressWarnings("serial")
public class RestFilterButton extends AbstractExtension{

	public static void extend(TextField field) {
        new RestFilterButton().extend((AbstractClientConnector) field);
    }
	
}
