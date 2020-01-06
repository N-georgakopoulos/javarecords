package application;

import javafx.scene.control.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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

	//throws the next manager user screen
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
	//checks the credentials given from the user
	public void getCreds(ActionEvent e) throws Exception {
		String username = textf.getText();
		String password = passf.getText();
		// TODO boolean credsOk = checkCreds(username,password) checks up in db
		// TODO this.manager=findMan(username)
		int x = textf.getLength();
		boolean credsOk = true;
		// lbl.setText(textf.getText());
		if (x < 6)
			credsOk = false;
		if (credsOk) {
			managerHomeController.manager=textf.getText();
			throwManHome();
		} else {
			managerErrorlbl.setText("Wrong username or password,please try again");
		}
	}
}
