package ru.akhitev.kb.javafx.swing.simple_inject;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import javax.swing.*;
import java.io.IOException;
import java.util.function.Consumer;

public class JavaFxInSwingPanel implements Consumer<JPanel> {

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
        // This method is invoked on the JavaFX thread
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }

    private Scene createScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/simple_inject/javafx_view.fxml"));
        return new  Scene(root, Color.ALICEBLUE);
    }

}
