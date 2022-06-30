package FinalProject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ApproveSelectedApplicationWindow {

    Label lblMessage = new Label("Do you wish to approve this application?");
    Button btnApprove = new Button("Approve");
    Button btnCancel = new Button("Cancel");

    public ApproveSelectedApplicationWindow(VolunteerApplication volApp, AdminWindow parentForm){
        Stage primaryStage = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(10);

        lblMessage.setStyle("-fx-font: 14 arial");
        lblMessage.setTextAlignment(TextAlignment.CENTER);

        gridPane.add(lblMessage, 0, 0, 2, 1);
        gridPane.add(btnCancel, 0, 1);
        gridPane.add(btnApprove, 1, 1);

        Scene primaryScene = new Scene(gridPane, 475, 175);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Confirm Application Approval");
        primaryStage.show();

        ObservableList<Volunteer> volunteerObservableList = FXCollections.observableArrayList(Volunteer.volunteerArrayList);
        ObservableList<VolunteerApplication> volunteerApplicationObservableList= FXCollections.observableArrayList(VolunteerApplication.volunteerApplicationArrayList);

        btnApprove.setOnAction(event -> {
            // create new volunteer
            Volunteer volunteer = new Volunteer(volApp.name, volApp.DoB, "New Learner", volApp.email,
                    0.0, volApp.phone, "Conditional Volunteer", volApp.address, volApp.city, volApp.State,
                    volApp.zip, volApp.EmergencyContactPhone, volApp.workHistory, 0.0, volApp.username, volApp.password, 0);

            // sql insert query for new volunteer
            String sqlVolunteerInsertQuery = "INSERT INTO VOLUNTEER (VolunteerID, Name, DateOfBirth, Specialization, EmailAddress, " +
                    "HoursServed, PhoneNumber, Status, Address, City, State, Zip, EmergencyContactNum, WorkHistory, TotalHours, UserName, Password, IsAdmin) " +
                    "values (" + volunteer.idNumber + ", '" + volunteer.name + "', '" + volunteer.dateOfBirth + "', '" + volunteer.specialization + "', '" + volunteer.email + "', " +
                    volunteer.hoursServed + ", " + volunteer.phone + ", '" + volunteer.status + "', '" + volunteer.address + "', '" + volunteer.city
                    + "', '" + volunteer.state + "', " + volunteer.zip + ", " + volunteer.emergencyContactPhone + ", '" + volunteer.workHistory + "', " + volunteer.totalHours
                    + ", '" + volunteer.username + "', '" + volunteer.password + "', " + volunteer.adminID + ")";

            SqlExchange.sendDBCommand(sqlVolunteerInsertQuery);

            // remove the approved application
            VolunteerApplication.volunteerApplicationArrayList.remove(volApp);

            // sql delete query for volunteer application
            String sqlVolunteerApplicationDeleteQuery = "DELETE from javauser.volunteerapplication where volunteerapplicationid = " + volApp.idNumber;

            SqlExchange.sendDBCommand(sqlVolunteerApplicationDeleteQuery);


            //update listviews on parent form
            volunteerObservableList.clear();
            volunteerObservableList.addAll(Volunteer.volunteerArrayList);
            volunteerApplicationObservableList.clear();
            volunteerApplicationObservableList.addAll(VolunteerApplication.volunteerApplicationArrayList);
            ((AdminWindow) parentForm).clearUpdateTable(((AdminWindow) parentForm).volunteerListView,
                    Volunteer.volunteerArrayList, volunteerObservableList);
            ((AdminWindow) parentForm).clearUpdateTable(((AdminWindow) parentForm).applicationListView,
                    VolunteerApplication.volunteerApplicationArrayList, volunteerApplicationObservableList);
            primaryStage.hide();
        });

        btnCancel.setOnAction(e -> {
            primaryStage.hide();
        });
    }
}
