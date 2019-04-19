package ru.akhitev.kb.javafx.swing.controller_with_constructor;

import ru.akhitev.kb.javafx.swing.SwingApplication;
import ru.akhitev.kb.javafx.swing.simple_inject.JavaFxInSwingPanel;

public class Launcher {
    public static void main(String[] args) {
        JavaFxControllerWithConstructorExample javaFxExample = new JavaFxControllerWithConstructorExample();
        SwingApplication swingApplication = new SwingApplication(javaFxExample);
        javax.swing.SwingUtilities.invokeLater(swingApplication::createAndShowGUI);
    }
}
