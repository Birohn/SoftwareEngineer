package com.client.chatwindow;
import com.byron.CreateAccount.userInfo;
import com.byron.Login.LoginModel;
import com.byron.dbConn.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {
    @FXML
    private TextField birthDay;
    @FXML
    private TextField birthYear;
    @FXML
    private TextField status;
    @FXML
    private TextArea summary;
    @FXML
    private ComboBox<Month> month;
    @FXML
    private ComboBox<Countries> country;
    @FXML
    private Label firstName;
    @FXML
    private Label lastName;
    @FXML
    private Label profileusernameLabel;
    @FXML
    private ImageView userImageView;
    @FXML
    private ImageView closeButtom;
    private DatabaseConnection connected;
    protected void showProfileUsername(String username) {
        this.profileusernameLabel.setText(username);
    }
    public void setImageLabel() throws IOException {
        this.userImageView.setImage(new Image(getClass().getClassLoader().getResource("images/Dominic.png").toString()));
    }
    public void closeApplication() {
        Stage stage = (Stage)closeButtom.getScene().getWindow();
        stage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        userInfo users = userInfo.getInstance();
        status.setText(users.getStatus());
        birthDay.setText(users.getDay());
        lastName.setText(users.getLastname());
        firstName.setText(users.getFirstname());
        showProfileUsername(users.getFirstname());
        month.setPromptText(users.getMonth());
        month.getItems().setAll(Month.values());
        country.setPromptText(users.getCountry());
        country.getItems().setAll(Countries.values());
        birthYear.setText(users.getYear());
        summary.setText(users.getSummary());
    }
    public void profileUpdate() {
        Connection connection;
        PreparedStatement stmt;

        String updateProfile = "UPDATE userInfo SET country = ?, day = ?, month =?, year = ?, summary = ?, bio = ? WHERE id = ?";
            try {
                connection = DatabaseConnection.getConnection();
                stmt= connection.prepareStatement(updateProfile);
                stmt.setString(1,country.getValue().toString());
                stmt.setString(2,birthDay.getText());
                stmt.setString(3,month.getValue().toString());
                stmt.setString(4,birthYear.getText());
                stmt.setString(5,summary.getText());
                stmt.setString(6,status.getText());
                stmt.setInt(7, LoginModel.rowNum);
                stmt.executeUpdate();
                connection.close();
                stmt.close();
            } catch (SQLException ex) {


        }
        System.out.println(country.getValue().toString());
    }
}
