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

public class ViewVolunteersWindow {
    ListView listView = new ListView();

    public ViewVolunteersWindow() {
        Stage primaryStage = new Stage();
        GridPane primaryPane = new GridPane();
        primaryPane.setAlignment(Pos.CENTER);

        ObservableList<Volunteer> volunteerObservableList
                = FXCollections.observableArrayList(Volunteer.volunteerArrayList);

        clearUpdateTable(listView, Volunteer.volunteerArrayList, volunteerObservableList);

        listView.setMinWidth(380);
        primaryPane.add(listView, 0, 0);

        Scene primaryScene = new Scene(primaryPane, 400, 500);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("View Volunteers");
        primaryStage.show();
    }

    public void clearUpdateTable(ListView lv, ArrayList al, ObservableList obsList) {
        lv.getItems().clear();
        for (int i = 0; i<al.size(); i++)
            lv.getItems().add(obsList.get(i));
    }
}
