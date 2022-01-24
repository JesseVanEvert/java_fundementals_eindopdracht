package nl.inholland.jessevanevert625868endassingment.Controllers;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nl.inholland.jessevanevert625868endassingment.Models.Admin;
import nl.inholland.jessevanevert625868endassingment.Models.DataObject;
import nl.inholland.jessevanevert625868endassingment.Models.Movie;
import nl.inholland.jessevanevert625868endassingment.Models.Person;
import nl.inholland.jessevanevert625868endassingment.Views.Components.*;
import nl.inholland.jessevanevert625868endassingment.Views.LoginScene;
import nl.inholland.jessevanevert625868endassingment.Views.MainWindow;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private final Stage purchasedTicketPopup = new Stage();
    private DataObject dataObject;
    private Scene scene;
    private Movie selectedMovie;
    private


    public MainController(DataObject dataObject) {
        this.dataObject = dataObject;
        setListenerMovieRoom1TableView();
        setListenerMovieRoom2TableView();
        adminMenuBar.getManageShowingsMenuItem().setOnAction(this::onManageShowingMenuItemClick);
        adminMenuBar.getLogoutMenuItem().setOnAction(this::onLogoutMenuItemClick);
        purchaseTicketVBox.getPurchaseButton().setOnAction(this::onPurchaseButtonClick);
        purchaseTicketVBox.getClearButton().setOnAction(this::onClearButtonClick);
        adminManageShowingsHBox.getAddShowingButton().setOnAction(this::onAddShowingButtonClick);
    }

    public void onLogoutMenuItemClick(ActionEvent actionEvent){
        LoginController loginController = new LoginController(dataObject);
        loginController.setLoginScene();
    }

    public void onCancelButtonClick(ActionEvent actionEvent){
        this.purchasedTicketPopup.close();
    }

    public void onAddShowingButtonClick(ActionEvent actionEvent){
        String movieTitle = (String) adminManageShowingsHBox.getMovieTitleDropDown().getSelectionModel().getSelectedItem();
        String room = (String) adminManageShowingsHBox.getRoomDropDown().getSelectionModel().getSelectedItem();
        Movie movieInDatabase = dataObject.getMovieByTitle(movieTitle);
        int movieInDatabaseDuration = movieInDatabase.getDurationInMinutes();
        LocalDate date = adminManageShowingsHBox.getStartDatePicker().getValue();
        LocalDateTime startDate = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 0, 0);
        String startTime = adminManageShowingsHBox.getStartTimeInput().getText();
        String hoursString = this.getHoursFromString(startTime);
        String minutesString = this.getMinutesFromString(startTime);
        LocalDateTime startDateWithHours = startDate.plusHours(Integer.parseInt(hoursString));
        LocalDateTime startDateWitHourAndMinutes = startDateWithHours.plusMinutes(Integer.parseInt(minutesString));
        LocalDateTime endDateAndTime = startDateWitHourAndMinutes.plusMinutes(movieInDatabaseDuration);

        int movieId = dataObject.getRoomsMoviesCount() + 1;

        Movie movie = new Movie(movieId, startDateWitHourAndMinutes, endDateAndTime, movieTitle, 100, movieInDatabase.getPrice(), movieInDatabaseDuration);

        if(room.equals("Room 1"))
            dataObject.addMovieToRoom1(movie);
        else
            dataObject.addMovieToRoom2(movie);

        this.setTableViewItems();
    }

    public String getHoursFromString(String time){
        return time.length() < 2 ? time : time.substring(0, 2);
    }

    public String getMinutesFromString(String time){
        return time.length() < 2 ? time : time.substring(3, 5);
    }

    public void onClearButtonClick(ActionEvent actionEvent){
        room1TableView.getRoomTableView().getSelectionModel().clearSelection();
        purchaseTicketVBox.getMovieTitleLabel().setText("Movie: ");
        purchaseTicketVBox.getRoomLabel().setText("Room: ");
        purchaseTicketVBox.getStartLabel().setText("Start: ");
        purchaseTicketVBox.getEndLabel().setText("End: ");
        purchaseTicketVBox.getDropDown().setItems(null);
        purchaseTicketVBox.getNameInput().setText("");
        purchaseTicketVBox.getPurchaseTicketVBox().setVisible(false);
    }

    public void onManageShowingMenuItemClick(ActionEvent actionEvent){
        adminManageShowingsHBox.getAdminManageShowingsHBox().setVisible(true);
        String movieTitle = (String) adminManageShowingsHBox.getMovieTitleDropDown().getSelectionModel().getSelectedItem();
        Movie movie = dataObject.getMovieByTitle(movieTitle);
        setAdminManageShowingsHBox(movie);
    }

    public void onPurchaseButtonClick(ActionEvent actionEvent){
        VBox container = new VBox();
        Label popupLabel = new Label();
        if(purchaseTicketVBox.getNameInput().getText().isEmpty()){
            popupLabel.setText("You have to enter your name before you can purchase a ticket");
            container.getChildren().add(popupLabel);
        } else{
            Button confirm = new Button("Confirm");
            Button cancel = new Button("Cancel");
            popupLabel.setText("Hello " + purchaseTicketVBox.getNameInput().getText() + ", do you want to purchase "
                    + purchaseTicketVBox.getDropDown().getValue() + " movie ticket(s) for " + selectedMovie.getTitle() + "?");
            container.getChildren().addAll(popupLabel, confirm, cancel);
            confirm.setOnAction(this::onConfirmButtonClick);
            cancel.setOnAction(this::onCancelButtonClick);
        }

        Scene scene = new Scene(container);
        purchasedTicketPopup.setScene(scene);
        purchasedTicketPopup.show();
    }

    public void onConfirmButtonClick(ActionEvent actionEvent){
        int movieId = selectedMovie.getMovieId();
        int seats = (int)purchaseTicketVBox.getDropDown().getValue();
        dataObject.deductSeatsFromMovieRoom1(movieId, seats);
        dataObject.deductSeatsFromMovieRoom2(movieId, seats);
        this.setTableViewItems();
        purchasedTicketPopup.close();
        purchaseTicketVBox.getPurchaseTicketVBox().setVisible(false);
    }


    public void setPurchaseTicketVBoxData(Movie movie){
        purchaseTicketVBox.getMovieTitleLabel().setText("Movie: " + movie.getTitle());
        purchaseTicketVBox.getRoomLabel().setText("Room: 1");
        purchaseTicketVBox.getStartLabel().setText("Start: " + movie.getStart());
        purchaseTicketVBox.getEndLabel().setText("End: " + movie.getEnd());
        //Adding a zero to the dropdown would've been a design flaw, so it has not been added
        ObservableList seats = FXCollections.observableArrayList();
        for (int i = 1; i <= movie.getSeats(); i++){
            seats.add(i);
        }
        purchaseTicketVBox.getDropDown().setItems(seats);
        purchaseTicketVBox.getDropDown().getSelectionModel().selectFirst();
    }

    public void setAdminManageShowingsHBox(Movie movie){
        adminManageShowingsHBox.getAdminManageShowingsHBox().setVisible(true);
        List<String> movieTitlesArrayList = new ArrayList<>(dataObject.getAllMovieTitles());
        ObservableList<String> movieTitles = FXCollections.observableArrayList(movieTitlesArrayList);
        adminManageShowingsHBox.getMovieTitleDropDown().setItems(movieTitles);
        //De onderstaande regel breekt de code geen idee waarom
        //adminManageShowingsHBox.getPriceLabel().setText("Price: " + movie.getPrice());
        adminManageShowingsHBox.getMovieTitleDropDown().getSelectionModel().selectFirst();
        //Hard coded for now; has to change
        adminManageShowingsHBox.getNumberOfSeatsLabel().setText("No. of seats: " + 100);
        ObservableList<String> rooms = FXCollections.observableArrayList();
        rooms.addAll("Room 1", "Room 2");
        adminManageShowingsHBox.getRoomDropDown().setItems(rooms);
        adminManageShowingsHBox.getRoomDropDown().getSelectionModel().selectFirst();
        String moviePrice = Double.toString(dataObject.findMoviePriceByName(movie.getTitle()));
        adminManageShowingsHBox.getPriceLabel().setText("Price: " + moviePrice);
    }

    public void setListenerMovieRoom1TableView(){
        room1TableView.getRoomTableView().getSelectionModel().selectedItemProperty().addListener((Observable observable) -> {
            purchaseTicketVBox.getPurchaseTicketVBox().setVisible(true);
            int index = room1TableView.getRoomTableView().getSelectionModel().getSelectedIndex();
            selectedMovie = room1TableView.getRoomTableView().getItems().get(index);
            setPurchaseTicketVBoxData(selectedMovie);
        });
    }

    public void setListenerMovieRoom2TableView(){
        room2TableView.getRoomTableView().getSelectionModel().selectedItemProperty().addListener((Observable observable) -> {
            purchaseTicketVBox.getPurchaseTicketVBox().setVisible(true);
            int index = room2TableView.getRoomTableView().getSelectionModel().getSelectedIndex();
            selectedMovie = room2TableView.getRoomTableView().getItems().get(index);
            setPurchaseTicketVBoxData(selectedMovie);
        });
    }
    public void clearRoomTableViews(){
        room1TableView.getRoomTableView().getItems().clear();
        room2TableView.getRoomTableView().getItems().clear();
    }

    public void setTableViewItems(){
        this.clearRoomTableViews();

        List<Movie> room1MoviesArrayList = new ArrayList<>(dataObject.getRoom1MoviesSet());
        ObservableList<Movie> room1Movies = FXCollections.observableArrayList(room1MoviesArrayList);

        room1TableView.getRoomTableView().setItems(room1Movies);

        List<Movie> room2MoviesArrayList = new ArrayList<>(dataObject.getRoom2MoviesSet());
        ObservableList<Movie> room2Movies = FXCollections.observableArrayList(room2MoviesArrayList);

        room2TableView.getRoomTableView().setItems(room2Movies);
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

        this.setTableViewItems();

        scene = new Scene(screen);

        MainWindow.mainWindow.setScene(scene);
        MainWindow.mainWindow.show();
    }
}
