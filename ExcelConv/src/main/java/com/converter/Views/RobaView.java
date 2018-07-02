package com.converter.Views;

import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.mapping.Filterable;
import org.springframework.beans.factory.annotation.Autowired;

import com.converter.Component.RestFilterButton;
import com.converter.Model.Roba;
import com.converter.Service.RobaService;
import com.vaadin.annotations.Theme;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.renderers.NumberRenderer;
import com.vaadin.ui.themes.ValoTheme;


@SuppressWarnings("serial")
@SpringComponent
@UIScope
@Theme("mytheme")
public class RobaView extends CssLayout implements View{

	public static final String VIEW_NAME = "robaView";
	
	private final RobaService robaSer;
	public Grid<Roba> grid = new Grid<>(Roba.class);
    public TextField filter;
    public Button newProduct;
    
    @Autowired
    public RobaView(RobaService robaSer) {
    	super();
    	this.robaSer = robaSer;
        setSizeFull();
        addStyleName("crud-pregled");
        HorizontalLayout topLayout = createTopBar();
        
        grid.setSizeFull();
        grid.addColumn(Roba -> Roba.getRobagrupa().getNaziv()).setCaption("Grupa robe").setId("grupa").setHidable(true);
        grid.setDataProvider(
				(sortOrders, offset, limit)->{
					Map<String, Boolean> sortOrder = sortOrders.stream()
                            .collect(Collectors.toMap(
                                    sort -> sort.getSorted(),
                                    sort -> sort.getDirection() == SortDirection.ASCENDING));

                    return robaSer.findAll(offset, limit, sortOrder).stream();
				},
				()-> robaSer.count()
        );
        grid.setColumns("sifra", "naziv", "jm", "grupa", "cena");
       
        VerticalLayout barAndGridLayout = new VerticalLayout();
        barAndGridLayout.addComponent(topLayout);
        barAndGridLayout.addComponent(grid);
        barAndGridLayout.setSizeFull();
        barAndGridLayout.setExpandRatio(grid, 1);
        barAndGridLayout.setStyleName("crud-main-layout");

        addComponent(barAndGridLayout);

    }

    public HorizontalLayout createTopBar() {
        filter = new TextField();
        filter.setStyleName("filter-tekstpolje");
        filter.setPlaceholder("Pretraga");
        RestFilterButton.extend(filter);
        
        filter.addValueChangeListener(event -> {});

        newProduct = new Button("Novi proizvod");
        newProduct.addStyleName(ValoTheme.BUTTON_PRIMARY);
        newProduct.setIcon(VaadinIcons.PLUS_CIRCLE);

        HorizontalLayout topLayout = new HorizontalLayout();
        topLayout.setWidth("100%");
        topLayout.addComponent(filter);
        topLayout.addComponent(newProduct);
        topLayout.setComponentAlignment(filter, Alignment.MIDDLE_LEFT);
        topLayout.setExpandRatio(filter, 1);
        topLayout.setStyleName("top-bar");
        return topLayout;
    }
    
    public RobaView getForm() {
    	return this;
    }
}
