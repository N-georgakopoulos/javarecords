package javarecords;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class Rating {
	ArrayList<Artist> artists = new ArrayList<Artist>();
	
	@FXML
	TableView tbl = new TableView();
	@FXML TableColumn sthlh1;
	@FXML TableColumn sthlh2;
	@FXML TableColumn sthlh3;
	ObservableList<String> listView = FXCollections.observableArrayList();
	ObservableList<String> listView2 = FXCollections.observableArrayList();
	ObservableList<String> listView3 = FXCollections.observableArrayList();
static class Cell extends ListCell<String> {
	HBox hbox = new HBox();
	Pane pane = new Pane();
	Button btn = new Button("button");
	Label lbl = new Label("label bro ");


	@SuppressWarnings("static-access")
	public Cell() {
		super();
		hbox.getChildren().addAll(lbl,btn,pane);
		hbox.setHgrow(pane, Priority.ALWAYS);
	}
	public void updateItem(String name,boolean empty) {
		super.updateItem(name, empty);
		setText(null);
		setGraphic(null);
		if(name!=null&& !empty) {
			btn.setText(name);
			setGraphic(hbox);
			
		}
	}
}

/*private TableView<Artist> table = new TableView<Artist>();
private final ObservableList<Artist> data 
		= FXCollections.observableArrayList(
				);

public void start(Stage stage) {
    Scene scene = new Scene(new Group());
    stage.setWidth();
    stage.setHeight();

    
    table.setEditable(true);

    TableColumn sthlh1 = new TableColumn("Place");
    sthlh1.setMinWidth(10);
    sthlh1.setCellValueFactory(
            new PropertyValueFactory<Artist, String>("Place"));

    TableColumn sthlh2 = new TableColumn("Name");
    sthlh2.setMinWidth(10);
    sthlh2.setCellValueFactory(
            new PropertyValueFactory<Artist, String>("Name"));

    TableColumn sthlh3 = new TableColumn("Score");
    sthlh3.setMinWidth(10);
    sthlh3.setCellValueFactory(
            new PropertyValueFactory<Artist, String>("Score"));

    FilteredList<Artist> flPerson = new FilteredList(data, p -> true);//Pass the data to a filtered list
    table.setItems(flPerson);//Set the table's items using the filtered list
    table.getColumns().addAll(sthlh1, sthlh2, sthlh3);
*/
    

public void initialize(URL arg0,ResourceBundle arg1) {
	fillObjects();
}
public void fillObjects() {
	
}
}
