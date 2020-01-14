package application;

/*
 * 
 * 
 * 
 * author @N-Georgakopoulos
 */
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.executiveClasses.Artist;
import application.executiveClasses.Database;
import application.executiveClasses.Day;
import application.executiveClasses.Event;
import application.executiveClasses.Week;
import application.managerHomeController.Cell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.scene.control.TableView;

public class YoloCalController extends ListView<Week> implements Initializable {

	@FXML
	Label monthlbl;
	int currentMonthInt;
	public static String currentMonthString;
	int currentMonthDays;
	public static Artist art;
	@FXML
	ListView<Week> listviewNode;
	@FXML
	Label nullLbl;

	public void back(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("TimelineView.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		window.setTitle("Choose action on an Artist");
		window.setScene(scene);
		window.show();
	}

	static class Cell extends ListCell<Week> {
		HBox hbox = new HBox();
		Pane pane = new Pane();

		Label lbl;

		@SuppressWarnings("static-access")
		public Cell() {
			super();
			this.pane.setStyle("-fx-background-color: #1C1C1C");
			this.lbl = new Label();
			this.lbl.setStyle("-fx-background-color: #FF9B04");
			this.lbl.setMinHeight(20);
			this.lbl.setMinWidth(20);
			hbox.setStyle("-fx-background-color: #1C1C1C");

			hbox.getChildren().addAll(lbl, pane);
			hbox.setHgrow(pane, Priority.ALWAYS);
		}

		public void updateItem(Week week, boolean empty) {
			super.updateItem(week, empty);
			setText(null);
			setGraphic(null);
			if (week != null) {
				int day1Num = (week.getD1().getImera() + 1);
				String day1num2 = String.format("|%02d|", day1Num);
				int day2Num = (week.getD2().getImera() + 1);
				String day2num2 = String.format("|%02d|", day2Num);
				int day3Num = (week.getD3().getImera() + 1);
				String day3num2 = String.format("|%02d|", day3Num);
				int day4Num = (week.getD4().getImera() + 1);
				String day4num2 = String.format("|%02d|", day4Num);
				int day5Num = (week.getD5().getImera() + 1);
				String day5num2 = String.format("|%02d|", day5Num);
				int day6Num = (week.getD6().getImera() + 1);
				String day6num2 = String.format("|%02d|", day6Num);
				int day7Num = (week.getD7().getImera() + 1);
				String day7num2 = String.format("|%02d|", day7Num);
				String day1Ev = week.getD1().getKind();
				String day1Ev2 = String.format("%11s", day1Ev);
				String day2Ev = week.getD2().getKind();
				String day2Ev2 = String.format("%11s", day2Ev);

				String day3Ev = week.getD3().getKind();
				String day3Ev2 = String.format("%11s", day3Ev);
				String day4Ev = week.getD4().getKind();
				String day4Ev2 = String.format("%11s", day4Ev);
				String day5Ev = week.getD5().getKind();
				String day5Ev2 = String.format("%11s", day5Ev);
				String day6Ev = week.getD6().getKind();
				String day6Ev2 = String.format("%11s", day6Ev);
				String day7Ev = week.getD7().getKind();
				String day7Ev2 = String.format("%11s", day7Ev);

				lbl.setText((day1num2 + "Event: " + day1Ev2 + " || " + day2num2 + "Event: " + day2Ev2 + "|| " + day3num2
						+ "Event: " + day3Ev2 + "||" + day4num2 + "Event: " + day4Ev2 + "|| " + day5num2 + "Event: "
						+ day5Ev2 + "||" + day6num2 + "Event: " + day6Ev2 + "||" + day7num2 + "Event: " + day7Ev2
						+ "||"));
				setGraphic(hbox);
				;
			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<Week> weeksOfMonth;
		art = artistHomeController.artist;
		currentMonthInt = findMonth(currentMonthString);
		monthlbl.setText("Your schedule for " + currentMonthString);
		currentMonthDays = updateMonthDays(currentMonthInt);
		// weekloading
		ArrayList<Week> weeks = new ArrayList<Week>();
		weeks = loadWeeks();
		if (weeks == null) {
			nullLbl.setText("You have nothing planned for this month");
		}
		weeksOfMonth = FXCollections.observableArrayList(weeks);
		listviewNode.setItems(weeksOfMonth);
		listviewNode.setCellFactory(param -> new Cell());

	}

	public int[] findCoordinatesByDate(int dayOfMonth) {
		int row;
		int column;
		row = dayOfMonth / 7;
		column = dayOfMonth % 7;
		int[] coordinates = { row, column };
		return coordinates;
	}

	int findMonth(String currentMonthString2) {
		int monthInt = 0;
		if (currentMonthString2.equals("January")) {
			monthInt = 0;
		} else if (currentMonthString2.equals("February")) {
			monthInt = 1;
		} else if (currentMonthString2.equals("March")) {
			monthInt = 2;
		} else if (currentMonthString2.equals("April")) {
			monthInt = 3;
		} else if (currentMonthString2.equals("May")) {
			monthInt = 4;
		} else if (currentMonthString2.equals("June")) {
			monthInt = 5;
		} else if (currentMonthString2.equals("July")) {
			monthInt = 6;
		} else if (currentMonthString2.equals("August")) {
			monthInt = 7;
		} else if (currentMonthString2.equals("September")) {
			monthInt = 8;
		} else if (currentMonthString2.equals("October")) {
			monthInt = 9;
		} else if (currentMonthString2.equals("November")) {
			monthInt = 10;

		} else if (currentMonthString2.equals("December")) {
			monthInt = 11;
		}
		return monthInt;

	}

	public int updateMonthDays(int monthCount) {
		int monthDayz = 0;
		if (monthCount == 0 || monthCount == 2 || monthCount == 4 || monthCount == 6 || monthCount == 7
				|| monthCount == 9 || monthCount == 11) {
			monthDayz = 31;
		} else if (monthCount == 1) { // february
			monthDayz = 29;
		} else {
			monthDayz = 30;
		}
		return monthDayz;
	}

	public int dateToCellConverter1D(LocalDate date) {
		int dayInYear = date.getDayOfYear();
		return dayInYear;
	}

	public int dateToDays(int month, int day) {
		int sum = 0;
		int numOfMonthsPassed = 0;
		for (int i = 1; i <= month; i++) {
			numOfMonthsPassed++;
		}
		for (int i = 0; i < numOfMonthsPassed; i++) {
			int days = 0;
			days = updateMonthDays(i);
			sum += days;
		}
		sum += day;
		return sum;
	}

	public ArrayList<Week> loadWeeks() {
		Event[] eventsOfMonth = new Event[currentMonthDays];
		ArrayList<Week> weeksOfMonth = new ArrayList<Week>();
		ArrayList<Event> eventDays = new ArrayList<Event>();
		int artId = Database.returnArtistid(art.getUsername());
		eventDays = Database.returnEvent(artId);
		for (int i = 0; i < eventDays.size(); i++) {
			Event temp = eventDays.get(i);
			int meraMesaStonMhna = temp.getImera();

			eventsOfMonth[meraMesaStonMhna] = temp;
		}
		int weekInMonth = 0;
		int dayNum = 0;
		for (int i = 1; i <= eventsOfMonth.length; i++) {
			if (i % 7 == 0) {
				Event[] weekEvents = new Event[7];
				for (int j = 0; j < 7; j++) {
					weekEvents[j] = eventsOfMonth[j + i - 7];
					if (weekEvents[j] == null) {
						Event temp2 = new Event(art.getId(), dayNum++, currentMonthInt, "Empty ");
						weekEvents[j] = temp2;

					}
				}
				Week temp = new Week(weekEvents, currentMonthInt, weekInMonth);
				weeksOfMonth.add(temp);
				weekInMonth++;
			}
			if (i == 28) {
				int rem = currentMonthDays - i;
				Event[] weekEvents = new Event[rem];
				for (int j = 0; j < rem; j++) {
					weekEvents[j] = eventsOfMonth[j + i];
					if (weekEvents[j] == null) {
						Event temp2 = new Event(art.getId(), (j + i), currentMonthInt, "Empty ");
						weekEvents[j] = temp2;
					}
				}
				Event[] weekEvents2 = new Event[7];
				for (int j = rem; j < 7; j++) {
					weekEvents2[j] = new Event(art.getId(), 0, 0, " ");
				}
				for (int j = 0; j < rem; j++) {
					weekEvents2[j] = weekEvents[j];

				}
				Week temp = new Week(weekEvents2, currentMonthInt, weekInMonth);
				weeksOfMonth.add(temp);
				weekInMonth++;
			}
		}

		return weeksOfMonth;

	}

}
