package nl.inholland.jessevanevert625868endassingment.Views.Components;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public abstract class BaseMenuBar {
    MenuBar menuBar = new MenuBar();
    Menu helpMenu = new Menu("Help");
    Menu logoutMenu = new Menu("Logout");
    MenuItem logoutMenuItem = new MenuItem("Logout...");
    MenuItem aboutMenuItem = new MenuItem("About");

    public BaseMenuBar() {
        this.createMenuBar();
    }

    protected void createMenuBar(){
        helpMenu.getItems().add(aboutMenuItem);
        logoutMenu.getItems().add(logoutMenuItem);
        menuBar.getMenus().addAll(helpMenu, logoutMenu);
    }

    public MenuBar getMenuBar(){
        return this.menuBar;
    }

    public Menu getHelpMenu() {
        return helpMenu;
    }

    public Menu getLogoutMenu() {
        return logoutMenu;
    }

    public MenuItem getLogoutMenuItem() {
        return logoutMenuItem;
    }

    public MenuItem getAboutMenuItem() {
        return aboutMenuItem;
    }
}
