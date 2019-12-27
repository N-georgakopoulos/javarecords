package application;
import javafx.application.Applicationl
	import javafx.stage.Stage;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.scene.layout.BorderPane;
	import javafx.scene.text.Font;
	import javafx.fxml.FXMLLoader;
	import javafx.fxml.*;;

	public class Main extends Application {

		@Override
		public void start (Stage primaryStage) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("/application/Performances.fxml"));				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void main (String[] args) {
			launch(args);
		}
	}
