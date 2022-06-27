package FinalProject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


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
                for (Volunteer v : Volunteer.volunteerArrayList) {
                    if (v.getIdNumber() == volunteer.getIdNumber()) {
                        Volunteer.volunteerArrayList.remove(v);
                        ((AdminWindow) parentForm).clearUpdateTable(((AdminWindow) parentForm).volunteerListView, Volunteer.volunteerArrayList, volunteerObservableList);

                    }
                    break;


                }
                primaryStage.hide();
        });

        btnCancel.setOnAction(e -> {
            primaryStage.hide();
        });


    }
}
