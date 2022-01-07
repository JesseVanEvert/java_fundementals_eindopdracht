package nl.inholland.jessevanevert625868endassingment.Views.Components;

import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import nl.inholland.jessevanevert625868endassingment.Models.Movie;

import java.time.LocalDateTime;

public class RoomTableView {
   private TableView roomTableView = new TableView();
   private final TableColumn<Movie, LocalDateTime> startColumn = new TableColumn<>("Start");
   private final TableColumn<Movie, LocalDateTime> endColumn = new TableColumn<>("End");
   private final TableColumn<Movie, Integer> seats = new TableColumn<>("Seats");
   private final TableColumn<Movie, Double> price = new TableColumn<>("Price");
   private final TableColumn<Movie, String> title = new TableColumn<>("Title");

    public RoomTableView() {
        this.createTableView();
    }

    private void createTableView(){
        startColumn.setCellValueFactory(new PropertyValueFactory<>("start"));
        startColumn.setCellValueFactory(new PropertyValueFactory<>("end"));
        startColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        startColumn.setCellValueFactory(new PropertyValueFactory<>("seats"));
        startColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        roomTableView.getColumns().addAll(startColumn, endColumn, title, seats, price);
    }

    public void addMovieToTableView(Movie movie){
        roomTableView.getItems().add(movie);
    }

    public TableView getRoomTableView(){
        return this.roomTableView;
    }

}
