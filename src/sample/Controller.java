package sample;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.web.HTMLEditor;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable{
    @FXML
    public ListView parsedList;
    @FXML
    private Button parseButton;
    @FXML
    private TextArea consoleTextArea;
    @FXML
    private HTMLEditor htmlEditor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        parseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String ul = "<ul><li>", eul = "</li></ul>";
                String htmlText = htmlEditor.getHtmlText();
                int start = htmlText.indexOf(ul);
                List<String> items =  new ArrayList<>();
                if (start >= 0){
                    start += ul.length();
                    int end = htmlText.indexOf(eul, start);
                    Scanner sc = new Scanner(htmlText.substring(start, end)).useDelimiter("</li><li>");
                    while (sc.hasNext()){
                        items.add(sc.next());
                    }
                    System.out.println(items);
                }
                StringBuilder con = new StringBuilder();
                for (String item: items){
                    con.append(item); con.append("\n");
                }
                parsedList.setItems(FXCollections.observableList(items));
                consoleTextArea.setText(htmlText);
            }
        });
    }
}
