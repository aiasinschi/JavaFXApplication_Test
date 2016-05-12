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
 * @author Adrian Iasinschi (adrian.iasinschi@kepler-rominfo.com)
 */
public class LivescoreController implements Initializable{
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

	private List<ContactMark> contactMarks;

	public void initialize(URL location, ResourceBundle resources) {
		parseXMLButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				contactMarks = LivescoreParser.parse();
				firstNameField.setText(contactMarks.get(0).getFirstName());
				lastNameField.setText(contactMarks.get(0).getLastName());
				nickNameField.setText(contactMarks.get(0).getNickName());
				marksField.setText(contactMarks.get(0).getMarks());
			}
		});
	}
}
