package application;

/*
 * 
 * 
 * 
 * author @N-Georgakopoulos
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.executiveClasses.Artist;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class chooseActionOnArtController {
	// Artist under which the manager user performs operations
	public static Artist chosenArtist;
	@FXML
	static Label perflbl;
	@FXML
	static Label timelbl;
	@FXML
	static Label albumlbl;

	public static Artist getChosenArtist() {
		return chosenArtist;
	}

	// returns to previous window/scene
	public void back(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("manHome.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	public void throwCalendar(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("TimelineView.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		window.setTitle("Performances");
		window.setScene(scene);
		window.show();
	}

	// throws the create a performance window/scene.
	public void throwPerformance(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("createAPerformance.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		window.setTitle("Performances");
		window.setScene(scene);
		window.show();
	}

	// throws the rating window
	public void throwRating(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Rating.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		window.setTitle("Ratings");
		window.setScene(scene);
		window.show();
	}

	// throws the album home window
	public void throwAlbumHome(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AlbumHome.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		window.setTitle("Artist albums");
		window.setScene(scene);
		window.show();
	}
}
