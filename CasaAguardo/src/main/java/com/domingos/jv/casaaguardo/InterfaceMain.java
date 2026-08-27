package com.domingos.jv.casaaguardo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.LoginView;

public class InterfaceMain extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        LoginView loginView = new LoginView();

        // Passa o layout da view para a Scene
        Scene scene = new Scene(loginView.getRoot(), 1200, 700);

        primaryStage.setTitle("Sistema CAPHO - Login");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.setResizable(true);
        primaryStage.show();    
    }
}
