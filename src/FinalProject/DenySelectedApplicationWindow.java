package FinalProject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class DenySelectedApplicationWindow {
    Label lblMessage = new Label("Are you sure you want to deny this application?");
    Button btnDeny = new Button("Deny");
    Button btnCancel = new Button("Cancel");

    public DenySelectedApplicationWindow(VolunteerApplication volApp, AdminWindow parentForm){
        Stage primaryStage = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(10);

        lblMessage.setStyle("-fx-font: 14 arial");
        lblMessage.setTextAlignment(TextAlignment.CENTER);

        gridPane.add(lblMessage, 0, 0, 2, 1);
        gridPane.add(btnCancel, 0, 1);
        gridPane.add(btnDeny, 1, 1);

        Scene primaryScene = new Scene(gridPane, 475, 175);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Confirm Application Denial");
        primaryStage.show();

        ObservableList<VolunteerApplication> volunteerApplicationObservableList= FXCollections.observableArrayList(VolunteerApplication.volunteerApplicationArrayList);

        btnDeny.setOnAction(event -> {
            // sql delete query for volunteer application
            String sqlVolunteerApplicationDeleteQuery = "DELETE from javauser.volunteerapplication where volunteerapplicationid = " + volApp.idNumber;

            SqlExchange.sendDBCommand(sqlVolunteerApplicationDeleteQuery);

            //remove denied application
            VolunteerApplication.volunteerApplicationArrayList.remove(volApp);


            //update listviews on parent form
            volunteerApplicationObservableList.clear();
            volunteerApplicationObservableList.addAll(VolunteerApplication.volunteerApplicationArrayList);

            ((AdminWindow) parentForm).clearUpdateTable(((AdminWindow) parentForm).applicationListView,
                    VolunteerApplication.volunteerApplicationArrayList, volunteerApplicationObservableList);
            primaryStage.hide();
        });

        btnCancel.setOnAction(e -> {
            primaryStage.hide();
        });
    }
}
