package com.client.chatwindow;
import com.byron.dbConn.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
public class ProfileController {
    @FXML
    private TextField birthDay;
    @FXML
    private TextField birthYear;
    @FXML
    private TextField status;
    @FXML
    private TextArea summary;
    @FXML
    private ComboBox month;
    @FXML
    private ComboBox country;
    @FXML
    private Label firstName;
    @FXML
    private Label lastName;
    @FXML
    private Label userName;
    @FXML
    private ImageView userIcon;
    @FXML
    private ImageView closeButtom;
    private DatabaseConnection connected;


}
