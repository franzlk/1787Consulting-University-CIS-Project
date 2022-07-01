//1787 Consulting
//Course: CIS 484
//Final Project
//I promise that this work was done in accordance with the JMU honor code and
//I did not receive nor give unauthorized assistance in writing this program.
package FinalProject;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;

public class ViewTimeHistoryWindow {
    ListView listView = new ListView();

    public ViewTimeHistoryWindow() {
        Stage primaryStage = new Stage();
        GridPane primaryPane = new GridPane();
        primaryPane.setAlignment(Pos.CENTER);

        ObservableList<TimeHistory> timeHistoryObservableList
                = FXCollections.observableArrayList(TimeHistory.timeHistoryArrayList);

        clearUpdateTable(listView, TimeHistory.timeHistoryArrayList, timeHistoryObservableList);

        listView.setMinWidth(380);
        primaryPane.add(listView, 0, 0);

        Scene primaryScene = new Scene(primaryPane, 400, 500);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("View Clock-In/Clock-Out Entries");
        primaryStage.show();
    }

    public void clearUpdateTable(ListView lv, ArrayList al, ObservableList obsList) {
        lv.getItems().clear();
        for (int i = 0; i<al.size(); i++)
            lv.getItems().add(obsList.get(i));
    }
}
