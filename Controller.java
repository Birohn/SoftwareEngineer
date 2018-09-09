package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Controller {
	public Button createAcc;
	public Hyperlink goBackToLogin;
	public AnchorPane anchor;
	
	public void handleAccClick() {
		try {

			 Stage close = (Stage) createAcc.getScene().getWindow();
			close.close();
			Parent root= FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
			Stage stage = new Stage();
			stage.setTitle("Sign-up");
			stage.setScene(new Scene(root));
			stage.show();

			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void handleToLogin() {
		try {
			Stage close = (Stage) goBackToLogin.getScene().getWindow();
			close.close();
			Parent root= FXMLLoader.load(getClass().getResource("Login.fxml"));
			Stage stage = new Stage();
			stage.setTitle("Log-in");
			stage.setScene(new Scene(root));
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
