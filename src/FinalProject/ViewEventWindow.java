package FinalProject;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ViewEventWindow {

    Label lblName = new Label();
    Label lblDate = new Label();
    Label lblTime = new Label();
    Label lblAddress = new Label();
    Label lblCity = new Label();
    Label lblState = new Label();
    Label lblDescription = new Label();
    
    public ViewEventWindow(int ID){
        Stage primaryStage = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(10);

        lblName.setText("Name:\t" + Event.eventArrayList.get(ID-1).name);
        lblDate.setText("Date:\t" + Event.eventArrayList.get(ID-1).date);
        lblTime.setText("Time:\t" + Event.eventArrayList.get(ID-1).time);
        lblAddress.setText("Address:\t" + Event.eventArrayList.get(ID-1).address);
        lblCity.setText("City:\t" + Event.eventArrayList.get(ID-1).city);
        lblState.setText("State:\t" + Event.eventArrayList.get(ID-1).state);
        lblDescription.setText("Description:\t" + Event.eventArrayList.get(ID-1).description);

        gridPane.add(lblName, 0, 0);
        gridPane.add(lblDate, 0, 1);
        gridPane.add(lblTime, 0, 2);
        gridPane.add(lblAddress, 1, 0);
        gridPane.add(lblCity, 1, 1);
        gridPane.add(lblState, 1, 2);
        gridPane.add(lblDescription, 0, 3, 2, 1);

        Scene primaryScene = new Scene(gridPane, 550, 350);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("View Event");
        primaryStage.show();
    }
}