package nl.inholland.jessevanevert625868endassingment.Views.Components;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PurchaseTicketVBox {
    private final VBox purchaseTicketVBox = new VBox();
    private final HBox firtRow = new HBox();
    private final HBox secondRow = new HBox();
    private final HBox thirdRow = new HBox();
    private final Label roomLabel = new Label("Room: ");
    private final Label movieTitleLabel = new Label("Movie title: ");
    private final Label startLabel = new Label("Start: ");
    private final Label endLabel = new Label("End: ");
    private final Label numberOfSeats = new Label("No. of seats: ");
    private final ComboBox dropDown = new ComboBox();
    private final Label nameLabel = new Label("Name: ");
    private final TextField nameInput = new TextField();
    private final Button purchaseButton = new Button("Purchase");
    private final Button clearButton = new Button("Clear");

    public PurchaseTicketVBox() {
        this.createPurchaseTicketVBox();
        this.applyStyling();
    }

    private void createPurchaseTicketVBox(){
        firtRow.getChildren().addAll(roomLabel, movieTitleLabel);
        secondRow.getChildren().addAll(startLabel, numberOfSeats, dropDown, purchaseButton);
        thirdRow.getChildren().addAll(endLabel, nameLabel,nameInput, clearButton);
        purchaseTicketVBox.getChildren().addAll(firtRow, secondRow, thirdRow);
    }

    private void applyStyling(){
        firtRow.setSpacing(20);
        secondRow.setSpacing(20);
        thirdRow.setSpacing(20);
        roomLabel.setMinWidth(100);
        movieTitleLabel.setMinWidth(100);
        startLabel.setMinWidth(100);
        endLabel.setMinWidth(100);
        numberOfSeats.setMinWidth(100);
        dropDown.setMinWidth(149);
        nameLabel.setMinWidth(100);
        nameInput.setMinWidth(100);
        purchaseButton.setMinWidth(75);
        clearButton.setMinWidth(75);
    }

    public VBox getPurchaseTicketVBox(){
        return this.purchaseTicketVBox;
    }
}
