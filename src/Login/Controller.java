package Login;

import CreateAccount.accountController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import user.UserController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//----------------------------- DATABASE CONNECTION----------------------------------//
public class Controller implements Initializable {

    private LoginModel loginModel = new LoginModel();
    @FXML
    private Label dbstatus;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private Label credentials;

    public void initialize(URL url, ResourceBundle rb) { //checks to see if database is connected through label on the interface
        if (this.loginModel.isConnected()) {
            this.dbstatus.setText("Connected!");
        } else {
            this.dbstatus.setText("Not Connected!");
        }

    }

    @FXML
    public void Login(ActionEvent event) { //checks the credentials of user and pass and allows user to go to next stage.
        try {
            if (this.loginModel.isLogin(this.usernameField.getText(), this.passwordField.getText())) {
                Stage stage = (Stage) this.loginButton.getScene().getWindow();
                stage.close();
                Loggedin();
            } else {
                this.credentials.setText("Wrong Creditials");
            }
        } catch (Exception localException) {

        }
    }

    public void Loggedin() { //Creates a new stage and scene (dashboard)
        try {
            Stage userStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane) loader.load(getClass().getResource("/user/mainScreen.fxml").openStream());
            UserController userController = (UserController) loader.getController();

            Scene scene = new Scene(root);
            userStage.setScene(scene);
            userStage.setTitle("Dashboard");
            userStage.setResizable(false);
            userStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //--------------------------------LAYOUT FUNCTION-------------------------------------//
    @FXML
    private Button createAcc;

    @FXML
    public void handleAccClick() {
        Stage stage = (Stage) this.createAcc.getScene().getWindow();
        stage.close();
        try {
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane) loader.load(getClass().getResource("/CreateAccount/CreateAccount.fxml").openStream());
            accountController accouontController = (accountController) loader.getController();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Sign-up");
            stage.setResizable(false);
            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
