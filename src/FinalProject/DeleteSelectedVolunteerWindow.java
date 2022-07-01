//1787 Consulting
//Course: CIS 484
//Final Project
//I promise that this work was done in accordance with the JMU honor code and
//I did not receive nor give unauthorized assistance in writing this program.
package FinalProject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;


public class DeleteSelectedVolunteerWindow {
    Label lblMessage = new Label("Are you sure you want to remove this volunteer?");
    Button btnDelete = new Button("Delete");
    Button btnCancel = new Button("Cancel");

    public DeleteSelectedVolunteerWindow(Volunteer volunteer, AdminWindow parentForm){

        Stage primaryStage = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(10);

        lblMessage.setStyle("-fx-font: 14 arial");
        lblMessage.setTextAlignment(TextAlignment.CENTER);

        gridPane.add(lblMessage, 0, 0, 2, 1);
        gridPane.add(btnCancel, 0, 1);
        gridPane.add(btnDelete, 1, 1);

        Scene primaryScene = new Scene(gridPane, 475, 175);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Delete Volunteer");
        primaryStage.show();

        ObservableList<Volunteer> volunteerObservableList
                = FXCollections.observableArrayList(Volunteer.volunteerArrayList);

        btnDelete.setOnAction(e -> {
            // sql delete query for volunteer application
            String sqlVolunteerDeleteQuery = "DELETE from javauser.volunteer where volunteerid = " + volunteer.idNumber;

            SqlExchange.sendDBCommand(sqlVolunteerDeleteQuery);

            Volunteer.volunteerArrayList.remove(volunteer);

            volunteerObservableList.clear();
            volunteerObservableList.addAll(Volunteer.volunteerArrayList);
            ((AdminWindow) parentForm).clearUpdateTable(((AdminWindow) parentForm).volunteerListView, Volunteer.volunteerArrayList, volunteerObservableList);

            primaryStage.hide();
        });

        btnCancel.setOnAction(e -> {
            primaryStage.hide();
        });


    }
}
