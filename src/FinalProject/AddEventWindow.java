//1787 Consulting
//Course: CIS 484
//Final Project
//I promise that this work was done in accordance with the JMU honor code and
//I did not receive nor give unauthorized assistance in writing this program.
package FinalProject;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class AddEventWindow {
    TextField txtName = new TextField();
    TextField txtDate = new TextField();
    TextField txtTime = new TextField();
    TextField txtAddress = new TextField();
    TextField txtCity = new TextField();
    TextField txtState = new TextField();
    TextField txtZip = new TextField();
    TextArea txtDescription = new TextArea();
    Button btnConfirm = new Button("Confirm Event");

    public <T> AddEventWindow(T parentForm, int currentUserID){
        Stage primaryStage = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(10);
        
        txtName.setPromptText("Event Name");
        txtDate.setPromptText("Event Date");
        txtTime.setPromptText("Event Time");
        txtAddress.setPromptText("Event Street Address");
        txtCity.setPromptText("Event City");
        txtState.setPromptText("Event State");
        txtZip.setPromptText("Event Zip Code (no spaces or special characters)");
        txtDescription.setPromptText("Event Description (Max 150 characters)");

        // formatting
        setMaxWidth(txtDescription, txtName, txtDate, txtTime, txtAddress,
                txtCity, txtState, txtZip);
        txtDescription.setMaxHeight(150);
        txtDescription.setWrapText(true);
        btnConfirm.setMinWidth(510);

        gridPane.add(txtName, 0, 0);
        gridPane.add(txtDate, 0, 1);
        gridPane.add(txtTime, 0, 2);
        gridPane.add(txtAddress, 1, 0);
        gridPane.add(txtCity, 1, 1);
        gridPane.add(txtState, 1, 2);
        gridPane.add(txtZip, 1, 3);
        gridPane.add(txtDescription, 0, 4, 2, 1);
        gridPane.add(btnConfirm, 0, 5, 2, 1);

        Scene primaryScene = new Scene(gridPane, 550, 350);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Add Event");
        primaryStage.show();

        btnConfirm.requestFocus();

        btnConfirm.setOnAction(e -> {
            Event event = new Event(txtName.getText(), txtDate.getText(), txtTime.getText(), txtAddress.getText(),
                    txtCity.getText(), txtState.getText(), txtZip.getText(), txtDescription.getText(), currentUserID);
            if (parentForm instanceof VolunteerWindow){
            primaryStage.hide();
            ((VolunteerWindow)parentForm).addEvent(event.idNumber);
            ((VolunteerWindow)parentForm).btnRefreshEventFeed.fire();
            }
            else if (parentForm instanceof AdminWindow){
                primaryStage.hide();
                ((AdminWindow)parentForm).addEvent(event.idNumber);
                ((AdminWindow)parentForm).btnRefreshEventFeed.fire();
            }

            String sqlEventInsertQuery = "INSERT INTO EVENT (EventID, Name, EventDate, Time, Address, City, State, Zip, Description, EventCreatorID) " +
                    "values (" + event.idNumber + ", '" + event.name + "', '" + event.date + "', '"+ event.time +
                    "', '" + event.address + "', '" + event.city + "', '" + event.state + "', " + event.zip + ", '" + event.description + "', " + currentUserID + ")";

            SqlExchange.sendDBCommand(sqlEventInsertQuery);
        });

    }

    public void setMaxWidth(TextArea ta, TextField... tf){
        for (TextField t: tf)
            t.setPrefWidth(250);
        ta.setPrefWidth(250);
    }


}
