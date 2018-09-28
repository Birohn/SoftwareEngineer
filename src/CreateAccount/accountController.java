package CreateAccount;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import dbConn.DatabaseConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class accountController {
    @FXML
    private TextField userName;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField passwordCheck;
    @FXML
    private Label errorMessage;
    @FXML
    private Hyperlink goBackToLogin;
    private DatabaseConnection connected;
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
    public void initialize(URL url, ResourceBundle rb) {
        this.connected = new DatabaseConnection();
    }
    @FXML
    private void newAccount(ActionEvent event) {
        String insertLoginInfo = "INSERT INTO login(username,password) VALUES (?, ?)";
        String insertUserInfo = "INSERT INTO userInfo(fname,lname) VALUES (?, ?)";
        if(this.userName.getText().isEmpty()||this.password.getText().isEmpty()||this.firstName.getText().isEmpty()||this.lastName.getText().isEmpty()) {
        errorMessage.setText("There is an empty field!");
        }
        else if(!this.passwordCheck.getText().equals(this.password.getText())) {
        errorMessage.setText("Your password does not match! Check again!");


        }
        else {
            try {
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(insertLoginInfo);
                stmt.setString(1, this.userName.getText());
                stmt.setString(2, this.password.getText());
                stmt.execute();
                PreparedStatement stmt2 = conn.prepareStatement(insertUserInfo);
                stmt2.setString(1, this.firstName.getText());
                stmt2.setString(2, this.lastName.getText());
                stmt2.execute();
                conn.close();
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
            handleToLogin();

        }


    }
}
