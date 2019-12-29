package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class artistHomeController {
	@FXML
	TextField keimeno;
	@FXML
	Label etiketa;
	
	public void aek(ActionEvent e) {
		etiketa.setText(keimeno.getText());
	}
}
