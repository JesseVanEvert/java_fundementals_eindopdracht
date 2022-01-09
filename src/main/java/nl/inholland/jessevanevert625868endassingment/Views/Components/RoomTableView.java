package nl.inholland.jessevanevert625868endassingment.Views.Components;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import nl.inholland.jessevanevert625868endassingment.Models.Movie;

import java.time.LocalDateTime;

public class RoomTableView {
   private final TableView<Movie> roomTableView = new TableView<>();
   private final TableColumn<Movie, LocalDateTime> startColumn = new TableColumn<>("Start");
   private final TableColumn<Movie, LocalDateTime> endColumn = new TableColumn<>("End");
   private final TableColumn<Movie, Integer> seatsColumn = new TableColumn<>("Seats");
   private final TableColumn<Movie, Double> priceColumn = new TableColumn<>("Price");
   private final TableColumn<Movie, String> titleColumn = new TableColumn<>("Title");

    public RoomTableView() {
        this.createTableView();
    }

    private void createTableView(){
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        startColumn.setCellValueFactory(new PropertyValueFactory<>("start"));
        endColumn.setCellValueFactory(new PropertyValueFactory<>("end"));
        seatsColumn.setCellValueFactory(new PropertyValueFactory<>("seats"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        roomTableView.getColumns().addAll(titleColumn, startColumn, endColumn, seatsColumn, priceColumn);
    }

    public void addMovieToTableView(Movie movie){
        roomTableView.getItems().add(movie);
    }

    public TableView<Movie> getRoomTableView(){
        return this.roomTableView;
    }

}
