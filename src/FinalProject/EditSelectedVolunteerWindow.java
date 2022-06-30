package FinalProject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class EditSelectedVolunteerWindow {

    TextField txtName = new TextField();
    TextField txtDateOfBirth = new TextField();
    TextField txtSpecialization = new TextField();
    TextField txtEmail = new TextField();
    TextField txtHoursServed = new TextField();
    TextField txtPhone = new TextField();
    TextField txtStatus = new TextField();
    TextField txtAddress = new TextField();
    TextField txtCity = new TextField();
    TextField txtState = new TextField();
    TextField txtZip = new TextField();
    TextField txtEmergencyContactPhone = new TextField();
    TextField txtWorkHistory = new TextField();
    TextField txtTotalHours = new TextField();
    TextField txtAdminID = new TextField();
    TextField txtUsername = new TextField();
    Button btnConfirm = new Button("Confirm Changes");
    Label lblPasswordExplanation = new Label("Use the change password button below if a volunteer has forgotten their password.\n" +
            "Inform the volunteer of their new password and encourage them to change their password again after logging in for safety.");
    Button btnChangePassword = new Button("Change Password");

    public EditSelectedVolunteerWindow(Volunteer volunteer, AdminWindow parentForm){
        Stage primaryStage = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(10);

        txtName.setPromptText("Name");
        txtDateOfBirth.setPromptText("Date of Birth");
        txtSpecialization.setPromptText("Specialization");
        txtEmail.setPromptText("Email");
        txtHoursServed.setPromptText("Hours Served");
        txtPhone.setPromptText("Phone Number");
        txtStatus.setPromptText("Volunteer Status");
        txtAddress.setPromptText("Street Address");
        txtCity.setPromptText("City");
        txtState.setPromptText("State");
        txtZip.setPromptText("Zip");
        txtEmergencyContactPhone.setPromptText("Emergency Contact Phone");
        txtWorkHistory.setPromptText("Work History");
        txtTotalHours.setPromptText("Total Hours");
        txtAdminID.setPromptText("Type 0 for regular volunteer, -1 for admin");
        txtUsername.setPromptText("Username");

        txtName.setText(volunteer.name);
        txtDateOfBirth.setText(volunteer.dateOfBirth);
        txtSpecialization.setText(volunteer.specialization);
        txtEmail.setText(volunteer.email);
        txtHoursServed.setText(String.valueOf(volunteer.hoursServed));
        txtPhone.setText(volunteer.phone);
        txtStatus.setText(volunteer.status);
        txtAddress.setText(volunteer.address);
        txtCity.setText(volunteer.city);
        txtState.setText(volunteer.state);
        txtZip.setText(volunteer.zip);
        txtEmergencyContactPhone.setText(volunteer.emergencyContactPhone);
        txtWorkHistory.setText(volunteer.workHistory);
        txtTotalHours.setText(String.valueOf(volunteer.totalHours));
        txtAdminID.setText(String.valueOf(volunteer.adminID));
        txtUsername.setText(volunteer.username);

        btnConfirm.setMinWidth(510);
        lblPasswordExplanation.setPrefWidth(510);
        lblPasswordExplanation.setWrapText(true);
        lblPasswordExplanation.setTextAlignment(TextAlignment.CENTER);
        btnChangePassword.setMinWidth(510);
        setMaxWidth(txtName, txtDateOfBirth, txtSpecialization, txtEmail, txtHoursServed, txtPhone, txtStatus, txtEmergencyContactPhone,
                txtAddress, txtCity, txtState, txtZip, txtTotalHours, txtAdminID, txtUsername, txtWorkHistory);

        gridPane.add(txtName, 0, 0);
        gridPane.add(txtDateOfBirth, 0, 1);
        gridPane.add(txtSpecialization, 0, 2);
        gridPane.add(txtEmail, 0, 3);
        gridPane.add(txtHoursServed, 0, 4);
        gridPane.add(txtPhone, 0, 5);
        gridPane.add(txtStatus, 0, 6);
        gridPane.add(txtEmergencyContactPhone, 0, 7);

        gridPane.add(txtAddress, 1, 0);
        gridPane.add(txtCity, 1, 1);
        gridPane.add(txtState, 1, 2);
        gridPane.add(txtZip, 1, 3);
        gridPane.add(txtWorkHistory, 1, 4);
        gridPane.add(txtTotalHours, 1, 5);
        gridPane.add(txtAdminID, 1, 6);
        gridPane.add(txtUsername, 1, 7);

        gridPane.add(btnConfirm, 0, 8, 2, 1);
        gridPane.add(lblPasswordExplanation, 0, 9, 2, 1);
        gridPane.add(btnChangePassword, 0, 10, 2, 1);


        Scene primaryScene = new Scene(gridPane, 550, 400);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Edit Volunteer's Info");
        primaryStage.show();

        btnConfirm.requestFocus();

        btnConfirm.setOnAction(e -> {
            volunteer.setName(txtName.getText());
            volunteer.setDateOfBirth(txtDateOfBirth.getText());
            volunteer.setSpecialization(txtSpecialization.getText());
            volunteer.setEmail(txtEmail.getText());
            volunteer.setHoursServed(Double.valueOf(txtHoursServed.getText()));
            volunteer.setPhone(txtPhone.getText());
            volunteer.setStatus(txtStatus.getText());
            volunteer.setAddress(txtAddress.getText());
            volunteer.setCity(txtCity.getText());
            volunteer.setState(txtState.getText());
            volunteer.setZip(txtZip.getText());
            volunteer.setEmergencyContactPhone(txtEmergencyContactPhone.getText());
            volunteer.setWorkHistory(txtWorkHistory.getText());
            volunteer.setTotalHours(Double.valueOf(txtTotalHours.getText()));
            volunteer.setAdminID(Integer.valueOf(txtAdminID.getText()));
            volunteer.setUsername(txtUsername.getText());

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

            ObservableList<Volunteer> volunteerObservableList
                    = FXCollections.observableArrayList(Volunteer.volunteerArrayList);
            ((AdminWindow) parentForm).clearUpdateTable(((AdminWindow) parentForm).volunteerListView, Volunteer.volunteerArrayList, volunteerObservableList);

            primaryStage.hide();
        });

        btnChangePassword.setOnAction(e -> {
            ChangePasswordWindow cpw = new ChangePasswordWindow(volunteer.idNumber);
        });
    }

    public void setMaxWidth(TextField... tf){
        for (TextField t: tf)
            t.setPrefWidth(250);
    }
}