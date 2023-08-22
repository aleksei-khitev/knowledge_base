package ru.akhitev.kb.javafx.swing.controller_with_constructor;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import ru.akhitev.kb.javafx.swing.controller_with_constructor.controller.ControllerWithConstructor;
import ru.akhitev.kb.javafx.swing.controller_with_constructor.service.DateTimeService;

import javax.swing.*;
import java.io.IOException;
import java.util.function.Consumer;

public class JavaFxControllerWithConstructorExample implements Consumer<JPanel> {
    @Override
    public void accept(JPanel jPanel) {
        final JFXPanel fxPanel = new JFXPanel();
        jPanel.add(fxPanel);
        Platform.runLater(() -> {
            try {
                initFX(fxPanel);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void initFX(JFXPanel fxPanel) throws IOException {
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }

    private Scene createScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/controller_with_constructor/javafx_view.fxml"));
        DateTimeService service = new DateTimeService();
        ControllerWithConstructor controller = new ControllerWithConstructor(service);
        loader.setController(controller);
        Parent mainNode = loader.load();
        return new Scene(mainNode, Color.ALICEBLUE);
    }
}
