package FinalProject;

import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    // volunteer tab nodes
    Label lblVolunteer = new Label("Volunteers");
    ListView volunteerListView = new ListView();
    Button btnEditVolInfo = new Button("Edit Selected Volunteer's Info");
    Button btnDelVol = new Button("Delete Selected Volunteer");
    Label lblPendingApplications = new Label("Pending Applications");
    ListView applicationListView = new ListView();
    Button btnConfirmApp = new Button("Confirm Selected Application");
    Button btnDenyApp = new Button("Deny Selected Application");

    // account tab nodes

public AdminWindow(Volunteer activeUser){
    Stage primaryStage = new Stage();

    // TabPanes to be used in each Scene
    TabPane TabPane = new TabPane();
    Tab Tab1 = new Tab("Home");
    Tab Tab2 = new Tab("Event");
    Tab Tab3 = new Tab("Volunteer Management");
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

    // nodal content of homeGridPane

    // nodal content of eventGridPane

    // nodal content of volunteerGridPane
    volunteerGridPane.setVgap(10);
    volunteerGridPane.setHgap(10);
    ObservableList<Volunteer> volunteerObservableList
            = FXCollections.observableArrayList(Volunteer.volunteerArrayList);
    ObservableList<VolunteerApplication> applicationObservableList
            = FXCollections.observableArrayList(VolunteerApplication.volunteerApplicationArrayList);
    clearUpdateTable(volunteerListView, Volunteer.volunteerArrayList, volunteerObservableList);
    clearUpdateTable(applicationListView, VolunteerApplication.volunteerApplicationArrayList, applicationObservableList);

    volunteerGridPane.add(lblVolunteer, 0, 0, 2, 1);
    lblVolunteer.setStyle("-fx-font: 16 arial");
    volunteerGridPane.add(volunteerListView, 0, 1, 2, 1);
    volunteerListView.setPrefWidth(350);
    volunteerGridPane.add(btnEditVolInfo, 0, 2);
    volunteerGridPane.add(btnDelVol, 1, 2);

    volunteerGridPane.add(lblPendingApplications, 2, 0, 2, 1);
    lblPendingApplications.setStyle("-fx-font: 16 arial");
    volunteerGridPane.add(applicationListView, 2, 1, 2, 1);
    applicationListView.setPrefWidth(350);
    volunteerGridPane.add(btnConfirmApp, 2, 2);
    volunteerGridPane.add(btnDenyApp, 3, 2);

    // nodal content of accountGridPane

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

    public void clearUpdateTable(ListView lv, ArrayList al, ObservableList obsList) {
        lv.getItems().clear();
        for (int i = 0; i<al.size(); i++)
            lv.getItems().add(obsList.get(i));
    }
}
