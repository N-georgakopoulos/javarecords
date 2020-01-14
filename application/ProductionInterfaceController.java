package application;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.*;
import application.executiveClasses.Album;
import application.executiveClasses.Artist;
import application.executiveClasses.Database;
import application.executiveClasses.Partner;
import application.executiveClasses.Production;
import application.executiveClasses.Studio;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/*
 * 
 * 
 * 
 * author KaterinaChatziathanasiou
 */
public class ProductionInterfaceController {
	public static Album album;
	ObservableList<String> chooseStudioList = FXCollections.observableArrayList();
	ObservableList<String> chooseComposerList = FXCollections.observableArrayList();
	ObservableList<String> chooseLyricistList = FXCollections.observableArrayList();
	ObservableList<String> chooseProducerList = FXCollections.observableArrayList();
	ObservableList<String> chooseMusician1List = FXCollections.observableArrayList();
	ObservableList<String> chooseMusician2List = FXCollections.observableArrayList();
	ObservableList<String> chooseMusician3List = FXCollections.observableArrayList();
	@FXML
	private ChoiceBox<String> chooseStudio;
	@FXML
	private ImageView calendar;
	@FXML
	private ImageView headphones;
	@FXML
	private ImageView partners;
	@FXML
	private AnchorPane h_calendar;
	@FXML
	private AnchorPane h_headphones;
	@FXML
	private AnchorPane h_partners;
	@FXML
	private ChoiceBox<String> composer;
	@FXML
	private ChoiceBox<String> lyricist;
	@FXML
	private ChoiceBox<String> producer;
	@FXML
	private ChoiceBox<String> musician1;
	@FXML
	private ChoiceBox<String> musician2;
	@FXML
	private ChoiceBox<String> musician3;
	@FXML
	private DatePicker startCalendar;
	@FXML
	private DatePicker releaseCalendar;
	@FXML
	private Label albumTitle;
	@FXML
	private Button submit;
	@FXML
	private Label result;
	@FXML
	private Label euro;

	ArrayList<Partner> partnerss;
	ArrayList<Studio> studios;
	ArrayList<Partner> composers;
	public static ArrayList<String> musicians;
	ArrayList<Partner> lyricists;
	ArrayList<Partner> producers;
	@FXML
	Label calcLbl;
	@FXML
	Label subLbl;
	@FXML
	TextField hoursTxt;

	public void back(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("PickRegAlb.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		window.setTitle("Home");
		window.setScene(scene);
		window.show();

	}

	void findPartnersAttribute() { // examines the list of partners and adds them to their responding arraylist
									// based on their expertise for further processing
		for (int i = 0; i < partnerss.size(); i++) {
			Partner currentPartner = partnerss.get(i);
			String attribute = currentPartner.getAttribute().toLowerCase();
			if (attribute.equals("musician")) {
				chooseMusician1List.add(currentPartner.getName());
				chooseMusician2List.add(currentPartner.getName());
				chooseMusician3List.add(currentPartner.getName());
			} else if (attribute.equals("composer")) {
				chooseComposerList.add(currentPartner.getName());
			} else if (attribute.equals("lyricist")) {
				chooseLyricistList.add(currentPartner.getName());

			} else if (attribute.equals("producer")) {
				chooseProducerList.add(currentPartner.getName());
			}
		}
	}

	public void loadData() { // configures choice pickers and loads data
		partnerss = Database.returnPartners();
		for (int i = 0; i < partnerss.size(); i++) {
			System.out.println("Partner returned from db " + partnerss.get(i).toString());
		}
		findPartnersAttribute();
		studios = Database.returnStudios();
		System.out.println(partnerss.get(0).toString() + partnerss.get(1).toString());
		System.out.println(studios.get(0).toString() + "" + studios.get(1).toString());
	}

	@FXML
	private void initialize() {
		// TODO LOAD PARTNERS AND STUDIOS FROM DB

		loadData();
		// load studio names on observable list
		for (int i = 0; i < studios.size(); i++) {
			chooseStudioList.add(studios.get(i).getName());
		}
		chooseStudio.setItems(chooseStudioList);

		composer.setItems(chooseComposerList);
		lyricist.setItems(chooseLyricistList);
		producer.setItems(chooseProducerList);
		musician1.setItems(chooseMusician1List);
		musician2.setItems(chooseMusician2List);
		musician3.setItems(chooseMusician3List);

	} // end method initialize

	@FXML
	private void handleButtonAction(MouseEvent event) {
		if (event.getTarget() == calendar) {
			h_calendar.setVisible(true);
			h_headphones.setVisible(false);
			h_partners.setVisible(false);
		} else if (event.getTarget() == headphones) {
			h_headphones.setVisible(true);
			h_calendar.setVisible(false);
			h_partners.setVisible(false);
		} else if (event.getTarget() == partners) {
			h_partners.setVisible(true);
			h_calendar.setVisible(false);
			h_headphones.setVisible(false);
		}

	}// end method handleButtonAction

	@FXML
	public void produceAlb(ActionEvent e) {
		// part1 create in db
		Album albumerino = new Album(album.getname(), chooseActionOnArtController.chosenArtist.getId(), 1);
		Database.updateAlbum(albumerino.getname(), albumerino.getpricep(), albumerino.getpriced(),
				(int) albumerino.getphysical(), (int) albumerino.getdigital(),
				chooseActionOnArtController.chosenArtist.getId(), 1);
		System.out.println(albumerino.toString());
		subLbl.setText("Your album has been set for production!");
		// part2 create in calendar
		LocalDate begin = startCalendar.getValue();
		LocalDate stop = releaseCalendar.getValue();
		long dayzPassed = java.time.temporal.ChronoUnit.DAYS.between(begin, stop);
		Artist artist = chooseActionOnArtController.chosenArtist;
		int minas = begin.getMonthValue();
		for (int i = 0; i < dayzPassed; i++) {
			Database.addsEvent(artist.getId(), begin.getDayOfMonth() + i, minas, "Production");
		}
	}

	public void calculateCost(ActionEvent e) {
		double cost = 0;
		int hours = Integer.parseInt(hoursTxt.getText());
		String studioname = chooseStudio.getValue();
		Studio studio = findStudioObj(studioname);
		cost += studio.getPricePerHour() * hours;
		cost += findPartnerObj(composer.getValue()).getPayPerHour() * hours;
		cost += findPartnerObj(musician1.getValue()).getPayPerHour() * hours;
		cost += findPartnerObj(musician2.getValue()).getPayPerHour() * hours;
		cost += findPartnerObj(musician3.getValue()).getPayPerHour() * hours;
		cost += findPartnerObj(lyricist.getValue()).getPayPerHour() * hours;
		cost += findPartnerObj(producer.getValue()).getPayPerHour() * hours;
		calcLbl.setText("The cost of the album is " + cost + "$");
	}

	public Partner findPartnerObj(String partName) {
		ArrayList<Partner> partners = Database.returnPartners();
		Partner partnerChosen = null;
		for (int i = 0; i < partners.size(); i++) {
			if (partners.get(i).getName().equals(partName)) {
				partnerChosen = partners.get(i);
			}
		}
		return partnerChosen;
	}

	public Studio findStudioObj(String studioName) {
		ArrayList<Studio> studios = Database.returnStudios();
		Studio studioChosen = null;
		for (int i = 0; i < studios.size(); i++) {
			if (studios.get(i).getName().equals(studioName)) {
				studioChosen = studios.get(i);
			}
		}
		return studioChosen;
	}

} // end class SampleController