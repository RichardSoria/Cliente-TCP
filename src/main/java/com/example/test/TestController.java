package com.example.test;

import ClienteTCP.clase.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TestController implements Initializable {

    @FXML
    private TextField nombreTextField;

    @FXML
    private MenuButton tipoRegistroMenuButton;

    private final String placeholder = "Seleccione tipo de registro";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nombreTextField.setFocusTraversable(false);
        tipoRegistroMenuButton.setFocusTraversable(false);

        // Asignar listeners a los MenuItems UNA sola vez
        for (MenuItem item : tipoRegistroMenuButton.getItems()) {
            item.setOnAction(e -> tipoRegistroMenuButton.setText(item.getText()));
        }

        // Inicializar texto del MenuButton con placeholder
        tipoRegistroMenuButton.setText(placeholder);
    }

    @FXML
    public void registrarAsistencia(ActionEvent actionEvent) throws Exception {
        String nombre = nombreTextField.getText().trim();
        String tipo = tipoRegistroMenuButton.getText();

        Cliente cliente = new Cliente();

        if (nombre.isEmpty()) {
            mostrarAlerta("Campo requerido", "Por favor, ingrese su nombre.", Alert.AlertType.WARNING);
            return;
        }

        if (tipo.equals(placeholder)) {
            mostrarAlerta("Campo requerido", "Por favor, seleccione el tipo de registro.", Alert.AlertType.WARNING);
            return;
        }

        mostrarAlerta("Aviso de registro", cliente.enviarRegistro(Cliente.formatearNombre(nombre), tipo.toLowerCase()), Alert.AlertType.INFORMATION);

        // Limpiar campos
        nombreTextField.clear();
        tipoRegistroMenuButton.setText(placeholder);
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        Stage alertStage = (Stage) alerta.getDialogPane().getScene().getWindow();
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
