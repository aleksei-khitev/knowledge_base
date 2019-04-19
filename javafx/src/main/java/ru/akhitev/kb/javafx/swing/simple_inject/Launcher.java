package ru.akhitev.kb.javafx.swing.simple_inject;

import ru.akhitev.kb.javafx.swing.SwingApplication;

public class Launcher {
    public static void main(String[] args) {
        JavaFxInSwingPanel javaFxInSwingPanel = new JavaFxInSwingPanel();
        SwingApplication swingApplication = new SwingApplication(javaFxInSwingPanel);
        javax.swing.SwingUtilities.invokeLater(swingApplication::createAndShowGUI);
    }
}
