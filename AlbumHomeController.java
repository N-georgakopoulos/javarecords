package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.layout.*; 
import javafx.scene.image.*; 
import java.io.*; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.scene.control.Label; 
import javafx.stage.Stage; 
import java.net.*; 
public class button_2 extends Application { 
  
    // launch the application 
    public void start(Stage s) throws Exception 
    { 
        // set title for the stage 
        s.setTitle("creating buttons"); 
  
        // create a input stream 
        FileInputStream input = new FileInputStream("icons8-music-library-50.png"); 
  
        // create a image 
        Image i = new Image(input); 
  
        // create a image View 
        ImageView iw = new ImageView(i); 
  
        // create a button 
        Button b = new Button("", iw); 
  
        // create a stack pane 
        TilePane r = new TilePane(); 
  
        // create a label 
        Label l = new Label("button not selected"); 
  
        // action event 
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                l.setText("button selected    "); 
            } 
        }; 
  
        // when button is pressed 
        b.setOnAction(event); 
  
        // add button 
        r.getChildren().add(b); 
        r.getChildren().add(l); 
  
        // create a scene 
        Scene sc = new Scene(r, 200, 200); 
        
        // set the scene 
        s.setScene(sc); 
  
        s.show(); 
    } 
  
    public static void main(String args[]) 
    { 
        // launch the application 
        launch(args); 
    } 
} 