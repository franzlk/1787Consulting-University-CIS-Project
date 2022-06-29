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

        lblName.setText("Name:\t" + Event.getByID(ID).name);
        lblDate.setText("Date:\t" + Event.getByID(ID).date);
        lblTime.setText("Time:\t" + Event.getByID(ID).time);
        lblAddress.setText("Address:\t" + Event.getByID(ID).address);
        lblCity.setText("City:\t" + Event.getByID(ID).city);
        lblState.setText("State:\t" + Event.getByID(ID).state);
        lblDescription.setText("Description:\t" + Event.getByID(ID).description);
        lblDescription.setMaxWidth(500);
        lblDescription.setWrapText(true);

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
