package nl.inholland.jessevanevert625868endassingment.Views.Components;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class AdminMenuBar extends BaseMenuBar {
    Menu adminMenu = new Menu("Admin");
    MenuItem manageShowingsMenuItem = new MenuItem("Manage showings");
    MenuItem manageMoviesMenuItem = new MenuItem("Manage movies");

    public AdminMenuBar() {
        this.createAdminMenuBar();
    }

    private void createAdminMenuBar(){
        adminMenu.getItems().addAll(manageShowingsMenuItem, manageMoviesMenuItem);
        super.menuBar.getMenus().add(adminMenu);
    }
}
