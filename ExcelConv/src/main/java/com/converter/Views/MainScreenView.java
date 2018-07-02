package com.converter.Views;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;

@SpringView(name=MainScreenView.VIEW_NAME)
@UIScope
@Theme("mytheme")
@SuppressWarnings("serial")
public class MainScreenView extends SideMenu implements View{

	
	public static final String VIEW_NAME = "mainScreenView";
	
	private final RobaView robaview;
	private final ExcelView excelView;
	
	@Autowired
	public MainScreenView(RobaView robaview, ExcelView excelView) {
		this.robaview = robaview;
		this.excelView = excelView;
		Responsive.makeResponsive(this);
		setUserName(VaadinSession.getCurrent().getAttribute("Ime").toString());
        setSpacing(false);
        
        addMenuItem("Roba", VaadinIcons.BULLETS, new MenuClickHandler(){
			public void click(){
				setContent(robaview.getForm());
			}
		});
        
        addMenuItem("Excel", VaadinIcons.BULLETS, new MenuClickHandler(){
			public void click(){
				setContent(excelView.getForm());
			}
		});
        
        setSizeFull();
    }
	
}
