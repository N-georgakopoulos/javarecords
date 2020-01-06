package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class artistHomeController {

	@FXML
	Label artistNameTag;

	public void setNameTag(String artistName) {
		artistNameTag.setText(artistName);
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

}
