package application;

import java.io.IOException;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

/*
 * 
 * 
 * 
 * author @DavidKarax
 */
public class MonthController {
	@FXML
	public static String chosenMonth;
	@FXML
	private DatePicker datePicker;

	@FXML
	private Button searchDateBtn;

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
	private Button goDateBtn;

	@FXML
	void backManager(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("chooseActionOnArt.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setTitle("Home");
		window.setScene(scene);
		window.show();
	}

	@FXML
	void ClickedButton(ActionEvent event) throws IOException {
		String monthClicked = ((Button) event.getSource()).getText();
		YoloCalController.currentMonthString = monthClicked;
		Parent viewParent = FXMLLoader.load(MonthController.class.getResource("YoloCal.fxml"));
		Scene viewScene = new Scene(viewParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		// window.setTitle("Calendar");
		window.setScene(viewScene);
		window.show();
	}

	@FXML
	public void backArt(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("artistHome.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setTitle("Home");
		window.setScene(scene);
		window.show();
	}
}
