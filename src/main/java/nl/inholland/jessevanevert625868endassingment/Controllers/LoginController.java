package nl.inholland.jessevanevert625868endassingment.Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import nl.inholland.jessevanevert625868endassingment.Models.DataObject;
import nl.inholland.jessevanevert625868endassingment.Models.Person;
import nl.inholland.jessevanevert625868endassingment.Views.LoginScene;
import nl.inholland.jessevanevert625868endassingment.Views.MainWindow;

public class LoginController {
    private final LoginScene loginScene = new LoginScene();
    private DataObject dataObject;

    public LoginController(DataObject dataObject) {
        this.dataObject = dataObject;
        loginScene.getLoginButton().setOnAction(this::onLoginButtonClick);
    }

    public void login(String username, String password){
        Person person = dataObject.getPersonByUsername(username);
        if(person.getPassword().equals(password)){
            MainController mainController = new MainController(dataObject);
            mainController.setView(person);
        }
        else{
            loginScene.getBadCredentialLabel().setVisible(true);
        }
    }

    public void onLoginButtonClick(ActionEvent actionEvent) {
        String username = loginScene.getUsernameInput().getText();
        String password = loginScene.getPasswordInput().getText();
        this.login(username, password);
    }


    public void setLoginScene(){
        MainWindow.mainWindow.setScene(loginScene.getView());
        MainWindow.mainWindow.show();
    }
}
