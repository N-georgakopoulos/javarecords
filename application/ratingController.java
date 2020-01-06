package application;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.executiveClasses.Artist;
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

public class ratingController extends ListView<String> implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	// static manager object that defines which manager is the current user.Input
		// received from previous window.
		@FXML
		static Manager manager = new Manager("KOSNIDABOSS'S ARTISTS", " ");
		// this manager's list of artist names,to be displayed in the window.
		@FXML
		private ListView<String> list;
		ObservableList<String> listView;

		public static Artist[] artistas;
		ArrayList<String> names = new ArrayList<String>();
		// fxml element links to fxml document.
		@FXML
		Label manname;

	

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
		public void initialize(URL arg0, ResourceBundle arg1) {
			for (int i = 0; i < artistas.length; i++) {
				names.add(artistas[i].getUsername());
			}
			manname.setText(manager.getUsername());
			try {
				Manager.loadObj();

				listView = FXCollections.observableArrayList(names);
				list.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						System.out.println("clicked on " + list.getSelectionModel().getSelectedItem());
						String artist = list.getSelectionModel().getSelectedItem();
						chooseActionOnArtController.setChosenArtist(artist);
						try {

							Parent root = FXMLLoader.load(getClass().getResource("chooseActionOnArt.fxml"));

							Scene scene = new Scene(root);
							Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

							window.setScene(scene);
							window.show();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} finally {

						}
					}
				});
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list.setItems(listView);
			list.setCellFactory(param -> new Cell());
		}

		// displays next window/scene listing artists albums
		public void AlbumHome(ActionEvent e) throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("AlbumHome.fxml"));
			Scene scene = new Scene(root);
			Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();

		}

		// method to change the manager user
		public void setManager(Manager manager) {
		}

}
