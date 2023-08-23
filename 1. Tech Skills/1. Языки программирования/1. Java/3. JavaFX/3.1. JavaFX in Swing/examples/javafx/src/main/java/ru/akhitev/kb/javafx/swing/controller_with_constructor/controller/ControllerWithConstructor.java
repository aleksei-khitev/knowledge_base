package ru.akhitev.kb.javafx.swing.controller_with_constructor.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import ru.akhitev.kb.javafx.swing.controller_with_constructor.service.DateTimeService;

import java.time.LocalDateTime;

public class ControllerWithConstructor {
    public Button invokeService;
    public Text result;
    private DateTimeService service;

    public ControllerWithConstructor(DateTimeService service) {
        this.service = service;
    }

    @FXML
    public void initialize() {
        invokeService.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            result.setText(service.getFormattedTime());
        });
    }
}
