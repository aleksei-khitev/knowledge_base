package ru.akhitev.kb.javafx.swing.controller_with_constructor;

import ru.akhitev.kb.javafx.swing.SwingApplication;

public class Launcher {
    public static void main(String[] args) {
        JavaFxControllerWithConstructorExample example = new JavaFxControllerWithConstructorExample();
        SwingApplication swingApplication = new SwingApplication(example);
        javax.swing.SwingUtilities.invokeLater(swingApplication::createAndShowGUI);
    }
}
