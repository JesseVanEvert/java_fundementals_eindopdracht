package nl.inholland.jessevanevert625868endassingment;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.inholland.jessevanevert625868endassingment.Views.LoginScene;

import java.io.IOException;

public class MovieTheaterApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        LoginScene loginView = new LoginScene();

        Scene scene = loginView.getView();
        Stage window = new Stage();

        window.setScene(scene);

        window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}