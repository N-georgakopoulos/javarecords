package application;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import application.executiveClasses.Artist;
import application.executiveClasses.Database;
import application.executiveClasses.Manager;
import application.managerHomeController.Cell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

/*
 * 
 * 
 * 
 * author @N-Georgakopoulos
 */
public class ratingController extends ListView<String> implements Initializable {
	public static Manager manager;
	@FXML
	static ObservableList<String> artistList;
	@FXML
	ListView<String> mpampinos;

	public void back(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("chooseActionOnArt.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	static class Cell extends ListCell<String> {
		HBox hbox = new HBox();
		Pane pane = new Pane();

		Label lbl;

		@SuppressWarnings("static-access")
		public Cell() {
			super();
			this.pane.setStyle("-fx-background-color: #1C1C1C");
			this.lbl = new Label();
			this.lbl.setStyle("-fx-background-color: #FF9B04");
			this.lbl.setMinHeight(20);
			this.lbl.setMinWidth(20);
			hbox.setStyle("-fx-background-color: #1C1C1C");

			hbox.getChildren().addAll(lbl, pane);
			hbox.setHgrow(pane, Priority.ALWAYS);
		}

		public void updateItem(String name, boolean empty) {
			super.updateItem(name, empty);
			setText(null);
			setGraphic(null);
			if (name != null && !empty) {

				lbl.setText(name);
				setGraphic(hbox);
				;
			}
		}

		public void back(ActionEvent e) throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("manHome.fxml"));
			Scene scene = new Scene(root);
			Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
			window.setTitle("Home");
			window.setScene(scene);
			window.show();

		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		manager = managerHomeController.manager; // set the manager for this window
		ArrayList<Artist> artists = new ArrayList<Artist>();
		artists = Database.findWhichArtist(manager.getId()); // get the artist for the manager obj
		try {
			artists = Manager.rankArtists(artists);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> artNames = new ArrayList<String>();
		for (int i = 0; i < artists.size(); i++) {
			artNames.add(artists.get(i).getUsername()); // get the artists' names to display on the listview
		}

		artistList = FXCollections.observableArrayList(artNames); // adding the artist names in the observable list

		mpampinos.getBorder();
		mpampinos.setItems(artistList);
		mpampinos.setCellFactory(param -> new Cell());
	}
}