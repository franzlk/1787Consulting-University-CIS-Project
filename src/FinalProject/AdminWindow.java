package FinalProject;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class AdminWindow {
    // home tab nodes
    // event tab nodes
    // clock in/out tab nodes
    // account tab nodes
public AdminWindow(Volunteer activeUser){
    Stage primaryStage = new Stage();

    // TabPanes to be used in each Scene
    TabPane TabPane = new TabPane();
    Tab Tab1 = new Tab("Home");
    Tab Tab2 = new Tab("Event");
    Tab Tab3 = new Tab("Volunteers");
    Tab Tab4 = new Tab("Account");

    // Panes to hold the nodes (buttons, labels) of each tab
    //--------home tab
    GridPane homeGridPane = new GridPane();
    //--------event tab
    GridPane eventGridPane = new GridPane();
    //--------volunteers tab
    GridPane volunteerGridPane = new GridPane();
    //--------account tab
    GridPane accountGridPane = new GridPane();

    setPositionAlignment(homeGridPane, eventGridPane, volunteerGridPane, accountGridPane);

    Tab1.setContent(homeGridPane);
    Tab2.setContent(eventGridPane);
    Tab3.setContent(volunteerGridPane);
    Tab4.setContent(accountGridPane);
    TabPane.getTabs().addAll(Tab1, Tab2, Tab3, Tab4);

    Scene primaryScene = new Scene(TabPane, 775, 600);
    primaryStage.setScene(primaryScene);
    primaryStage.setTitle("BARK Admin View");
    primaryStage.show();
}

    public void setPositionAlignment(GridPane... gp) {
        for (GridPane g : gp) {
            g.setAlignment(Pos.CENTER);
            g.setHgap(10);
            g.setVgap(4);
        }
    }
}
