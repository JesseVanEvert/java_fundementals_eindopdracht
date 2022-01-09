module nl.inholland.jessevanevert625868endassingment {
    requires javafx.controls;
    requires javafx.fxml;


    opens nl.inholland.jessevanevert625868endassingment to javafx.fxml;
    exports nl.inholland.jessevanevert625868endassingment;
    exports nl.inholland.jessevanevert625868endassingment.Models;
    opens nl.inholland.jessevanevert625868endassingment.Models to javafx.base, javafx.fxml;
}