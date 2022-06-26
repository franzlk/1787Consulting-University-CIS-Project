package FinalProject;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class EditEventWindow {

    TextField txtName = new TextField();
    TextField txtDate = new TextField();
    TextField txtTime = new TextField();
    TextField txtAddress = new TextField();
    TextField txtCity = new TextField();
    TextField txtState = new TextField();
    TextArea txtDescription = new TextArea();
    Button btnConfirm = new Button("Confirm Changes to Event");

    public <T> EditEventWindow(int ID, T parentForm){
        Stage primaryStage = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(10);

        txtName.setText(Event.eventArrayList.get(ID-1).name);
        txtDate.setText(Event.eventArrayList.get(ID-1).date);
        txtTime.setText(Event.eventArrayList.get(ID-1).time);
        txtAddress.setText(Event.eventArrayList.get(ID-1).address);
        txtCity.setText(Event.eventArrayList.get(ID-1).city);
        txtState.setText(Event.eventArrayList.get(ID-1).state);
        txtDescription.setText(Event.eventArrayList.get(ID-1).description);

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
        primaryStage.setTitle("Edit Event");
        primaryStage.show();

        btnConfirm.requestFocus();

        btnConfirm.setOnAction(e -> {

            Event.eventArrayList.get(ID-1).setName(txtName.getText());
            Event.eventArrayList.get(ID-1).setDate(txtDate.getText());
            Event.eventArrayList.get(ID-1).setTime(txtTime.getText());
            Event.eventArrayList.get(ID-1).setAddress(txtAddress.getText());
            Event.eventArrayList.get(ID-1).setCity(txtCity.getText());
            Event.eventArrayList.get(ID-1).setState(txtState.getText());
            Event.eventArrayList.get(ID-1).setDescription(txtDescription.getText());
            if (parentForm instanceof VolunteerWindow){
                ((VolunteerWindow)parentForm).btnRefreshEventFeed.fire();}
            else if (parentForm instanceof AdminWindow){
                ((VolunteerWindow)parentForm).btnRefreshEventFeed.fire();}
            primaryStage.hide();

        });

    }

    public void setMaxWidth(TextArea ta, TextField... tf){
        for (TextField t: tf)
            t.setPrefWidth(250);
        ta.setPrefWidth(250);
    }
}
