package com.converter.UI;

import org.springframework.beans.factory.annotation.Autowired;

import com.converter.Views.LoginScreenView;
import com.converter.Views.MainScreenView;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.Page;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@SpringUI
@Theme("mytheme")
public class MainUI extends UI{
	
	
	private SpringViewProvider sp;
	
	@Autowired
	public MainUI(SpringViewProvider sp) {
		this.sp = sp;
	}
	
	@Override
	protected void init(VaadinRequest request) {
		Responsive.makeResponsive(this);
		Page.getCurrent().setTitle("Excel converter");
		
		
		Navigator navigator = new Navigator(this, this);
        navigator.addProvider(sp);
        navigator.addView(MainScreenView.VIEW_NAME, MainScreenView.class);
        navigator.addView(LoginScreenView.VIEW_NAME, LoginScreenView.class);
        navigator.navigateTo(LoginScreenView.VIEW_NAME);
	}

}
