package FinalProject;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class DeleteEventWindow {
    Label lblMessage = new Label("Are you sure you want to delete this event?");
    Button btnDelete = new Button("Delete");
    Button btnCancel = new Button("Cancel");

    public <T> DeleteEventWindow(int ID, T parentForm){
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
        primaryStage.setTitle("Delete Event");
        primaryStage.show();

        btnDelete.setOnAction(e -> {
            if (parentForm instanceof VolunteerWindow){
            for (Event ev : Event.eventArrayList){
                if (ev.getIdNumber()==ID){
                    Event.eventArrayList.remove(ev);
                    ((VolunteerWindow)parentForm).btnRefreshEventFeed.fire();
                    break;
                }
            }}
            else if (parentForm instanceof AdminWindow){
                for (Event ev : Event.eventArrayList){
                    if (ev.getIdNumber()==ID){
                        Event.eventArrayList.remove(ev);
                        ((AdminWindow)parentForm).btnRefreshEventFeed.fire();
                        break;
                    }
                }}

            primaryStage.hide();
        });

        btnCancel.setOnAction(e -> {
            primaryStage.hide();
        });

    }
}
