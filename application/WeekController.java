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

public class WeekController {

    @FXML
    private Button weekbtn1;

    @FXML
    private Button weekbtn2;

    @FXML
    private Button weekbtn3;

    @FXML
    private Button weekbtn4;

    @FXML
    private Button returnbtn;

    @FXML
    private Button mobtn;

    @FXML
    void ClickedButton(ActionEvent event) {

    }

    @FXML
    void MonthSelectionClicked(ActionEvent event) throws IOException {
    	Parent tableViewParent = FXMLLoader.load(Timeline.class.getResource("TimelineView.fxml"));
    	Scene tableViewScene = new Scene(tableViewParent);
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setTitle("Calendar");
    	window.setScene(tableViewScene);
    	window.show();
    }

    @FXML
    void ReturnClicked(ActionEvent event) throws IOException {
    	Parent tableViewParent = FXMLLoader.load(MonthController.class.getResource("CalView.fxml"));
    	Scene tableViewScene = new Scene(tableViewParent);
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setTitle("Calendar");
    	window.setScene(tableViewScene);
    	window.show();
    }

}