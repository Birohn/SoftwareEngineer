package javasocket;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class chatclient extends Application {
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;


    public static void main(String[] args) {
        launch(args);

        try{
            s = new Socket("127.0.0.1",1201); //Used a local address because client and server are running from the same computer
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            String msgin="";
            while(!msgin.equals("exit")){
                msgin=din.readUTF();
                // msgClient.setText(msgClient.getText().trim()+ "\nServer: \t" +msgin);

            }
        }catch(Exception e){

        }
    }
    @Override
    public void start(Stage primaryStage) {
        try { //Starts up the login screen as soon as the program is executed
            Parent root= FXMLLoader.load(getClass().getResource("/javasocket/chatserver.fxml"));
            primaryStage.setTitle("ChatServer");
            primaryStage.setResizable(false);
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}