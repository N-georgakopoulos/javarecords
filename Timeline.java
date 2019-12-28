import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Timeline extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Artιst's Timeline");
		AnchorPane layout = (AnchorPane) FXMLLoader.load(Timeline.class.getResource("TimelineView.fxml"));
		primaryStage.setScene(new Scene(layout, 899, 500));
		primaryStage.show();
	}

}

