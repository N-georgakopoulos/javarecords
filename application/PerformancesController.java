package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArrayBase;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import application.executiveClasses.*;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class PerformancesController extends ListView<String> implements Initializable {
	ObservableList<Venues> x;
	@FXML
	Button calculatorBtn;
	@FXML
	Button createBtn;
	@FXML
	Button scoreBtn;
	@FXML
	ChoiceBox<Venues> venue;
	@FXML
	TextField ticketp;
	@FXML
	TextField sales;
	@FXML
	ChoiceBox<Album> album;
	@FXML
	DatePicker date;
	private Performances performance;
	@FXML
	Label scorelbl;
	@FXML
	Label profitlbl;
	@FXML
	Label createdLbl;
	@FXML
	static Label errorlbl;

	public void createPerformance(ActionEvent event) throws Exception {
		if (sales.getText() == "" || ticketp.getText() == "" || album.getSelectionModel().getSelectedItem() == null
				|| venue.getSelectionModel().getSelectedItem() == null || date.getValue() == null) {
			errorlbl.setText("Please fill all the nescessary spaces");
		} else {
			// create performance in timeline
			createdLbl.setText("Your performance has been created! ");
			errorlbl.setText("");
		}
	}

	public void calculateBtn() {
		try {
			Venues pickedVenue = venue.getSelectionModel().getSelectedItem();
			Album pickedAlbum = album.getSelectionModel().getSelectedItem();
			double ticketpr = Double.parseDouble(ticketp.getText());
			double saleees = Double.parseDouble(sales.getText());
			LocalDate pickedDate = date.getValue();

			performance = new Performances(pickedVenue, ticketpr, saleees, pickedAlbum, pickedDate);
			double profit = performance.calculateProfit();
			profitlbl.setText("Your projected profit is " + profit + "$");
		} catch (NumberFormatException e) {
			errorlbl.setText("Please fill all the nescessary spaces");
		}
	}

	public void back(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("chooseActionOnArt.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		window.setTitle("Choose action on an Artist");
		window.setScene(scene);
		window.show();
	}

	public void calculateAttendance(ActionEvent e) {
		Venues pickedVenue = venue.getSelectionModel().getSelectedItem();
		Album pickedAlbum = album.getSelectionModel().getSelectedItem();
		double ticketpr = Double.parseDouble(ticketp.getText());
		double saleees = Double.parseDouble(sales.getText());
		LocalDate pickedDate = date.getValue();
		Performances tempPerf = new Performances(pickedVenue, ticketpr, saleees, pickedAlbum, pickedDate);
		double attendance = tempPerf.getLiveScore();
		String att2str = String.format("%.2f", attendance);
		scorelbl.setText("The venue will be around " + att2str + "% full");

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		Venues v1 = new Venues(3002, "kosnivenue", 100);
		Venues v2 = new Venues(4, "ariannavenue", 100);
		x = FXCollections.observableArrayList(v1, v2);
		System.out.println(v1.toString() + v2.toString());
		venue.setItems(x);

	}
	//changes the errorlbl text if the user does not fill in all the nescessary fields
	public static void setErrorLbl(String errormsg) {
		errorlbl.setText(errormsg);
	}

}