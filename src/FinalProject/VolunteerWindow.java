package FinalProject;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VolunteerWindow {
    public VolunteerWindow(){
        Stage primaryStage = new Stage();

        // TabPanes to be used in each Scene
        TabPane volTabPane = new TabPane();
        Tab volTab1 = new Tab("Home");
        Tab volTab2 = new Tab("Event");
        Tab volTab3 = new Tab("Time Entry");
        Tab volTab4 = new Tab("Account");

        // GridPanes to hold the nodes (buttons, labels) of each scene
        GridPane volHomePane = new GridPane();
        GridPane volEventPane = new GridPane();
        GridPane volTimeEntryPane = new GridPane();
        GridPane volAccountPane = new GridPane();

        volTab1.setContent(volHomePane);
        volTab2.setContent(volEventPane);
        volTab3.setContent(volTimeEntryPane);
        volTab4.setContent(volAccountPane);
        volTabPane.getTabs().addAll(volTab1, volTab2, volTab3, volTab4);

        Scene primaryScene = new Scene(volTabPane, 400, 500);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Bark Volunteer View");
        primaryStage.show();

    }
}
