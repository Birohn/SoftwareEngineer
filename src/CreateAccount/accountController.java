package CreateAccount;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class accountController {

    @FXML
    private Hyperlink goBackToLogin;

    @FXML
    public void handleToLogin() { // Goes back to Login (Needs to be put into different controller)
        Stage stage = (Stage) this.goBackToLogin.getScene().getWindow();
        stage.close();
        try {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = (AnchorPane) loader.load(getClass().getResource("../Login/Login.fxml").openStream());
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
