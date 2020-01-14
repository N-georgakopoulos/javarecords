package application;

/*
 * 
 * 
 * 
 * author @N-Georgakopoulos
 */
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.executiveClasses.Artist;
import application.executiveClasses.Database;
import application.executiveClasses.Manager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class managerHomeController extends ListView<String> implements Initializable {
	// static manager object that defines which manager is the current user.Input
	// received from previous window.
	@FXML
	public static Manager manager;
	// this manager's list of artist names,to be displayed in the window.
	@FXML
	private ListView<String> list;
	ObservableList<String> entries;

	public static Artist[] artistas;
	ArrayList<String> names = new ArrayList<String>();
	// fxml element links to fxml document.
	@FXML
	Label manname;
	@FXML
	TextField searchbar;

	// cell factory for the listview.determines characteristics of blocks displayed
	// in the listview.
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

			hbox.getChildren().addAll(lbl);
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
	}

	// implementation of the initialize method,also included: understanding on which
	// listview cell mouse was clicked and define the static artist
	// on which future functions will be performed.
	@SuppressWarnings("unchecked")
	public void initialize(URL arg0, ResourceBundle arg1) {
		ArrayList<Artist> artists = new ArrayList<Artist>();
		artists = Database.findWhichArtist(manager.getId());
		ArrayList<String> artNames = new ArrayList<String>();
		for (int i = 0; i < artists.size(); i++) {
			artNames.add(artists.get(i).getUsername());
		}
		manname.setText("Your artists, " + manager.getUsername());
		entries = FXCollections.observableArrayList(artNames);
		list.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				String artist = list.getSelectionModel().getSelectedItem();
				chooseActionOnArtController.chosenArtist = Database.returnArtist(artist);
				AlbumHomeController.artist = Database.returnArtist(artist);
				if (Database.returnArtist(artist) != null) {
					try {

						Parent root = FXMLLoader.load(getClass().getResource("chooseActionOnArt.fxml"));

						Scene scene = new Scene(root);
						Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
						window.setTitle("Choose action on an Artist");
						window.setScene(scene);
						window.show();

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {

					}
				}
			}
		});
		list.setItems(entries);
		list.setCellFactory(param -> new Cell());
		searchbar.setPromptText("Search");
		searchbar.textProperty().addListener(new ChangeListener() {
			public void changed(ObservableValue observable, Object oldVal, Object newVal) {
				handleSearchByKey((String) oldVal, (String) newVal);
			}
		});

	}

	// displays next window/scene listing artists albums
	public void AlbumHome(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AlbumHome.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		window.setTitle("This artist's albums");
		window.setScene(scene);
		window.show();

	}

	public void handleSearchByKey(String oldVal, String newVal) {
		// If the number of characters in the text box is less than last time
		// it must be because the user pressed delete
		if (oldVal != null && (newVal.length() < oldVal.length())) {
			// Restore the lists original set of entries
			// and start from the beginning
			list.setItems(entries);
		}

		// Change to upper case so that case is not an issue
		newVal = newVal.toUpperCase();

		// Filter out the entries that don't contain the entered text
		ObservableList<String> subentries = FXCollections.observableArrayList();
		for (Object entry : list.getItems()) {
			String entryText = (String) entry;
			if (entryText.toUpperCase().contains(newVal)) {
				subentries.add(entryText);
			}
		}
		list.setItems(subentries);
	}

}
