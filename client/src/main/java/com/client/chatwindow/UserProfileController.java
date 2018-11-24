package com.client.chatwindow;
import com.byron.CreateAccount.userInfo;
import com.byron.Login.LoginModel;
import com.byron.dbConn.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import com.byron.Login.Controller;
public class UserProfileController implements Initializable{
    @FXML
    private Label username;
    @FXML
    private Label status;
    @FXML
    private Label month;
    @FXML
    private Label country;
    @FXML
    private TextArea summary;
    public void initialize (URL url, ResourceBundle rb) {
        userInfoInsert();
        summary.setDisable(true);
        summary.setStyle("-fx-opacity: 1;-fx-text-inner-color: #FF01F3;");
    }
    public void closeApplication() throws Exception{

    }
    public void userInfoInsert() {
        ResultSet rs = null;
        Statement statement = null;
        Connection connection;
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement(/*ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE*/);
            String sql ="SELECT * FROM userInfo ";
            rs= statement.executeQuery(sql);
            for(int i =0; i < ChatController.userId; i++){
                rs.next();
            }
            username.setText(rs.getString(2) + " " + rs.getString(3));
            country.setText(rs.getString(5));
            month.setText(rs.getString(7) + " " + rs.getString(6) + ", " +rs.getString(8));
            status.setText(rs.getString(4));
            summary.setPromptText(rs.getString(9));

        }
        catch(SQLException ex) {
            ex.getErrorCode();
        }

    }
}
