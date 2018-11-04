package com.client.chatwindow;
import com.byron.dbConn.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
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

    public void initialize(URL url, ResourceBundle rb) {
        showProfileUsername("Hello");
        month.getItems().setAll(Month.values());
        country.getItems().setAll(Countries.values());
    }
}
