package com.example.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Test extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Test.class.getResource("test-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 280);

        stage.setTitle("Sistema de Registro de Asistencia");
        stage.getIcons().add(new Image(Test.class.getResourceAsStream("/images/logo.png")));

        stage.setResizable(false);

        // Mostrar primero, luego centrar
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
