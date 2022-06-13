package FinalProject;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VolunteerWindow {
    // home tab nodes

    // event tab nodes

    // time entry tab nodes
    Label lblEventHours = new Label("Log event hours:\t");
    TextField txtEventHours = new TextField();
    Label lblTotalMileage = new Label("Log total mileage:\t");
    TextField txtTotalMileage = new TextField();
    Label lblEventType = new Label("Log event type\t");
    ComboBox cbEventType = new ComboBox();
    Button btnSubmit = new Button("Submit Info");

    // account tab nodes
    Label lblMyAccountInfo = new Label("My Account Info");
    Label lblName = new Label("Name\t");
    TextField txtName = new TextField();
    Label lblEmail = new Label("Email\t");
    TextField txtEmail = new TextField();
    Label lblAddress = new Label("Address\t");
    TextField txtAddress = new TextField();
    Label lblSpecialization = new Label("Specialization\t");
    ComboBox cbSpecialization = new ComboBox();
    Button btnEdit = new Button("Edit");
    Label lblAllVolunteers = new Label("All Volunteers");
    ListView listView = new ListView();

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
        setPositionAlignment(volHomePane, volEventPane, volTimeEntryPane, volAccountPane);

        volTab1.setContent(volHomePane);
        volTab2.setContent(volEventPane);
        volTab3.setContent(volTimeEntryPane);
        volTab4.setContent(volAccountPane);
        volTabPane.getTabs().addAll(volTab1, volTab2, volTab3, volTab4);

        // nodal content of volHomePane

        // nodal content of volEventPane

        // nodal content of volTimeEntryPane
        volTimeEntryPane.add(lblEventHours, 0, 0);
        volTimeEntryPane.add(txtEventHours, 1, 0);
        volTimeEntryPane.add(lblTotalMileage, 0, 1);
        volTimeEntryPane.add(txtTotalMileage, 1, 1);
        volTimeEntryPane.add(lblEventType, 0, 2);
        volTimeEntryPane.add(cbEventType, 1, 2);
        volTimeEntryPane.add(btnSubmit, 0, 3);

        // nodal content of volAccountPane
        volAccountPane.add(lblMyAccountInfo, 0, 0);
        lblMyAccountInfo.setStyle("-fx-font: 18 arial");
        volAccountPane.add(lblName, 0,1);
        volAccountPane.add(txtName, 1, 1);
        volAccountPane.add(lblEmail, 0, 2);
        volAccountPane.add(txtEmail, 1, 2);
        volAccountPane.add(lblAddress, 0, 3);
        volAccountPane.add(txtAddress, 1, 3);
        volAccountPane.add(lblSpecialization, 0, 4);
        volAccountPane.add(cbSpecialization, 1, 4);
        volAccountPane.add(btnEdit, 1, 5);
        volAccountPane.add(lblAllVolunteers, 2, 0);
        lblAllVolunteers.setStyle("-fx-font: 18 arial");
        volAccountPane.add(listView, 2, 1, 1, 6);

        Scene primaryScene = new Scene(volTabPane, 600, 600);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Bark Volunteer View");
        primaryStage.show();


    }

    public void setPositionAlignment(GridPane... gp){
        for (GridPane g : gp){
            g.setAlignment(Pos.CENTER);
            g.setHgap(10);
            g.setVgap(4);
        }
    }
}
