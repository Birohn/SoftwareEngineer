package com.byron.Login;
import com.byron.CreateAccount.userInfo;
import com.byron.CreateAccount.AccountController;
import com.byron.dbConn.DatabaseConnection;
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
import com.byron.user.UserController;
import com.client.login.LoginController;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.sql.Connection;

import com.byron.Login.LoginModel;

import static com.client.chatwindow.ChatController.searchBarAutoComplete;

//----------------------------- DATABASE CONNECTION----------------------------------//
public class Controller implements Initializable {
    Connection connection;
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
                saveLogin();
            } else {
                this.credentials.setText("Wrong Creditials");
            }
        } catch (Exception localException) {

        }
    }

    public void Loggedin() { //Creates a new stage and scene (dashboard)
        try {
            searchBarAutoComplete();
            Stage userStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
//            Pane root = (Pane) loader.load(getClass().getResource("views/mainScreen.fxml").openStream());
            Pane root = (Pane) FXMLLoader.load(getClass().getClassLoader().getResource("views/LoginView.fxml"));
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
    public void saveLogin() throws Exception {
        ResultSet rs = null;
        Statement statement = null;
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement(/*ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE*/);
            String sql ="SELECT * FROM userInfo ";
            rs= statement.executeQuery(sql);
            for(int i =0; i < LoginModel.rowNum; i++){
                rs.next();
            }
            userInfo user = userInfo.getInstance();
            user.setFirstname(rs.getString(2));
            user.setLastname(rs.getString(3));
            user.setStatus(rs.getString(4));
            user.setCountry(rs.getString(5));
            user.setDay(rs.getString(6));
            user.setMonth(rs.getString(7));
            user.setYear(rs.getString(8));
            user.setSummary(rs.getString(9));

        }
        catch(SQLException ex) {
            ex.getErrorCode();
        }
        finally {
            rs.close();
            statement.close();
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
//            Pane root = (Pane) loader.load(getClass().getResource("views/CreateAccount.fxml").openStream());

            Pane root = (Pane) FXMLLoader.load(getClass().getClassLoader().getResource("views/CreateAccount.fxml"));
            AccountController accouontController = (AccountController) loader.getController();
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
