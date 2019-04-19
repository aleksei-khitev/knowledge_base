package ru.akhitev.kb.javafx.swing.auto_resizing;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import javax.swing.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;
import java.util.function.Consumer;

public class JavaFxInAutoResizingResizingExample implements Consumer<JPanel> {

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
        jPanel.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                fxPanel.setBounds(jPanel.getBounds());
            }

            @Override
            public void componentMoved(ComponentEvent e) {}

            @Override
            public void componentShown(ComponentEvent e) {}

            @Override
            public void componentHidden(ComponentEvent e) {}
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
