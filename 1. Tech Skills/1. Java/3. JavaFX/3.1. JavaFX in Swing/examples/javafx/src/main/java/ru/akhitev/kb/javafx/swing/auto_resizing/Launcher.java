package ru.akhitev.kb.javafx.swing.auto_resizing;

import ru.akhitev.kb.javafx.swing.SwingApplication;

public class Launcher {
    public static void main(String[] args) {
        JavaFxInAutoResizingResizingExample example = new JavaFxInAutoResizingResizingExample();
        SwingApplication swingApplication = new SwingApplication(example);
        javax.swing.SwingUtilities.invokeLater(swingApplication::createAndShowGUI);
    }
}
