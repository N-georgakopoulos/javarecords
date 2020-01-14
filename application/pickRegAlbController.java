package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.executiveClasses.Album;
import application.executiveClasses.Artist;
import application.executiveClasses.Database;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/*
 * 
 * 
 * 
 * author @N-Georgakopoulos
 */
public class pickRegAlbController extends ListView<String> implements Initializable {
	public Artist artist;
	@FXML
	ListView<String> list;
	ObservableList<String> regAlbs;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			artist = chooseActionOnArtController.chosenArtist;
			ArrayList<String> regAlbNames = new ArrayList<String>();
			ArrayList<Album> albs = findRegisteredAlbum();
			for (int i = 0; i < albs.size(); i++) {
				regAlbNames.add(albs.get(i).getname());
			}
			regAlbs = FXCollections.observableArrayList(regAlbNames);
			list.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					try {
						String albName = list.getSelectionModel().getSelectedItem();
						ProductionInterfaceController.album = Database.findAlbumByName(albName);

						Parent root = FXMLLoader.load(getClass().getResource("ProduceAlbum.fxml"));

						Scene scene = new Scene(root);
						Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
						window.setTitle("Produce an album");
						window.setScene(scene);
						window.show();

					} catch (Exception e) {
					}
				}
			});
			list.setItems(regAlbs);
			list.setCellFactory(param -> new Cell());
		} catch (Exception e) {

		}
	}

	@SuppressWarnings("static-access")
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

	public void back(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AlbumHome.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		window.setTitle("Home");
		window.setScene(scene);
		window.show();

	}

	public ArrayList<Album> findRegisteredAlbum() throws Exception {
		ArrayList<Album> totalAlbs = new ArrayList<Album>();
		totalAlbs = Database.findWhichAlbum(artist.getId());
		ArrayList<Album> regAlbs = new ArrayList<Album>();
		for (int i = 0; i < totalAlbs.size(); i++) {
			Album temp = totalAlbs.get(i);
			if (temp.getdigital() == 0 && temp.getphysical() == 0) { // registered albums have no sales yet
				regAlbs.add(temp);
			}
		}
		return regAlbs;
	}

}
