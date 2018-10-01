package javasocket;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerClient implements Initializable {
    public Button sendMsgClient;
    public TextArea msgClient;
    public TextField textInputClient;

    public void sendMessagetoServer(ActionEvent actionEvent) {
        String msgout = "";
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
