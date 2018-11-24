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

    userInfo users = userInfo.getInstance();


    protected void showProfileUsername(String username) {
        this.profileusernameLabel.setText(username);
    }

    public void setImageLabel() throws IOException {
        this.userImageView.setImage(new Image(getClass().getClassLoader().getResource("images/Dominic.png").toString()));
    }

    public void closeApplication(){
        Stage stage = (Stage) closeButtom.getScene().getWindow();
        stage.close();
    }

    public void initialize(URL url, ResourceBundle rb) {
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

    public void profileUpdate() throws Exception {
        Connection connection;
        PreparedStatement stmt;
        String updateProfile = "UPDATE userInfo SET country = ?, day = ?, month =?, year = ?, summary = ?, bio = ? WHERE id = ?";
        try {
            connection = DatabaseConnection.getConnection();
            stmt = connection.prepareStatement(updateProfile);
            if(country.getValue()== null) {
                stmt.setString(1,users.getCountry());
            }
            else {
                stmt.setString(1, country.getValue().toString());
            }
            if(birthDay.getText() == null) {
                stmt.setString(2, users.getDay());
            }
            else {
                stmt.setString(2, birthDay.getText());
            }
            if(month.getValue()== null) {
                stmt.setString(3,users.getMonth());
            }
            else {
                stmt.setString(3, month.getValue().toString());
            }
            if(birthYear.getText() == null) {
                stmt.setString(4, users.getYear());
            }
            else {
                stmt.setString(4, birthYear.getText());
            }
            if(summary.getText() == null) {
                stmt.setString(5, users.getSummary());
            }
            else {
                stmt.setString(5, summary.getText());
            }
            if(status.getText() == null) {
                stmt.setString(6, users.getStatus());
            }
            else {
                stmt.setString(6, status.getText());
            }
            stmt.setInt(7, LoginModel.rowNum);
            stmt.executeUpdate();
            connection.close();
            stmt.close();


        } catch (SQLException ex) {


        }
        updateUser();
    }

    public void updateUser() throws Exception {
        Connection connection;
        ResultSet rs = null;
        Statement statement = null;
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT * FROM userInfo ";
            rs = statement.executeQuery(sql);
            for (int i = 0; i < LoginModel.rowNum; i++) {
                rs.next();
            }
            userInfo user = userInfo.getInstance();
            user.setStatus(rs.getString(4));
            user.setCountry(rs.getString(5));
            user.setDay(rs.getString(6));
            user.setMonth(rs.getString(7));
            user.setYear(rs.getString(8));
            user.setSummary(rs.getString(9));

        } catch (SQLException ex) {
            ex.getErrorCode();
        } finally {
            rs.close();
            statement.close();
        }

    }
}
