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
    TextArea txtDescription = new TextArea();
    Button btnConfirm = new Button("Confirm Event");

    public <T> AddEventWindow(T parentForm){
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
        txtDescription.setPromptText("Event Description");

        // formatting
        setMaxWidth(txtDescription, txtName, txtDate, txtTime, txtAddress,
                txtCity, txtState);
        txtDescription.setMaxHeight(150);
        txtDescription.setWrapText(true);
        btnConfirm.setMinWidth(510);

        gridPane.add(txtName, 0, 0);
        gridPane.add(txtDate, 0, 1);
        gridPane.add(txtTime, 0, 2);
        gridPane.add(txtAddress, 1, 0);
        gridPane.add(txtCity, 1, 1);
        gridPane.add(txtState, 1, 2);
        gridPane.add(txtDescription, 0, 3, 2, 1);
        gridPane.add(btnConfirm, 0, 4, 2, 1);

        Scene primaryScene = new Scene(gridPane, 550, 350);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Add Event");
        primaryStage.show();

        btnConfirm.requestFocus();

        btnConfirm.setOnAction(e -> {
            if (parentForm instanceof VolunteerWindow){
            Event event = new Event(txtName.getText(), txtDate.getText(), txtTime.getText(), txtAddress.getText(),
                    txtCity.getText(), txtState.getText(), txtDescription.getText(), ((VolunteerWindow)parentForm).currentUser.idNumber);
            primaryStage.hide();
            ((VolunteerWindow)parentForm).addEvent(event.idNumber);
            ((VolunteerWindow)parentForm).btnRefreshEventFeed.fire();}

            else if (parentForm instanceof AdminWindow){
                Event event = new Event(txtName.getText(), txtDate.getText(), txtTime.getText(), txtAddress.getText(),
                        txtCity.getText(), txtState.getText(), txtDescription.getText(), ((VolunteerWindow)parentForm).currentUser.idNumber);
                primaryStage.hide();
                ((AdminWindow)parentForm).addEvent(event.idNumber);
                ((AdminWindow)parentForm).btnRefreshEventFeed.fire();}
        });

    }

    public void setMaxWidth(TextArea ta, TextField... tf){
        for (TextField t: tf)
            t.setPrefWidth(250);
        ta.setPrefWidth(250);
    }


}
