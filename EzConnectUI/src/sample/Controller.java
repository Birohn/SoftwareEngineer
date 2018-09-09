package sample;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

import java.awt.*;

public class Controller {

    public void goClicked(){
        System.out.println("It's Searching...");
    }
    static class Contacts extends ListCell<String> {
        HBox hbox= new HBox();
        Label label= new Label("");
        //Image profile = new Image('assets/placeholder.png');

    }
}