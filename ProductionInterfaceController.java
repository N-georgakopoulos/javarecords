package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

public class ProductionInterfaceController {
	
	ObservableList<String> chooseStudioList = FXCollections.observableArrayList();
	ObservableList<String> chooseComposerList = FXCollections.observableArrayList();
	ObservableList<String> chooseLyricistList = FXCollections.observableArrayList();
	ObservableList<String> chooseProducerList = FXCollections.observableArrayList();
	ObservableList<String> chooseMusician1List = FXCollections.observableArrayList();
	ObservableList<String> chooseMusician2List = FXCollections.observableArrayList();
	ObservableList<String> chooseMusician3List = FXCollections.observableArrayList();

	
	@FXML
	private ChoiceBox chooseStudio;
	@FXML
	private Spinner gradeSpinner;
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
	private ChoiceBox composer;
	@FXML
	private ChoiceBox lyricist;
	@FXML
	private ChoiceBox producer;
	@FXML
	private ChoiceBox musician1;
	@FXML
	private ChoiceBox musician2;
	@FXML
	private ChoiceBox musician3;
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
	
	Studio st1 = new Studio("Bashment studio", 45.0);
	Studio st2 = new Studio("Studio Grand", 60.0);
	Studio st3 = new Studio("Studio EMP", 32.0);
	Studio[] studioArray = {st1, st2, st3};
	
	Partner cp1 = new Partner("John Smith", "sfergtrhjt", "composer", 50.0);
	Partner cp2 = new Partner("Mohn Mith", "sfergtrh", "composer", 55.0);
	Partner cp3 = new Partner("Lohn Lith", "sfergtrhj", "composer", 100.0);
	Partner[] composerArray = {cp1, cp2, cp3};
	Partner lp1 = new Partner("Linda Mae", "berhfvijlkgt", "lyricist", 50.0);
	Partner lp2 = new Partner("Cinda Cae", "berhfvijl", "lyricist", 50.0);
	Partner lp3 = new Partner("Dinda Dae", "berhfvijlk", "lyricist", 50.0);
	Partner[] lyricistArray = {lp1, lp2, lp3};
	Partner pp1 = new Partner("Dave D", "berhfvijlkgt", "producer", 50.0);
	Partner pp2 = new Partner("Dave F", "berhfvijlkgt", "producer", 50.0);
	Partner pp3 = new Partner("Dave Z", "berhfvijlkgt", "producer", 50.0);
	Partner[] producerArray = {pp1, pp2, pp3};
	Partner mp1 = new Partner("Kate Opere", "asdefr", "musician", 50.0);
	Partner mp2 = new Partner("Kate Mae", "asdefr", "musician", 50.0);
	Partner mp3 = new Partner("Kate Smith", "asdefr", "musician", 50.0);
	Partner mp4 = new Partner("Kate J", "asdefr", "musician", 50.0);
	Partner mp5 = new Partner("Kate Jones", "asdefr", "musician", 50.0);
	Partner[] musicianArray = {mp1, mp2, mp3, mp4, mp5};
	
	@FXML
	private void initialize() {


		
		//create album gia na doulepsei twra
		Album alb = new Album();
		alb.setname("The Wall");
		
		//configure Label
		albumTitle.setText(alb.getname());
		
		//configure the Studio choice box
		for(int i = 0; i < studioArray.length; i++) {
			chooseStudioList.add(studioArray[i].getName());
		} //end for
		
		
		//chooseStudio.setValue(st1.getName());
		chooseStudio.setItems(chooseStudioList);
		
		//configure the Partners choice boxes
		for(int i = 0; i < composerArray.length; i++) {
			chooseComposerList.add(composerArray[i].getUsername());
		} //end for
		for(int i = 0; i < lyricistArray.length; i++) {
			chooseLyricistList.add(lyricistArray[i].getUsername());
		} //end for
		for(int i = 0; i < producerArray.length; i++) {
			chooseProducerList.add(producerArray[i].getUsername());
		} //end for
		for(int i = 0; i < musicianArray.length; i++) {
				chooseMusician1List.add(musicianArray[i].getUsername());
				chooseMusician2List.add(musicianArray[i].getUsername());
				chooseMusician3List.add(musicianArray[i].getUsername());
		} //end for
		
		composer.setItems(chooseComposerList);
		lyricist.setItems(chooseLyricistList);
		producer.setItems(chooseProducerList);
		musician1.setItems(chooseMusician1List);
		musician2.setItems(chooseMusician2List);
		musician3.setItems(chooseMusician3List);
		
		//configure spinner with values of 0-150
		SpinnerValueFactory<Integer> gradesValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 150, 0);
		this.gradeSpinner.setValueFactory(gradesValueFactory);
		
	} //end method initialize
	
	@FXML
	private void handleButtonAction(MouseEvent event) {
		if(event.getTarget() == calendar) {
			h_calendar.setVisible(true);
			h_headphones.setVisible(false);
			h_partners.setVisible(false);
		} else if(event.getTarget() == headphones) {
			h_headphones.setVisible(true);
			h_calendar.setVisible(false);
			h_partners.setVisible(false);
		} else if(event.getTarget() == partners) {
			h_partners.setVisible(true);
			h_calendar.setVisible(false);
			h_headphones.setVisible(false);
		}
		
	}//end method handleButtonAction
	
	@FXML
	private void handleSubmitButton(ActionEvent event) {
		
		
		Production prod = new Production();
		prod.setStartDate(startCalendar.getValue());
		prod.setReleaseDate(releaseCalendar.getValue());
		
		int value = (Integer) gradeSpinner.getValue();
		prod.setStudioTime(value);
		
		for(int i = 0; i < studioArray.length; i++) {
			if(studioArray[i].getName() == chooseStudio.getValue()) {
				prod.setStudio(studioArray[i]);
			}
		} //end for
		
		for(int i = 0; i < composerArray.length; i++) {
			if(composerArray[i].getUsername() == composer.getValue()) {
				prod.setPartner1(composerArray[i]);
			}
		} //end for
		
		for(int i = 0; i < lyricistArray.length; i++) {
			if(lyricistArray[i].getUsername() == lyricist.getValue()) {
				prod.setPartner2(lyricistArray[i]);
			}
		} //end for
		
		for(int i = 0; i < producerArray.length; i++) {
			if(producerArray[i].getUsername() == producer.getValue()) {
				prod.setPartner3(producerArray[i]);
			}
		} //end for
		
		for(int i = 0; i < musicianArray.length; i++) {
			if(musicianArray[i].getUsername() == musician1.getValue()) {
				prod.setPartner4(musicianArray[i]);
			}
		} //end for
		
		for(int i = 0; i < musicianArray.length; i++) {
			if(musicianArray[i].getUsername() == musician2.getValue()) {
				prod.setPartner5(musicianArray[i]);
			}
		} //end for
		
		for(int i = 0; i < musicianArray.length; i++) {
			if(musicianArray[i].getUsername() == musician3.getValue()) {
				prod.setPartner6(musicianArray[i]);
			}
		} //end for
		
		
		//calculate and present cost	
		double c = prod.productionCost();
		String costString = String.valueOf(c);
		result.setText(costString);
		String e = "€";
		euro.setText(e);
			
	} //end method handleSubmitButton

	

} //end class SampleController

