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

public class CalendarController
{
	
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

    @FXML
    private Button loadButton;

    public static String monthChosen;
 
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
	
	 @FXML
	 void LoadButtonClicked(ActionEvent event) {
		loadButton.setOnAction(value ->  {
			monthTitle.setText(monthChosen + " View");
			if (monthChosen.equals("February") || monthChosen.equals("August")) {
				//week one
				sun0.setText("-");
				mon0.setText("-");
				tue0.setText("-");
				wed0.setText("-");
				thu0.setText("-");
				fri0.setText("-");
				sat0.setText("1");
				//week two
				sun1.setText("2");
				mon1.setText("3");
				tue1.setText("4");
				wed1.setText("5");
				thu1.setText("6");
				fri1.setText("7");
				sat1.setText("8");
				//week three
				sun2.setText("9");
				mon2.setText("10");
				tue2.setText("11");
				wed2.setText("12");
				thu2.setText("13");
				fri2.setText("14");
				sat2.setText("15");
				//week four
				sun3.setText("16");
				mon3.setText("17");
				tue3.setText("18");
				wed3.setText("19");
				thu3.setText("20");
				fri3.setText("21");
				sat3.setText("22");
				//week five
				sun4.setText("23");
				mon4.setText("24");
				tue4.setText("25");
				wed4.setText("26");
				thu4.setText("27");
				fri4.setText("28");
				sat4.setText("29");
				//week six
				if(monthChosen.equals("February")) {
					sun5.setText("-");
					mon5.setText("-");
				} else {
					sun5.setText("30");
					mon5.setText("31");
				}
				tue5.setText("-");
				wed5.setText("-");
				thu5.setText("-");
				fri5.setText("-");
				sat5.setText("-");
			}
			if(monthChosen.equals("March") || monthChosen.equals("November")) {
				sun0.setText("1");
				mon0.setText("2");
				tue0.setText("3");
				wed0.setText("4");
				thu0.setText("5");
				fri0.setText("6");
				sat0.setText("7");
				//week two
				sun1.setText("8");
				mon1.setText("9");
				tue1.setText("10");
				wed1.setText("11");
				thu1.setText("12");
				fri1.setText("13");
				sat1.setText("14");
				//week three
				sun2.setText("15");
				mon2.setText("16");
				tue2.setText("17");
				wed2.setText("18");
				thu2.setText("19");
				fri2.setText("20");
				sat2.setText("21");
				//week four
				sun3.setText("22");
				mon3.setText("23");
				tue3.setText("24");
				wed3.setText("25");
				thu3.setText("26");
				fri3.setText("27");
				sat3.setText("28");
				//week five
				sun4.setText("29");
				mon4.setText("30");
				tue4.setText("25");
				wed4.setText("26");
				thu4.setText("27");
				fri4.setText("28");
				sat4.setText("29");
				//week six
				sun5.setText("30");
				if( monthChosen.equals("March")) {
					mon5.setText("31");
				}else {
					mon5.setText("-");
				}
				tue5.setText("-");
				wed5.setText("-");
				thu5.setText("-");
				fri5.setText("-");
				sat5.setText("-");
			}
			if (monthChosen.equals("September") || monthChosen.equals("December")) {
				//week one
				sun0.setText("-");
				mon0.setText("-");
				tue0.setText("1");
				wed0.setText("2");
				thu0.setText("3");
				fri0.setText("4");
				sat0.setText("5");
				//week two
				sun1.setText("6");
				mon1.setText("7");
				tue1.setText("8");
				wed1.setText("9");
				thu1.setText("10");
				fri1.setText("11");
				sat1.setText("12");
				//week three
				sun2.setText("13");
				mon2.setText("14");
				tue2.setText("15");
				wed2.setText("16");
				thu2.setText("17");
				fri2.setText("18");
				sat2.setText("19");
				//week four
				sun3.setText("20");
				mon3.setText("21");
				tue3.setText("22");
				wed3.setText("23");
				thu3.setText("24");
				fri3.setText("25");
				sat3.setText("26");
				//week five
				sun4.setText("27");
				mon4.setText("28");
				tue4.setText("29");
				wed4.setText("30");
				if (monthChosen.equals("September")) {
					thu4.setText("-");
				}else { 
					thu4.setText("31");
				}
				fri4.setText("-");
				sat4.setText("-");
				//week six
				sun5.setText("-");
				mon5.setText("-");
				tue5.setText("-");
				wed5.setText("-");
				thu5.setText("-");
				fri5.setText("-");
				sat5.setText("-");
			}
			if (monthChosen.equals("May")) {
				//week one
				sun0.setText("-");
				mon0.setText("-");
				tue0.setText("-");
				wed0.setText("-");
				thu0.setText("-");
				fri0.setText("1");
				sat0.setText("2");
				//week two
				sun1.setText("3");
				mon1.setText("4");
				tue1.setText("5");
				wed1.setText("6");
				thu1.setText("7");
				fri1.setText("8");
				sat1.setText("9");
				//week three
				sun2.setText("10");
				mon2.setText("11");
				tue2.setText("12");
				wed2.setText("13");
				thu2.setText("14");
				fri2.setText("15");
				sat2.setText("16");
				//week four
				sun3.setText("17");
				mon3.setText("18");
				tue3.setText("19");
				wed3.setText("20");
				thu3.setText("21");
				fri3.setText("22");
				sat3.setText("23");
				//week five
				sun4.setText("24");
				mon4.setText("25");
				tue4.setText("26");
				wed4.setText("27");
				thu4.setText("28");
				fri4.setText("29");
				sat4.setText("30");
				//week six
				sun5.setText("31");
				mon5.setText("-");
				sun5.setText("-");
				mon5.setText("-");
				tue5.setText("-");
				wed5.setText("-");
				thu5.setText("-");
				fri5.setText("-");
				sat5.setText("-");
			}
			if (monthChosen.equals("June")) {
				//week one
				sun0.setText("-");
				mon0.setText("1");
				tue0.setText("2");
				wed0.setText("3");
				thu0.setText("4");
				fri0.setText("5");
				sat0.setText("6");
				//week two
				sun1.setText("7");
				mon1.setText("8");
				tue1.setText("9");
				wed1.setText("10");
				thu1.setText("11");
				fri1.setText("12");
				sat1.setText("13");
				//week three
				sun2.setText("14");
				mon2.setText("15");
				tue2.setText("16");
				wed2.setText("17");
				thu2.setText("18");
				fri2.setText("19");
				sat2.setText("20");
				//week four
				sun3.setText("21");
				mon3.setText("22");
				tue3.setText("23");
				wed3.setText("24");
				thu3.setText("25");
				fri3.setText("26");
				sat3.setText("27");
				//week five
				sun4.setText("28");
				mon4.setText("29");
				tue4.setText("30");
				wed4.setText("-");
				thu4.setText("-");
				fri4.setText("-");
				sat4.setText("-");
				//week six
				sun5.setText("-");
				mon5.setText("-");
				tue5.setText("-");
				wed5.setText("-");
				thu5.setText("-");
				fri5.setText("-");
				sat5.setText("-");
			}
			if (monthChosen.equals("October")) {
				//week one
				sun0.setText("-");
				mon0.setText("-");
				tue0.setText("-");
				wed0.setText("-");
				thu0.setText("1");
				fri0.setText("2");
				sat0.setText("3");
				//week two
				sun1.setText("4");
				mon1.setText("5");
				tue1.setText("6");
				wed1.setText("7");
				thu1.setText("8");
				fri1.setText("9");
				sat1.setText("10");
				//week three
				sun2.setText("11");
				mon2.setText("12");
				tue2.setText("13");
				wed2.setText("14");
				thu2.setText("15");
				fri2.setText("16");
				sat2.setText("17");
				//week four
				sun3.setText("18");
				mon3.setText("19");
				tue3.setText("20");
				wed3.setText("21");
				thu3.setText("22");
				fri3.setText("23");
				sat3.setText("24");
				//week five
				sun4.setText("25");
				mon4.setText("26");
				tue4.setText("27");
				wed4.setText("28");
				thu4.setText("29");
				fri4.setText("30");
				sat4.setText("-");
				//week six
				sun5.setText("-");
				mon5.setText("-");
				tue5.setText("-");
				wed5.setText("-");
				thu5.setText("-");
				fri5.setText("-");
				sat5.setText("-");
			}
			if (monthChosen.equals("April")) {
				fri4.setText("-");
			}	
		});
	 }
}
