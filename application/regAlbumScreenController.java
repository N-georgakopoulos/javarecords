package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.*;

public class regAlbumScreenController {
	public void back(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("artistHome.fxml"));

		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();

		window.setScene(scene);
		window.show();
	}
	
}
