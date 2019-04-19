package ru.akhitev.kb.javafx.swing.simple_inject;

import ru.akhitev.kb.javafx.swing.SwingApplication;

public class Launcher {
    public static void main(String[] args) {
        JavaFxInSwingExample example = new JavaFxInSwingExample();
        SwingApplication swingApplication = new SwingApplication(example);
        javax.swing.SwingUtilities.invokeLater(swingApplication::createAndShowGUI);
    }
}
