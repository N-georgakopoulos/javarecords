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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class artistHomeController implements Initializable {
	public static Artist artist;
	@FXML
	Label helloArtist;

	public void setNameTag(String artistName) {
		helloArtist.setText("Hello " + artistName);
	}

	public void showTimeline(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("TimelineView.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	public void registerAlbum(ActionEvent e) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("regAlbumScreen.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		YoloCalController.art = artist;
		setNameTag(artist.getUsername());
	}

}
