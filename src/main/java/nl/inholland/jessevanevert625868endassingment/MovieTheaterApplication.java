package nl.inholland.jessevanevert625868endassingment;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.inholland.jessevanevert625868endassingment.Controllers.LoginController;
import nl.inholland.jessevanevert625868endassingment.Models.DataObject;
import nl.inholland.jessevanevert625868endassingment.Views.LoginScene;

import java.io.IOException;

public class MovieTheaterApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        DataObject dataObject = new DataObject();
        LoginController loginController = new LoginController(dataObject);
        loginController.setLoginScene();
    }

    public static void main(String[] args) {
        launch();
    }
}