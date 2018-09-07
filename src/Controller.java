import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;
import user.UserController;

//----------------------------- DATABASE CONNECTION----------------------------------//
public class Controller implements Initializable{
	
	 LoginModel loginModel = new LoginModel();
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
	
public void initialize(URL url, ResourceBundle rb) {
		if(this.loginModel.isConnected()) {
			this.dbstatus.setText("Connected!");
		}
		else {
			this.dbstatus.setText("Not Connected!");
		}
		
	}
@FXML
public void Login(ActionEvent event) {
	try {
		if(this.loginModel.isLogin(this.usernameField.getText(),this.passwordField.getText())) {
			Stage stage = (Stage)this.loginButton.getScene().getWindow();
			stage.close();
			Loggedin();
		}
		else {
			this.credentials.setText("Wrong Creditials");
		}
	}
	catch(Exception localException) {
		
		
	}
	
	
}


public void Loggedin() {
	try {
		Stage userStage= new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = (Pane)loader.load(getClass().getResource("/user/mainScreen.fxml").openStream());
		UserController userController=(UserController)loader.getController();
		
		Scene scene= new Scene(root);
		userStage.setScene(scene);
		userStage.setTitle("Dashboard");
		userStage.setResizable(false);
		userStage.show();
	}
	catch(IOException ex) {
		ex.printStackTrace();
	}
}
	
//--------------------------------LAYOUT FUNCTION-------------------------------------//	
	private Button createAcc;
	private Hyperlink goBackToLogin;
	@FXML
	public void handleAccClick() {
		try {
			//Stage close = (Stage) createAcc.getScene().getWindow();
			//close.close();
			Parent root= FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
			Stage stage = new Stage();
			stage.setTitle("Sign-up");
			stage.setScene(new Scene(root));
			stage.show();

			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	@FXML
	public void handleToLogin() {
		try {
			//Stage close = (Stage) goBackToLogin.getScene().getWindow();
			//close.close();
			Parent root= FXMLLoader.load(getClass().getResource("Login.fxml"));
			Stage stage = new Stage();
			stage.setTitle("Log-in");
			stage.setScene(new Scene(root));
			stage.show();
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
}
