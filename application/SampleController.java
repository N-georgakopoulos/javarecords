package application;

/*
 * 
 * 
 * 
 * author @N-Georgakopoulos
 */
import javafx.stage.*;
import application.executiveClasses.Album;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.*;

public class SampleController {
	@FXML
	public void startButtonTODO(ActionEvent e) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("2ndscreen.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		window.setTitle("Login ");
		window.setScene(scene);
		window.show();

	}
}
