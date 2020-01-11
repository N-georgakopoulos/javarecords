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
    void ClickedButton(ActionEvent event) throws IOException {
    	Parent viewParent = FXMLLoader.load(MonthController.class.getResource("CalView.fxml"));
    	Scene viewScene = new Scene(viewParent);
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	String monthClicked = ((Button)event.getSource()).getText();
    	CalendarController.monthChosen = monthClicked;
    	window.setTitle("Calendar");
    	window.setScene(viewScene);
    	window.show();
     }
}

