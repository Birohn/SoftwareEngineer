package javasocket;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Button btnButton;
    public TextArea txtArea;
    public TextField txtInput;

    static ServerSocket ss;
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void sendMessage(ActionEvent actionEvent) {
        String msgout = "";
        msgout = txtInput.getText().trim();
        try {
            dout.writeUTF(msgout);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
