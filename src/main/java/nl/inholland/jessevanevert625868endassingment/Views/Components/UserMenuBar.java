package nl.inholland.jessevanevert625868endassingment.Views.Components;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class UserMenuBar {
    MenuBar userMenuBar = new MenuBar();
    Menu helpMenu = new Menu("Help");
    Menu logoutMenu = new Menu("Logout");
    MenuItem logout = new MenuItem("Logout...");
    MenuItem about = new MenuItem("About");

    public UserMenuBar() {
        this.createMenuBar();
    }

    public void createMenuBar(){
        helpMenu.getItems().add(about);
        logoutMenu.getItems().add(logout);
        userMenuBar.getMenus().addAll(helpMenu, logoutMenu);
    }

    public MenuBar getUserMenuBar(){
        return this.userMenuBar;
    }
}
