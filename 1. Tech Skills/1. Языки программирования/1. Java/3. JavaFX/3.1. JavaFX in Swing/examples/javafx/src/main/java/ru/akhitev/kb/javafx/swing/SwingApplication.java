package ru.akhitev.kb.javafx.swing;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class SwingApplication {
    private static final String FRAME_NAME = "HelloWorldSwing";
    private static final String SWING_LABEL_TEXT = "Hello World from Swing";
    private JFrame swingJFame;
    private JPanel swingJPanel;
    private Consumer<JPanel> javaFxApplier;

    public SwingApplication(Consumer<JPanel> javaFxApplier) {
        this.javaFxApplier = javaFxApplier;
    }

    public void createAndShowGUI() {
        swingJFame = prepareSwingFrame();
        swingJPanel = prepareSwingPanel();
        javaFxApplier.accept(swingJPanel);
        swingJFame.getContentPane().add(swingJPanel);
        show();
    }

    private JFrame prepareSwingFrame() {
        JFrame frame = new JFrame(FRAME_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

    private JPanel prepareSwingPanel() {
        JPanel swingPanel = new JPanel();
        Dimension dimension = new Dimension();
        dimension.setSize(600, 400);
        swingPanel.setPreferredSize(dimension);
        JLabel swingLabel = new JLabel(SWING_LABEL_TEXT);
        swingPanel.add(swingLabel);
        return swingPanel;
    }

    private void show() {
        swingJFame.pack();
        swingJFame.setVisible(true);
    }
}
