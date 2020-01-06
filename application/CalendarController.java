package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class CalendarController {

    @FXML
    private Button backbtn;

    @FXML
    private Button wbutton;

	@FXML Label monthTag;

    @FXML
    void MoveButtonClicked(ActionEvent event) throws IOException {
    	Parent tableViewParent = FXMLLoader.load(WeekController.class.getResource("WeekSelectionView.fxml"));
    	Scene tableViewScene = new Scene(tableViewParent);
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setTitle("Calendar");
    	window.setScene(tableViewScene);
    	window.show();
    }
   

    @FXML
    void ClickedButton(ActionEvent event) throws IOException {
    	Parent tableViewParent = FXMLLoader.load(getClass().getResource("TimelineView.fxml"));
    	Scene tableViewScene = new Scene(tableViewParent);
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setTitle("Calendar");
    	window.setScene(tableViewScene);
    	window.show();
    }

}

