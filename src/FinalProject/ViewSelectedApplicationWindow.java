package FinalProject;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ViewSelectedApplicationWindow {

    Label lblName = new Label();
    Label lblDoB = new Label();
    Label lblEmail = new Label();
    Label lblPhone = new Label();
    Label lblEmergencyContactPhone = new Label();
    Label lblWorkHistory = new Label();
    Label lblSpecializationPreference = new Label();
    Label lblShadowPreference = new Label();
    Label lblAddress = new Label();
    Label lblCity = new Label();
    Label lblState = new Label();
    Label lblZip = new Label();
    Label lblUsername = new Label();
    
    public ViewSelectedApplicationWindow(VolunteerApplication volApp){
        Stage primaryStage = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(10);

        setPrefWidth(lblName, lblDoB, lblEmail, lblPhone, lblEmergencyContactPhone, lblWorkHistory, lblAddress, lblCity,
                lblState, lblZip, lblShadowPreference, lblSpecializationPreference, lblUsername);

        lblName.setText("Name:\t" + volApp.name);
        lblDoB.setText("Date of birth:\t" + volApp.DoB);
        lblEmail.setText("Email:\t"+volApp.email);
        lblPhone.setText("Phone Number:\t"+volApp.phone);
        lblEmergencyContactPhone.setText("Emergency Contact Phone Number:\t"+ volApp.EmergencyContactPhone);
        lblWorkHistory.setText("Work History:\t"+volApp.workHistory);
        lblAddress.setText("Street Address:\t"+volApp.address);
        lblCity.setText("City:\t"+volApp.city);
        lblState.setText("State:\t" + volApp.State);
        lblZip.setText("Zip Code:\t" + volApp.zip);
        lblSpecializationPreference.setText("Specialization Preference:\t" + volApp.specializationPreference); //add to application
        lblShadowPreference.setText("Shadow Preference:\t"); // add to application
        lblUsername.setText("Username:\t" + volApp.username);

        gridPane.add(lblName, 0, 0);
        gridPane.add(lblDoB, 0, 1);
        gridPane.add(lblEmail, 0, 2);
        gridPane.add(lblPhone, 0, 3);
        gridPane.add(lblAddress, 0, 4);
        gridPane.add(lblCity, 0, 5);
        gridPane.add(lblState, 0, 6);
        gridPane.add(lblZip, 0, 7);
        gridPane.add(lblWorkHistory, 1, 0, 1, 4);
        gridPane.add(lblUsername, 1, 4);
        gridPane.add(lblSpecializationPreference, 1, 5);
        gridPane.add(lblShadowPreference, 1, 6);
        gridPane.add(lblEmergencyContactPhone, 1, 7);


        Scene primaryScene = new Scene(gridPane, 620, 400);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Submitted Application");
        primaryStage.show();
        

    }

    public void setPrefWidth(Label... labels){
        for (Label l: labels)
            l.setMinWidth(250);
    }
}
