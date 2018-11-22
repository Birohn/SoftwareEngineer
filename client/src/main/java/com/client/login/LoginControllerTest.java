package com.client.login;

import com.byron.MainLauncher.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class LoginControllerTest extends ApplicationTest {
    @Override
    public void start(Stage stage) throws Exception {
        Parent mainNode = FXMLLoader.load(Main.class.getClassLoader().getResource("views/Login.fxml"));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    @Test
    public void loginAndLogout() {
        // Login using userId and password
        clickOn("#usernameField");
        write("Harnoor");
        clickOn("#passwordField");
        write("password");
        clickOn("#loginButton");
    }

    @Test
    public void loginWithIncorrectCredentials() {
        // Login using userId and password
        clickOn("#usernameField");
        write("123123");
        clickOn("#passwordField");
        write("123123");
        clickOn("#loginButton");
        // Check if incorrect Credentials is displayed
        verifyThat("#credentials", hasText("Wrong Creditials"));
    }

}