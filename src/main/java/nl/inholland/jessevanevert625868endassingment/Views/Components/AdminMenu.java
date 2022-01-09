package nl.inholland.jessevanevert625868endassingment.Views.Components;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;

public class AdminMenu extends BaseMenuBar {
    private final Menu adminMenuBar = new Menu("Admin");
    private final VBox adminMenu = new VBox();
    private final MenuItem manageShowingsMenuItem = new MenuItem("Manage showings");
    private final MenuItem manageMoviesMenuItem = new MenuItem("Manage movies");

    public AdminMenu() {
        this.createAdminMenuBar();
    }

    private void createAdminMenuBar(){
        adminMenuBar.getItems().addAll(manageShowingsMenuItem, manageMoviesMenuItem);
        super.menuBar.getMenus().add(adminMenuBar);
        adminMenu.getChildren().add(menuBar);
    }

    public VBox getAdminMenu() {
        return adminMenu;
    }

    public MenuItem getManageShowingsMenuItem() {
        return manageShowingsMenuItem;
    }

    public MenuItem getManageMoviesMenuItem() {
        return manageMoviesMenuItem;
    }
}
