package com.converter.Views;

import com.vaadin.annotations.Theme;
import com.vaadin.event.ShortcutAction;
import com.vaadin.navigator.View;
import com.vaadin.server.Responsive;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SuppressWarnings("serial")
@UIScope
@SpringView(name=LoginScreenView.VIEW_NAME)
@Theme("mytheme")
public class LoginScreenView extends CssLayout implements View{

	public static final String VIEW_NAME = "loginView";
	
	public TextField username;
	public PasswordField password;
	public Button login;
	public Button forgotPassword;
	
    
    public LoginScreenView() {
    	Responsive.makeResponsive(this);
        buildUI();
        username.focus();
    }

    private void buildUI() {
        addStyleName("login-pocetniPregled");

        Component loginForm = buildLoginForm();

        VerticalLayout centeringLayout = new VerticalLayout();
        centeringLayout.setMargin(false);
        centeringLayout.setSpacing(false);
        centeringLayout.setStyleName("centriran-layout");
        centeringLayout.addComponent(loginForm);
        centeringLayout.setComponentAlignment(loginForm,
                Alignment.MIDDLE_CENTER);

        CssLayout loginInformation = buildLoginInformation();

        addComponent(centeringLayout);
        addComponent(loginInformation);
    }

    private Component buildLoginForm() {
        FormLayout loginForm = new FormLayout();

        loginForm.addStyleName("login-forma");
        loginForm.setSizeUndefined();
        loginForm.setMargin(false);

        loginForm.addComponent(username = new TextField("Korisničko ime", "admin"));
        username.setWidth(15, Unit.EM);
        loginForm.addComponent(password = new PasswordField("Šifra"));
        password.setWidth(15, Unit.EM);
        password.setDescription("Sta god da ukucas ne radi.");
        CssLayout buttons = new CssLayout();
        buttons.setStyleName("buttons");
        loginForm.addComponent(buttons);

        buttons.addComponent(login = new Button("Login"));
        login.setDisableOnClick(true);

        login.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        login.addStyleName(ValoTheme.BUTTON_FRIENDLY);

        buttons.addComponent(forgotPassword = new Button("Zaboravili ste lozinku?"));
        
        forgotPassword.addStyleName(ValoTheme.BUTTON_LINK);
        return loginForm;
    }

    private CssLayout buildLoginInformation() {
        CssLayout loginInformation = new CssLayout();
        loginInformation.setStyleName("login-informacije");
        Label loginInfoText = new Label(
                "<h1>RND ExcelConverter</h1>"
                + "<strong>RnD Smart Tech</strong><br>"
                + "76300 Bijeljina<br>"
                + "<strong>e-mail</strong>: rndwebdevelopers@gmail.com<br>",
                ContentMode.HTML);
        loginInfoText.setSizeFull();
        loginInformation.addComponent(loginInfoText);
        return loginInformation;
    }

}
