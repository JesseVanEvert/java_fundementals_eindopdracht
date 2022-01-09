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
import nl.inholland.jessevanevert625868endassingment.Views.Components.AdminManageShowingsHBox;
import nl.inholland.jessevanevert625868endassingment.Views.Components.PurchaseTicketVBox;
import nl.inholland.jessevanevert625868endassingment.Views.Components.UserMenuBar;

public class LoginScene {
    private final Label usernameLabel = new Label("Username:");
    private final TextField usernameInput = new TextField();
    private final Label passwordLabel = new Label("Password:");
    private final PasswordField passwordInput = new PasswordField();
    private final Button loginButton = new Button("Log in");
    private final Label badCredentialLabel = new Label("Bad credentials");

    Scene scene;

    public LoginScene() {
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
        GridPane.setConstraints(badCredentialLabel, 0, 5);
        this.badCredentialLabel.setVisible(false);

        gridPane.getChildren().addAll(usernameLabel, passwordLabel,
                usernameInput, passwordInput, loginButton, badCredentialLabel);

        scene = new Scene(gridPane);
    }

    public Scene getView(){
        return this.scene;
    }

    public Label getUsernameLabel() {
        return usernameLabel;
    }

    public TextField getUsernameInput() {
        return usernameInput;
    }

    public Label getPasswordLabel() {
        return passwordLabel;
    }

    public PasswordField getPasswordInput() {
        return passwordInput;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public Label getBadCredentialLabel() {
        return badCredentialLabel;
    }
}
