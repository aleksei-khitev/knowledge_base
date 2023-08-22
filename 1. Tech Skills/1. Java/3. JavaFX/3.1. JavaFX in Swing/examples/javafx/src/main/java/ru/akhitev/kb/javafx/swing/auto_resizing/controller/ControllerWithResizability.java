package ru.akhitev.kb.javafx.swing.auto_resizing.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ControllerWithResizability {
    public Button writeTime;
    public Text result;
    public VBox mainPane;

    @FXML
    public void initialize() {
        writeTime.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            result.setText(LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE));
        });
        mainPane.sceneProperty().addListener((observableScene, oldScene, newScene) -> {
            if (oldScene == null && newScene != null) {
                newScene.windowProperty().addListener((observableWindow, oldWindow, newWindow) -> {
                    if (oldWindow == null && newWindow != null) {
                        mainPane.getScene().getWindow().widthProperty().addListener((obs, oldVal, newVal) -> resizeScene());
                        mainPane.getScene().getWindow().heightProperty().addListener((obs, oldVal, newVal) -> resizeScene());
                    }
                });
            }
        });
    }

    private void resizeScene() {
        mainPane.setMinHeight(mainPane.getScene().getWindow().getHeight());
        mainPane.setMaxHeight(mainPane.getScene().getWindow().getHeight());
        mainPane.setMinWidth(mainPane.getScene().getWindow().getWidth());
        mainPane.setMaxWidth(mainPane.getScene().getWindow().getWidth());
    }
}
