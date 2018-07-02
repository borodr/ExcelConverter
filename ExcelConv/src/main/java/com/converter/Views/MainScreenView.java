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
	private final RobaGrupeView rgview;
	private final ExcelView excelView;
	private final UstanovaView uview;
	private final RegionView rview;
	private final OrganizacionaJedinicaView orgview;
	
	@Autowired
	public MainScreenView(RobaView robaview, ExcelView excelView, RobaGrupeView rgview, UstanovaView uview, RegionView rview, OrganizacionaJedinicaView orgview) {
		this.robaview = robaview;
		this.excelView = excelView;
		this.rgview = rgview;
		this.uview = uview;
		this.rview = rview;
		this.orgview = orgview;
		Responsive.makeResponsive(this);
		setUserName(VaadinSession.getCurrent().getAttribute("Ime").toString());
        setSpacing(false);
        
        addMenuItem("Roba", VaadinIcons.BULLETS, new MenuClickHandler(){
			public void click(){
				setContent(robaview.getForm());
			}
		});
        
        addMenuItem("Roba grupe", VaadinIcons.FILE_TREE, new MenuClickHandler(){
			public void click(){
				setContent(rgview.getForm());
			}
		});
        
        addMenuItem("Ustanove", VaadinIcons.BUILDING, new MenuClickHandler(){
			public void click(){
				setContent(uview.getForm());
			}
		});
        
        addMenuItem("Organizaciona jedinica", VaadinIcons.BUILDING_O, new MenuClickHandler(){
			public void click(){
				setContent(orgview.getForm());
			}
		});
        
        addMenuItem("Region", VaadinIcons.AREA_SELECT, new MenuClickHandler(){
			public void click(){
				setContent(rview.getForm());
			}
		});
        
        addMenuItem("Excel", VaadinIcons.WORKPLACE, new MenuClickHandler(){
			public void click(){
				setContent(excelView.getForm());
			}
		});
        
        
        
        setSizeFull();
    }
	
}
