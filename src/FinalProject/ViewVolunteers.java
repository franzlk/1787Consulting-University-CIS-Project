package FinalProject;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ViewVolunteers {
    ListView listView = new ListView();

    public ViewVolunteers() {
        Stage primaryStage = new Stage();
        GridPane primaryPane = new GridPane();
        primaryPane.setAlignment(Pos.CENTER);

        primaryPane.add(listView, 0, 0);

        Scene primaryScene = new Scene(primaryPane, 400, 500);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("View Volunteers");
        primaryStage.show();
    }
}
