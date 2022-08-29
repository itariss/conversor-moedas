package main;

import javax.swing.*;

public class App {

    private static final JFrame app = new JFrame();
    private static final Menu menuPrincipal = new Menu();

    public static void main(String[] args) {

        App.getApp().add(menuPrincipal.getMenu());
    }

    public static Menu getMenuPrincipal() {
        return menuPrincipal;
    }
    public static JFrame getApp() {

        app.setVisible(true);
        app.setSize(600, 400);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return app;
    }
}