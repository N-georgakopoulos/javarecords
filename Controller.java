package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
	@FXML
	private TextField venue;
	@FXML
	private TextField ticketPrice;
	@FXML
	private TextField ticketSales;
	@FXML
	private TextField AlbumPlayed1;
	@FXML
	private TextField AlbumPlayed2;

	public void createPerformance(ActionEvent event) throws Exception {
		String price = ticketPrice.getText();
		int price2 = Integer.parseInt(price);
		String sales = ticketSales.getText();
		int sales2 = Integer.parseInt(sales);
		Performance PerformanceA = new Performance(venue.getText(),price2,sales2,AlbumPlayed1.getText(),AlbumPlayed2.getText());
	}
}
