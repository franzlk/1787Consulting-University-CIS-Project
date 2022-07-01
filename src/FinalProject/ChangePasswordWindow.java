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

public class ChangePasswordWindow {
    TextField txtPassword = new TextField();
    Button btnConfirm = new Button("Confirm New Password");

    public ChangePasswordWindow(int userID){
        Stage primaryStage = new Stage();
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);

        txtPassword.setPromptText("Enter new password");

        vbox.getChildren().addAll(txtPassword, btnConfirm);
        txtPassword.setMaxWidth(225);

        Scene primaryScene = new Scene(vbox, 400, 100);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("BARK Login");
        primaryStage.show();

        btnConfirm.requestFocus();

        btnConfirm.setOnAction(event -> {
            Volunteer.getByID(userID).setPassword(txtPassword.getText());

            // sql edit query for updating password
            String sqlVolunteerEditQuery = "UPDATE VOLUNTEER SET " +
                    "Password = '" + Volunteer.getByID(userID).password + "' " +
                    "WHERE volunteerID = " + userID;

            SqlExchange.sendDBCommand(sqlVolunteerEditQuery);

            primaryStage.hide();
        });

    }
}
