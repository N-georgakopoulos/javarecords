package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.executiveClasses.Album;
import application.executiveClasses.Artist;
import application.executiveClasses.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
/*
 * 
 * 
 * 
 * author @N-Georgakopoulos
 */
public class regAlbumScreenController implements Initializable {
	public static Artist artist;
	@FXML Button albBtn;
	@FXML TextField albtxt;
	@FXML Button sngBtn;
	@FXML TextField songtxt;
	Album registeredAlbum;
	@FXML Button doneBtn;
	@FXML Label doneLbl;
	static String albumTitle;
	static ArrayList<String> songs;
	
	public void back(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("artistHome.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	public void addAlbumTitle(ActionEvent e) {
		albumTitle = albtxt.getText();
	}
	public void addSong(ActionEvent e) {
		songs.add(songtxt.getText());
	}
	public void done(ActionEvent e) {
	 	Database.addsAlbums(albumTitle, 0, 0, 0, 0, artist.getId(), 0);
		doneLbl.setText("Your album, " +albumTitle + " has been registered");
		//TODO ADD THIS ALBUM TO DB
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		songs=new ArrayList<String>();
		artist = artistHomeController.artist;
	}
}
