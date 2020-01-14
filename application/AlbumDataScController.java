package application;

/*
 * 
 * 
 * 
 * author @N-Georgakopoulos
 */
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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AlbumDataScController extends ListView<String> implements Initializable {
	public static Artist artist;
	@FXML
	ListView<String> songlist;
	@FXML
	Label phySales;
	@FXML
	Label digSales;
	@FXML
	Label digSalesP;
	@FXML
	Label physSalesP;
	@FXML
	Label header;
	public static String albumName;
	ObservableList<String> songs;

	public void back(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AlbumHome.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		window.setTitle("Home");
		window.setScene(scene);
		window.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			Album album = null;
			ArrayList<String> songs1 = new ArrayList<String>();
			songs1 = Database.findWhichSongs(albumName);
			songs = FXCollections.observableArrayList(songs1);
			album = Database.findAlbumByName(albumName);
			String physicalSales = Double.toString(album.getphysical());
			phySales.setText(physicalSales);
			digSales.setText(album.getdigital() + "");
			digSalesP.setText(album.getpriced() + "");
			physSalesP.setText(album.getpricep() + "");
			header.setText(album.getname() + " 's data");
			songlist.setItems(songs);
			songlist.setCellFactory(param -> new Cell());
		} catch (Exception e) {

		}
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

}
