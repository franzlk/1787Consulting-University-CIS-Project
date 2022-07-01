package FinalProject;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EventSignUpWindow {
    Label lblMessage = new Label();
    String message;
    String title;

    public EventSignUpWindow(int eventID, Volunteer currentUser){
        Event event = Event.getByID(eventID);

        if (Event.getByID(eventID).attendingVolunteerID==currentUser.idNumber){
            message = "You are already signed up to work at this event";
            title = "Existing Event Sign-Up Found";

            Event.getByID(eventID).attendingVolunteerID = currentUser.idNumber;


        }
        else if (Event.getByID(eventID).attendingVolunteerID==0){
            message = "You have successfully signed up to work at this event";
            title = "Successful Event Sign-Up";

            // sql edit query for pet
            String sqlEventEditQuery = "UPDATE EVENT SET " +
                    "AttendingVolunteerID = " + event.attendingVolunteerID + " " +
                    "WHERE eventID = " + event.idNumber;

            SqlExchange.sendDBCommand(sqlEventEditQuery);

            Event.getByID(eventID).attendingVolunteerID = currentUser.idNumber;
        }
        else{
            message = "This event is currently full. You cannot sign up.";
            title = "Unsuccessful Event Sign-Up";
        }

        Stage primaryStage = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(10);

        lblMessage.setStyle("-fx-font: 14 arial");
        lblMessage.setTextAlignment(TextAlignment.CENTER);
        lblMessage.setText(message);
        gridPane.add(lblMessage, 0, 0);

        Scene primaryScene = new Scene(gridPane, 475, 175);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle(title);
        primaryStage.show();

    }

}
