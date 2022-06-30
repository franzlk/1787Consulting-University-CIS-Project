package FinalProject;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SignUpWindow {

    // Sign up scene nodes
    Label lblBarkApplication = new Label("Submit an application to become a BARK Volunteer!");
    TextField txtName = new TextField();
    TextField txtDoB = new TextField();
    TextField txtEmail = new TextField();
    TextField txtPhone = new TextField();
    TextField txtEmergencyContactPhone = new TextField();
    TextArea txtWorkHistory = new TextArea();
    Label lblSpecializationPreference = new Label("Specialization Preference");
    ComboBox cbSpecializationPreference = new ComboBox(FXCollections
            .observableArrayList(Specialization.getSpecializationArrayList()));
    Label lblShadowPreference = new Label("Shadow Preference");
    ComboBox cbShadowPreference = new ComboBox(FXCollections
            .observableArrayList(Volunteer.volunteerNameArrayList));
    TextField txtAddress = new TextField();
    TextField txtCity = new TextField();
    TextField txtState = new TextField();
    TextField txtZip = new TextField();
    TextField txtUsername = new TextField();
    PasswordField txtPassword = new PasswordField();
    Label spacer1 = new Label();
    Label spacer2 = new Label();
    Label spacer3 = new Label();
    Button btnSignUp = new Button("Submit Application");

    public SignUpWindow(){
        Stage primaryStage = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(10);

        txtName.setPromptText("Name");
        txtDoB.setPromptText("Date of birth");
        txtEmail.setPromptText("Email");
        txtPhone.setPromptText("Phone Number (no spaces or special characters)");
        txtEmergencyContactPhone.setPromptText("Emergency Contact Phone Number (no spaces or special characters)");
        txtWorkHistory.setPromptText("Work History");
        txtAddress.setPromptText("Street Address");
        txtCity.setPromptText("City");
        txtState.setPromptText("State");
        txtZip.setPromptText("Zip Code (no spaces or special characters)");
        txtUsername.setPromptText("Username");
        txtPassword.setPromptText("Password");

        // formatting
        setMaxWidth(txtWorkHistory, txtName, txtDoB, txtEmail, txtPhone,
                txtEmergencyContactPhone,  txtAddress, txtCity, txtState, txtZip,txtUsername, txtPassword);
        txtWorkHistory.setMaxHeight(150);
        txtWorkHistory.setWrapText(true);
        btnSignUp.setMinWidth(588);

        gridPane.add(lblBarkApplication, 0, 0, 2, 1);
        lblBarkApplication.setStyle("-fx-font: 18 arial");
        gridPane.add(txtName, 0, 1);
        gridPane.add(txtDoB, 0, 2);
        gridPane.add(txtEmail, 0, 3);
        gridPane.add(txtPhone, 0, 4);
        gridPane.add(txtAddress, 0, 5);
        gridPane.add(txtCity, 0, 6);
        gridPane.add(txtState, 0, 7);
        gridPane.add(txtZip, 0, 8);
        gridPane.add(spacer1, 0, 9);
        gridPane.add(spacer2, 0, 10);
        gridPane.add(txtWorkHistory, 1, 1, 2, 5);
        gridPane.add(lblSpecializationPreference, 1, 6);
        gridPane.add(cbSpecializationPreference, 2, 6);
        gridPane.add(lblShadowPreference, 1, 7);
        gridPane.add(cbShadowPreference, 2, 7);
        gridPane.add(txtEmergencyContactPhone, 1, 8, 2, 1);

        gridPane.add(txtUsername, 0, 11);
        gridPane.add(txtPassword, 1, 11, 2, 1);
        gridPane.add(spacer3, 0, 12);
        gridPane.add(btnSignUp, 0, 13, 3, 1);

        Scene primaryScene = new Scene(gridPane, 600, 600);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Bark Application");
        primaryStage.show();

        btnSignUp.requestFocus();

        btnSignUp.setOnAction(e -> {
            VolunteerApplication newVA = new VolunteerApplication(txtName.getText(), txtDoB.getText(), txtEmail.getText(),
                    txtPhone.getText(), txtAddress.getText(), txtCity.getText(),
                    txtState.getText(), txtZip.getText(), txtWorkHistory.getText(),
                    (String)cbSpecializationPreference.getSelectionModel().getSelectedItem(),
                    (String)cbShadowPreference.getSelectionModel().getSelectedItem(), txtEmergencyContactPhone.getText(),
                    txtUsername.getText(), txtPassword.getText());

            String sqlVolunteerApplicationInsertQuery = "INSERT INTO VOLUNTEERAPPLICATION(VolunteerApplicationID, Name, DateOfBirth, EmailAddress, " +
                    "PhoneNumber, ShadowPreference, Address, City, State, Zip, WorkHistory, PreferredSpecialization, EmergencyContactNum, Username, Password) " +
                    "values (" + newVA.idNumber + ", '" + newVA.name + "', '" + newVA.DoB + "', '" + newVA.email + "', " +
                    newVA.phone + ", '" + newVA.ShadowPreference + "', '" + newVA.address + "','" + newVA.city + "','" + newVA.State +
                    "'," + newVA.zip + ",'" + newVA.workHistory + "','" + newVA.specializationPreference + "'," + newVA.EmergencyContactPhone + ", '" + newVA.username + "', " +
                    "'" + newVA.password + "')";

            SqlExchange.sendDBCommand(sqlVolunteerApplicationInsertQuery);

            primaryStage.hide();
            GenericMessageWindow newAppWindow = new GenericMessageWindow("Application successfully submitted",
                    "Your application has been submitted.\n\nPlease try logging in a later date" +
                            " with your chosen username\nand password after your volunteer application is approved.");
        });

    }
    public void setMaxWidth(TextArea ta, TextField... tf){
        for (TextField t: tf)
            t.setPrefWidth(250);
        ta.setPrefWidth(250);
    }

}
