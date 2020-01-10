import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CalendarController {
	
	private MonthController selectedMonth;
	
    @FXML
    private Label monthTitle;

	@FXML
	private Button backbtn;

	@FXML
	private Button wbutton;

	@FXML
	private Label mon0;

	@FXML
	private Label sun0;

	@FXML
	private Label sun1;

    @FXML
    private Label mon1;

    @FXML
    private Label tue0;

    @FXML
    private Label tue1;

    @FXML
    private Label sun2;

    @FXML
    private Label sun3;

    @FXML
    private Label sun4;

    @FXML
    private Label sun5;

    @FXML
    private Label mon2;

    @FXML
    private Label mon3;

    @FXML
    private Label mon4;

    @FXML
    private Label mon5;

    @FXML
    private Label tue2;

    @FXML
    private Label tue3;

    @FXML
    private Label tue4;

    @FXML
    private Label tue5;

    @FXML
    private Label wed0;

    @FXML
    private Label wed1;

    @FXML
    private Label wed2;

    @FXML
    private Label wed3;

    @FXML
    private Label wed4;

    @FXML
    private Label wed5;

    @FXML
    private Label thu0;

    @FXML
    private Label thu1;

    @FXML
    private Label thu2;

    @FXML
    private Label thu3;

    @FXML
    private Label thu4;

    @FXML
    private Label thu5;

    @FXML
    private Label fri0;

    @FXML
    private Label sat2;

    @FXML
    private Label sat3;

    @FXML
    private Label sat4;

    @FXML
    private Label fri4;

    @FXML
    private Label sat5;

    @FXML
    private Label sat0;

    @FXML
    private Label sat1;

    @FXML
    private Label fri1;

    @FXML
    private Label fri2;

    @FXML
    private Label fri5;

    @FXML
    private Label fri3;
    
    public void initData(MonthController month) {
    	selectedMonth = month; 
    	//monthTitle.setText(selectedMonth.getJanbtn());
    }

	@FXML
	void MoveButtonClicked(ActionEvent event) throws IOException {
		Parent viewParent = FXMLLoader.load(WeekController.class.getResource("WeekSelectionView.fxml"));
		Scene viewScene = new Scene(viewParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setTitle("Calendar");
		window.setScene(viewScene);
		window.show();
	}

	@FXML
	void ClickedButton(ActionEvent event) throws IOException {
		Parent viewParent = FXMLLoader.load(Timeline.class.getResource("TimelineView.fxml"));
		Scene viewScene = new Scene(viewParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setTitle("Calendar");
		window.setScene(viewScene);
		window.show();
	}	
}
