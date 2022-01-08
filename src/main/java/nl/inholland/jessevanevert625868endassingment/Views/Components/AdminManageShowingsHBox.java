package nl.inholland.jessevanevert625868endassingment.Views.Components;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.concurrent.Callable;

public class AdminManageShowingsHBox {
    private final HBox adminManageShowingsHBox = new HBox();
    private final VBox firstColumn = new VBox();
    private final VBox secondColumn = new VBox();
    private final VBox thirdColumn = new VBox();
    private final VBox fourthColumn = new VBox();
    private final VBox fifthColumn = new VBox();
    private final VBox sixthColumn = new VBox();
    private final Label movieTitleLabel = new Label("Movie title: ");
    private final Label roomLabel = new Label("Room: ");
    private final Label numberOfSeatsLabel = new Label("No. of seats: ");
    private final Label startLabel = new Label("Start: ");
    private final Label endLabel = new Label("End: ");
    private final Label priceLabel = new Label("Price: ");
    private final ComboBox movieTitleDropDown = new ComboBox();
    private final ComboBox roomDropDown = new ComboBox();
    private final DatePicker startDatePicker = new DatePicker();
    private final TextField startTimeInput = new TextField();
    private final Button addShowingButton = new Button("Add showing");
    private final Button clearButton = new Button("Clear");

    public AdminManageShowingsHBox() {
        this.createAdminManageShowingsHbox();
        this.applyStyling();
    }

    private void createAdminManageShowingsHbox(){
        firstColumn.getChildren().addAll(movieTitleLabel, roomLabel, numberOfSeatsLabel);
        secondColumn.getChildren().addAll(movieTitleDropDown, roomDropDown);
        thirdColumn.getChildren().addAll(startLabel, endLabel, priceLabel);
        fourthColumn.getChildren().add(startDatePicker);
        fifthColumn.getChildren().add(startTimeInput);
        sixthColumn.getChildren().addAll(addShowingButton, clearButton);
        adminManageShowingsHBox.getChildren().addAll(firstColumn, secondColumn, thirdColumn, fourthColumn, fifthColumn, sixthColumn);
    }

    private void applyStyling(){
        firstColumn.setMinWidth(100);
        secondColumn.setMinWidth(100);
        thirdColumn.setMinWidth(100);
        fourthColumn.setMinWidth(100);
        fifthColumn.setMinWidth(100);
        sixthColumn.setMinWidth(100);
    }

    public HBox getAdminManageShowingsHBox(){
        return this.adminManageShowingsHBox;
    }
}
