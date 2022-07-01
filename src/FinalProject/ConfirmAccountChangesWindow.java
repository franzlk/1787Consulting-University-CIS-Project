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

public class ConfirmAccountChangesWindow {
    Label lblMessage = new Label("Account changes successfully applied.");

    public <T> ConfirmAccountChangesWindow(int userID, T parentForm){
        Volunteer volunteer = Volunteer.getByID(userID);
        Stage primaryStage = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(10);

        lblMessage.setStyle("-fx-font: 14 arial");
        lblMessage.setTextAlignment(TextAlignment.CENTER);

        gridPane.add(lblMessage, 0, 0);
        
        if (parentForm instanceof VolunteerWindow){
            Volunteer.getByID(userID).setName(((VolunteerWindow) parentForm).txtName.getText());
            Volunteer.getByID(userID).setDateOfBirth(((VolunteerWindow) parentForm).txtDoB.getText());
            Volunteer.getByID(userID).setEmail(((VolunteerWindow) parentForm).txtEmail.getText());
            Volunteer.getByID(userID).setPhone(((VolunteerWindow) parentForm).txtPhone.getText());
            Volunteer.getByID(userID).setAddress(((VolunteerWindow) parentForm).txtAddress.getText());
            Volunteer.getByID(userID).setCity(((VolunteerWindow) parentForm).txtCity.getText());
            Volunteer.getByID(userID).setState(((VolunteerWindow) parentForm).txtState.getText());
            Volunteer.getByID(userID).setZip(((VolunteerWindow) parentForm).txtZip.getText());
            Volunteer.getByID(userID).setWorkHistory(((VolunteerWindow) parentForm).txtWorkHistory.getText());
            //Volunteer.getByID(userID).setSpecialization((String) ((VolunteerWindow) parentForm).cbSpecialization.getSelectionModel().getSelectedItem());
            Volunteer.getByID(userID).setEmergencyContactPhone(((VolunteerWindow) parentForm).txtEmergencyContactPhone.getText());
            
        }
        else if (parentForm instanceof AdminWindow){
            Volunteer.getByID(userID).setName(((AdminWindow) parentForm).txtName.getText());
            Volunteer.getByID(userID).setDateOfBirth(((AdminWindow) parentForm).txtDoB.getText());
            Volunteer.getByID(userID).setEmail(((AdminWindow) parentForm).txtEmail.getText());
            Volunteer.getByID(userID).setPhone(((AdminWindow) parentForm).txtPhone.getText());
            Volunteer.getByID(userID).setAddress(((AdminWindow) parentForm).txtAddress.getText());
            Volunteer.getByID(userID).setCity(((AdminWindow) parentForm).txtCity.getText());
            Volunteer.getByID(userID).setState(((AdminWindow) parentForm).txtState.getText());
            Volunteer.getByID(userID).setZip(((AdminWindow) parentForm).txtZip.getText());
            Volunteer.getByID(userID).setWorkHistory(((AdminWindow) parentForm).txtWorkHistory.getText());
            //Volunteer.getByID(userID).setSpecialization((String) ((AdminWindow) parentForm).cbSpecialization.getSelectionModel().getSelectedItem());
            Volunteer.getByID(userID).setEmergencyContactPhone(((AdminWindow) parentForm).txtEmergencyContactPhone.getText());
        }

        // sql edit query for pet
        String sqlVolunteerEditQuery = "UPDATE VOLUNTEER SET " +
                "Name = '" + volunteer.name + "', " +
                "DateOfBirth = '" + volunteer.dateOfBirth + "', " +
                "Specialization = '" + volunteer.specialization + "', " +
                "EmailAddress = '" + volunteer.email + "', " +
                "HoursServed = " + volunteer.hoursServed + ", " +
                "PhoneNumber = '" + volunteer.phone + "', " +
                "Status = '" + volunteer.status + "', " +
                "Address = '" + volunteer.address + "', " +
                "City = '" + volunteer.city + "', " +
                "State = '" + volunteer.state + "', " +
                "Zip = " + volunteer.zip + ", " +
                "EmergencyContactNum = '" + volunteer.emergencyContactPhone + "', " +
                "WorkHistory = '" + volunteer.workHistory + "', " +
                "TotalHours = " + volunteer.totalHours + ", " +
                "UserName = '" + volunteer.username + "', " +
                "Password = '" + volunteer.password + "', " +
                "IsAdmin = " + volunteer.adminID + " " +
                "WHERE volunteerID = " + volunteer.idNumber;

        SqlExchange.sendDBCommand(sqlVolunteerEditQuery);

        Scene primaryScene = new Scene(gridPane, 475, 175);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Account Changes");
        primaryStage.show();
                
    }
}
