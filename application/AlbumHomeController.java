package application;

/*
 * 
 * 
 * 
 * author @N-Georgakopoulos
 */
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.executiveClasses.Album;
import application.executiveClasses.Artist;
import application.executiveClasses.Database;
import application.executiveClasses.Manager;
import application.managerHomeController.Cell;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class AlbumHomeController extends ListView<String> implements Initializable {
	// static artist object that defines which artist is the currently
	// processed.Input
	// received from previous window.
	@FXML
	public static Artist artist;
	// this artists list of albums,plus their listview fxml object in which they
	// will be displayed
	@FXML
	private ListView<String> albumlistview;
	ObservableList<String> albums;

	// fxml element links to fxml document.

	@FXML
	TextField searchbar;
	@FXML
	Label onomakallitexnh;

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
	}

	// implementation of the initialize method,also included: understanding on which
	// listview cell mouse was clicked and define the static artist
	// on which future functions will be performed.
	@SuppressWarnings("unchecked")
	public void initialize(URL arg0, ResourceBundle arg1) {
		ArrayList<Album> albums1 = new ArrayList<Album>();
		try {
			albums1 = Database.findWhichAlbum(artist.getId());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ArrayList<String> albumNames = new ArrayList<String>();
		for (int i = 0; i < albums1.size(); i++) {
			albumNames.add(albums1.get(i).getname());
		}
		onomakallitexnh.setText(artist.getUsername() + "'s Albums");
		albums = FXCollections.observableArrayList(albumNames);
		albumlistview.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				AlbumDataScController.albumName = albumlistview.getSelectionModel().getSelectedItem();
				try {

					Parent root = FXMLLoader.load(getClass().getResource("albumDataSc.fxml"));
					Scene scene = new Scene(root);
					Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
					window.setTitle(albumlistview.getSelectionModel().getSelectedItem() + " album data");
					window.setScene(scene);
					window.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {

				}
			}
		});
		albumlistview.setItems(albums);
		albumlistview.setCellFactory(param -> new Cell());
		searchbar.textProperty().addListener(new ChangeListener() {
			public void changed(ObservableValue observable, Object oldVal, Object newVal) {
				handleSearchByKey((String) oldVal, (String) newVal);
			}
		});
		albumlistview.setItems(albums);
		albumlistview.setCellFactory(param -> new Cell());

	}

	public void back(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("chooseActionOnArt.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		window.setTitle("Home");
		window.setScene(scene);
		window.show();

	}

	public void handleSearchByKey(String oldVal, String newVal) {
		// If the number of characters in the text box is less than last time
		// it must be because the user pressed delete
		if (oldVal != null && (newVal.length() < oldVal.length())) {
			// Restore the lists original set of entries
			// and start from the beginning
			albumlistview.setItems(albums);
		}

		// Change to upper case so that case is not an issue
		newVal = newVal.toUpperCase();

		// Filter out the entries that don't contain the entered text
		ObservableList<String> subentries = FXCollections.observableArrayList();
		for (Object entry : albumlistview.getItems()) {
			String entryText = (String) entry;
			if (entryText.toUpperCase().contains(newVal)) {
				subentries.add(entryText);
			}
		}
		albumlistview.setItems(subentries);
	}

	@FXML
	public void throwProduction(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("PickRegAlb.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setTitle("Home");
		window.setScene(scene);
		window.show();
	}

}
