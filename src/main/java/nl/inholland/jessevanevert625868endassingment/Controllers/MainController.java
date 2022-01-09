package nl.inholland.jessevanevert625868endassingment.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import nl.inholland.jessevanevert625868endassingment.Models.Admin;
import nl.inholland.jessevanevert625868endassingment.Models.DataObject;
import nl.inholland.jessevanevert625868endassingment.Models.Movie;
import nl.inholland.jessevanevert625868endassingment.Models.Person;
import nl.inholland.jessevanevert625868endassingment.Views.Components.*;
import nl.inholland.jessevanevert625868endassingment.Views.MainWindow;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    private final AdminManageShowingsHBox adminManageShowingsHBox = new AdminManageShowingsHBox();
    private final AdminMenu adminMenuBar = new AdminMenu();
    private final UserMenuBar userMenuBar = new UserMenuBar();
    private final PurchaseTicketVBox purchaseTicketVBox = new PurchaseTicketVBox();
    private final RoomTableView room1TableView = new RoomTableView();
    private final RoomTableView room2TableView = new RoomTableView();
    private final VBox screen = new VBox();
    private DataObject dataObject;
    private Scene scene;


    public MainController(DataObject dataObject) {
        this.dataObject = dataObject;
    }

    

    public void setView(Person person){
        if(person.getClass() == Admin.class){
             screen.getChildren().addAll(adminMenuBar.getAdminMenu(), room1TableView.getRoomTableView(), room2TableView.getRoomTableView(), adminManageShowingsHBox.getAdminManageShowingsHBox());
        }
        else{
            screen.getChildren().addAll(userMenuBar.getMenuBar(), room1TableView.getRoomTableView(), room2TableView.getRoomTableView(), purchaseTicketVBox.getPurchaseTicketVBox());
        }
        adminManageShowingsHBox.getAdminManageShowingsHBox().setVisible(false);
        purchaseTicketVBox.getPurchaseTicketVBox().setVisible(false);

        List<Movie> room1MoviesArrayList = new ArrayList<>(dataObject.getRoom1MoviesSet());
        ObservableList<Movie> room1Movies = FXCollections.observableArrayList(room1MoviesArrayList);

        room1TableView.getRoomTableView().setItems(room1Movies);

        List<Movie> room2MoviesArrayList = new ArrayList<>(dataObject.getRoom2MoviesSet());
        ObservableList<Movie> room2Movies = FXCollections.observableArrayList(room2MoviesArrayList);

        room2TableView.getRoomTableView().setItems(room2Movies);

        scene = new Scene(screen);

        MainWindow.mainWindow.setScene(scene);
        MainWindow.mainWindow.show();
    }
}
