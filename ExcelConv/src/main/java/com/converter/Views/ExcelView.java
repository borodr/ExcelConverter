package com.converter.Views;

import com.converter.Model.Komitent;
import com.converter.Model.NalogStavka;
import com.converter.Model.Roba;
import com.vaadin.annotations.Theme;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SuppressWarnings("serial")
@SpringComponent
@UIScope
@Theme("mytheme")
public class ExcelView extends VerticalLayout{

	public static final String VIEW_NAME = "excelView";
	
	public VerticalLayout rootPrviDio = new VerticalLayout();
	public VerticalLayout lijevo = new VerticalLayout();
	public HorizontalLayout hlLijevo = new HorizontalLayout();
	public HorizontalLayout hlDesno = new HorizontalLayout();
	
	
	public HorizontalLayout desno = new HorizontalLayout();
	public VerticalLayout desnoPrvi = new VerticalLayout();
	public VerticalLayout desnoDrugi = new VerticalLayout();
	public VerticalLayout desnoTreci = new VerticalLayout();
	public VerticalLayout desnoCetvrti = new VerticalLayout();
	
	
	public DateField datum = new DateField();
	public ComboBox<Komitent> veleprodaja = new ComboBox<>("Komitent");
	public Button otvoriNalog = new Button("Otvori nalog", VaadinIcons.FILE);
	public Button importFajl = new Button("Import Excel", VaadinIcons.CREDIT_CARD);
	public Button automObrada= new Button("Automatska obrada", VaadinIcons.HAMMER);
	
	
	public TextField robasifraext = new TextField();
	public TextField robanazivext = new TextField();
	public TextField kupacsifraext= new TextField();
	public TextField kupacnazivext= new TextField();
	public TextField cena= new TextField();
	public TextField kolicina= new TextField();
	public TextField iznos= new TextField();
	
	public ComboBox<Komitent> komitent = new ComboBox<>("Komitent");
	public ComboBox<Roba> roba = new ComboBox<>("Roba");
	public Button updateZapis=new Button("Ažuriraj stavku", VaadinIcons.UPLOAD);
	 

	public Grid<NalogStavka> gridStavke = new Grid<>(NalogStavka.class);
	
	public Panel panelPrvi = new Panel();

	public Panel panelDrugi = new Panel();
	
	public ExcelView() {
		setSizeFull();
		panelPrvi.setStyleName(ValoTheme.PANEL_BORDERLESS);
		panelDrugi.setStyleName(ValoTheme.PANEL_BORDERLESS);
		hlLijevo.addComponents(datum, veleprodaja, otvoriNalog);
		hlDesno.addComponents(importFajl, automObrada);
		lijevo.addComponents(hlLijevo, hlDesno);
		
		desnoPrvi.addComponents(robasifraext, robanazivext, kupacsifraext);
		desnoPrvi.setSizeUndefined();
		desnoDrugi.addComponents(kupacnazivext, cena, kolicina);
		desnoDrugi.setSizeUndefined();
		desnoTreci.addComponents(iznos);
		desnoTreci.setSizeUndefined();
		desnoCetvrti.addComponents(komitent, roba, updateZapis);
		desnoCetvrti.setSizeUndefined();
		
		desno.addComponents(desnoPrvi, desnoDrugi, desnoTreci, desnoCetvrti);
		rootPrviDio.addComponents(lijevo, desno);
		rootPrviDio.setSizeUndefined();
		panelPrvi.setContent(rootPrviDio);
		panelDrugi.setContent(gridStavke);
		
		addComponents(panelPrvi, panelDrugi);
	}
	
	public ExcelView getForm() {
		return this;
	}
	
}
