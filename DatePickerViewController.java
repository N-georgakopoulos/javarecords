
import java.io.IOException;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DatePickerViewController {
	
	@FXML
    private Button backBtn;

    @FXML
    private Button loadbtn;

    @FXML
    private Label progrLabel;

    @FXML
    private Label dateLabel;

    public static LocalDate dateChosen;
    
    @FXML
    void BackButtonClicked(ActionEvent event) throws IOException {
    	Parent viewParent = FXMLLoader.load(MonthController.class.getResource("TimelineView.fxml"));
		Scene viewScene = new Scene(viewParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setTitle("Calendar");
		window.setScene(viewScene);
		window.show();
    }
    
    @FXML
    void LoadButtonClicked(ActionEvent event) {
    	loadbtn.setOnAction(value ->  {
    		System.out.println(dateChosen.toString());
			dateLabel.setText(dateChosen.toString());
    	});	
			
			
			
			
			
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

