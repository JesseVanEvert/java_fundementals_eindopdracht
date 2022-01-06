package nl.inholland.jessevanevert625868endassingment.Views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nl.inholland.jessevanevert625868endassingment.Views.Components.AdminUserBar;
import nl.inholland.jessevanevert625868endassingment.Views.Components.UserMenuBar;

public class LoginView {
    Label usernameLabel = new Label("Username:");
    TextField usernameInput = new TextField();
    Label passwordLabel = new Label("Password:");
    PasswordField passwordInput = new PasswordField();
    Button loginButton = new Button("Log in");

    Scene scene;

    public LoginView() {
        this.createLoginView();
    }

    public void createLoginView(){
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(8);

        GridPane.setConstraints(usernameLabel, 0, 0);
        GridPane.setConstraints(usernameInput, 0, 1);
        GridPane.setConstraints(passwordLabel, 0, 2);
        GridPane.setConstraints(passwordInput, 0, 3);
        GridPane.setConstraints(loginButton, 0, 4);

        gridPane.getChildren().addAll(usernameLabel, passwordLabel,
                usernameInput, passwordInput, loginButton);
        AdminUserBar adminUserBar = new AdminUserBar();
        //UserMenuBar userMenuBar = new UserMenuBar();
        VBox vb = new VBox(adminUserBar.getMenuBar());
        scene = new Scene(vb);
    }

    public Scene getView(){
        return this.scene;
    }
}
