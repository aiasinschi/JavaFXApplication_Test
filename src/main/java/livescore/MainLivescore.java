package livescore;
/**
 * File MainLivescore.java
 * Created on 5/11/2016, 4:25 PM.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * TODO: Document me
 *
 * @author Adrian Iasinschi (aiasinschi@gmail.com)
 */
public class MainLivescore extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/livescore.fxml"));
		primaryStage.setTitle("Parse XML");
		primaryStage.setScene(new Scene(root, 500, 500));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
