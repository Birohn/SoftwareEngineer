package javasocket;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class chatserver extends Application {
    static ServerSocket ss;
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;

    public static void main(String[] args) {
        launch(args);
        String msgin = "";
        try{
            ss = new ServerSocket(1201); //Server starts at port number 1201
            s = ss.accept(); //Server accepts the connection

            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());

            while(!msgin.equals("exit")){
                msgin = din.readUTF();
                //txtArea.setText(txtArea.getText().trim()+"\n"+msgin); //displays the message from CLIENT
            }

        }catch (Exception e){

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
