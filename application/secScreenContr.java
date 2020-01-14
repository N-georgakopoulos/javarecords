package application;

import javafx.scene.control.*;
import application.executiveClasses.Artist;
import application.executiveClasses.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/*
 * 
 * 
 * 
 * author @N-Georgakopoulos
 */
public class secScreenContr {

//FXML document elements linked to ctrlr class	
	@FXML
	Label lbl;
	@FXML
	TextField textf;
	@FXML
	PasswordField passf;
	@FXML
	TextField textf1;
	@FXML
	PasswordField passf1;
	@FXML
	Label managerErrorlbl;
	@FXML
	Label artistErrolbl;

	// throws the next manager user screen
	public void throwManHome() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("manHome.fxml"));

		Scene scene = new Scene(root);
		// Stage window = (Stage) ((Node)e.getSource()).getScene().getWindow();
		Stage window = (Stage) (textf.getScene().getWindow());
		window.setScene(scene);
		window.show();
	}
	// throws the next artist user screen

	public void throwArtHome() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("artistHome.fxml"));

		Scene scene = new Scene(root);
		// Stage window = (Stage) ((Node)e.getSource()).getScene().getWindow();
		Stage window = (Stage) (textf.getScene().getWindow());
		window.setTitle("Home ");
		window.setScene(scene);
		window.show();
	}

	// checks the credentials given from the artist user with data in database
	public void checkCredsArt(ActionEvent e) throws Exception {
		String username = textf1.getText();
		String password = passf1.getText();
		boolean credsOk = Database.credentialsOkArtist(username, password);
		if (credsOk) {
			artistHomeController.artist = Database.returnArtist(username);
			throwArtHome();
		} else {
			artistErrolbl.setText("Wrong username or password,please try again");
		}
	}

	// checks the credentials given from the artist user with data in database
	public void checkCredsMan(ActionEvent e) throws Exception {
		String username = textf.getText();
		String password = passf.getText();
		boolean credsOk = Database.credentialsOkManager(username, password);

		if (credsOk) {
			managerHomeController.manager = Database.returnManager(username);
			throwManHome();
		} else {
			managerErrorlbl.setText("Wrong username or password,please try again");
		}
	}
}
