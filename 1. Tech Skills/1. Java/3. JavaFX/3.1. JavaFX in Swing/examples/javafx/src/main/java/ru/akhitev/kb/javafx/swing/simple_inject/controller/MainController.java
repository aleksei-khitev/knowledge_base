package ru.akhitev.kb.javafx.swing.simple_inject.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.time.LocalDateTime;

public class MainController {
    public Button writeTime;
    public Text result;

    @FXML
    public void initialize() {
        writeTime.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
           result.setText(LocalDateTime.now().toString());
        });
    }
}
