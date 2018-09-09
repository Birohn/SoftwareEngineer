package CreateAccount;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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



public class accountController{
	
	@FXML
	private Hyperlink goBackToLogin;
	@FXML
	public void handleToLogin() { // Goes back to Login (Needs to be put into different controller)
		Stage stage = (Stage)this.goBackToLogin.getScene().getWindow();
		stage.close();
		try {
			FXMLLoader loader = new FXMLLoader();
			AnchorPane root = (AnchorPane)loader.load(getClass().getResource("../Login/Login.fxml").openStream());
			Scene scene= new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Login");
			stage.setResizable(false);
			stage.show();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}

}
