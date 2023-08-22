package ru.akhitev.kb.javafx.swing.controller_with_constructor.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.testfx.api.FxToolkit;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit.ApplicationTest;
import ru.akhitev.kb.javafx.swing.controller_with_constructor.service.DateTimeService;

public class ControllerWithConstructorSpec extends ApplicationTest {
    private final String VALUE_FROM_SERVICE = "20190418";
    private ControllerWithConstructor controller;

    @After
    public void tearDown() throws Exception {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/controller_with_constructor/javafx_view.fxml"));
        DateTimeService mockedService = Mockito.mock(DateTimeService.class);
        Mockito.when(mockedService.getFormattedTime()).thenReturn(VALUE_FROM_SERVICE);
        controller = new ControllerWithConstructor(mockedService);
        loader.setController(controller);
        Parent mainNode = loader.load();
        stage.setScene(new Scene(mainNode));
        stage.toFront();
        stage.show();
    }

    @Test
    public void whenButtonClickedThenDateIsShown() {
        clickOn("Get Date From Service");
        String result = lookup("#result").queryText().getText();
        Assertions.assertThat(result)
                .as("When button clicked then correct date must be returned")
                .isEqualTo(VALUE_FROM_SERVICE);
    }
}
