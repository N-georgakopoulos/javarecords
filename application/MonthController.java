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

public class MonthController {

    @FXML
    private Button janbtn;

    @FXML
    private Button febbtn;

    @FXML
    private Button marbtn;

    @FXML
    private Button aprbtn;

    @FXML
    private Button maybtn;

    @FXML
    private Button junbtn;

    @FXML
    private Button julbtn;

    @FXML
    private Button augbtn;

    @FXML
    private Button sepbtn;

    @FXML
    private Button octbtn;

    @FXML
    private Button novbtn;

    @FXML
    private Button decbtn;
    
    @FXML
    void ButtonClicked(ActionEvent event){
    }
    public void back(ActionEvent e) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("artistHome.fxml"));
    			
    			Scene scene = new Scene(root);
    			Stage window = (Stage) ((Node)e.getSource()).getScene().getWindow();

    			window.setScene(scene);
    			window.show();
    		}
    @FXML
    void ClickedButton(ActionEvent event) throws IOException {
    	Parent tableViewParent = FXMLLoader.load(MonthController.class.getResource("CalView.fxml"));
    	Scene tableViewScene = new Scene(tableViewParent);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setTitle("Calendar");
    	window.setScene(tableViewScene);
    	window.show();
    }

}
