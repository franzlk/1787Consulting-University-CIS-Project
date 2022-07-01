//1787 Consulting
//Course: CIS 484
//Final Project
//I promise that this work was done in accordance with the JMU honor code and
//I did not receive nor give unauthorized assistance in writing this program.
package FinalProject;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ViewSelectedVolunteerWindow {

    Label lblName = new Label();
    Label lblDateOfBirth = new Label();
    Label lblSpecialization = new Label();
    Label lblEmail = new Label();
    Label lblHoursServed = new Label();
    Label lblPhone = new Label();
    Label lblStatus = new Label();
    Label lblAddress = new Label();
    Label lblCity = new Label();
    Label lblState = new Label();
    Label lblZip = new Label();
    Label lblEmergencyContactPhone = new Label();
    Label lblWorkHistory = new Label();
    Label lblTotalHours = new Label();
    Label lblAdminID = new Label();
    Label lblUsername = new Label();
    
    public ViewSelectedVolunteerWindow(Volunteer volunteer){
        Stage primaryStage = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(10);

        lblName.setText("Name:\t" + volunteer.name);
        lblDateOfBirth.setText("Date of Birth:\t" + volunteer.dateOfBirth);
        lblSpecialization.setText("Specialization:\t" + volunteer.specialization);
        lblEmail.setText("Email:\t" + volunteer.email);
        lblHoursServed.setText("Hours Served:\t" + volunteer.hoursServed);
        lblPhone.setText("Phone Number:\t" + volunteer.phone);
        lblStatus.setText("Volunteer Status:\t" + volunteer.status);
        lblAddress.setText("Street Address:\t" + volunteer.address);
        lblCity.setText("City:\t" + volunteer.city);
        lblState.setText("State:\t" + volunteer.state);
        lblZip.setText("Zip:\t" + volunteer.zip);
        lblEmergencyContactPhone.setText("Emergency Contact Phone:\t" + volunteer.emergencyContactPhone);
        lblWorkHistory.setWrapText(true);
        lblWorkHistory.setMaxWidth(250);
        lblWorkHistory.setText("Work History:\t" + volunteer.workHistory);
        lblTotalHours.setText("Total Hours:\t" + volunteer.totalHours);
        if (volunteer.adminID == -1 ){
            lblAdminID.setText("Is Admin?\tTrue");
        }
        else{
            lblAdminID.setText("Is Admin?\tFalse");
        }
        lblUsername.setText("Username:\t" + volunteer.username);
        
        gridPane.add(lblName, 0, 0);
        gridPane.add(lblDateOfBirth, 0, 1);
        gridPane.add(lblSpecialization, 0, 2);
        gridPane.add(lblEmail, 0, 3);
        gridPane.add(lblHoursServed, 0, 4);
        gridPane.add(lblPhone, 0, 5);
        gridPane.add(lblStatus, 0, 6);
        gridPane.add(lblEmergencyContactPhone, 0, 7);

        gridPane.add(lblAddress, 1, 0);
        gridPane.add(lblCity, 1, 1);
        gridPane.add(lblState, 1, 2);
        gridPane.add(lblZip, 1, 3);
        gridPane.add(lblWorkHistory, 1, 4);
        gridPane.add(lblTotalHours, 1, 5);
        gridPane.add(lblAdminID, 1, 6);
        gridPane.add(lblUsername, 1, 7);

        Scene primaryScene = new Scene(gridPane, 550, 350);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("View Volunteer");
        primaryStage.show();
    }
}
