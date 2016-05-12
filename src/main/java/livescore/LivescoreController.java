package livescore;
/**
 * File LivescoreController.java
 * Created on 5/11/2016, 4:25 PM.
 */

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import livescore.bean.ContactMark;

/**
 * TODO: Document me
 *
 * @author Adrian Iasinschi (aiasinschi@gmail.com)
 */
public class LivescoreController implements Initializable{
	@FXML
	public Button prevButton;
	@FXML
	public Button nextButton;
	@FXML
	private TextField firstNameField;
	@FXML
	private TextField lastNameField;
	@FXML
	private TextField nickNameField;
	@FXML
	private TextField marksField;
	@FXML
	private TextField addressField;
	@FXML
	private TextArea xmlTextArea;
	@FXML
	private Button parseXMLButton;

	private int currentRecord = 0;

	private List<ContactMark> contactMarks;

	private void displayCurrentRecord(){
		firstNameField.setText(contactMarks.get(currentRecord).getFirstName());
		lastNameField.setText(contactMarks.get(currentRecord).getLastName());
		nickNameField.setText(contactMarks.get(currentRecord).getNickName());
		marksField.setText(contactMarks.get(currentRecord).getMarks());
	}

	public void initialize(URL location, ResourceBundle resources) {
		parseXMLButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				contactMarks = LivescoreParser.parse();
				displayCurrentRecord();
				nextButton.setDisable(false);
				prevButton.setDisable(false);
			}
		});
		nextButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (contactMarks.size() > 0){
					currentRecord = (currentRecord + 1) % contactMarks.size();
					displayCurrentRecord();
				}
			}
		});
		prevButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (contactMarks.size() > 0){
					currentRecord = (currentRecord - 1 + contactMarks.size()) % contactMarks.size();
					displayCurrentRecord();
				}
			}
		});
	}
}
