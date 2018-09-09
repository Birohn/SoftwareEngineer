package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

//    Button _btnSend;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

       // Pane pane = new Pane()
//        _btnSend= new Button();
//        _btnSend.setText("Send");
//
//        StackPane layout = new StackPane();
//        layout.getChildren().add(_btnSend);

//        Scene scene = new Scene(layout, 800, 500);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();

//        TextField field = new TextField();
//        field.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent event) {
//                if(event.getCode()== KeyCode.ENTER){
//                    System.out.println(field.getText());
//                }
//            }
//        });
//
//        //Adding TextField Node
//        layout.getChildren().add(field);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
