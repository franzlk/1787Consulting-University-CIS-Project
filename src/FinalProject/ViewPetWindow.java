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

public class ViewPetWindow {

    Label lblName = new Label();
    Label lblAnimalType = new Label();
    Label lblSpecies = new Label();
    Label lblDoB = new Label();
    Label lblOwnerName = new Label();
    Label lblOwnerPhone = new Label();
    Label lblOwnerEmail = new Label();
    Label lblOwnerAddress = new Label();
    Label lblOwnerCity = new Label();
    Label lblOwnerState = new Label();
    Label lblOwnerZip = new Label();
    Label lblComments = new Label();
    Label lblVetBusinessName = new Label();
    Label lblVetPhone = new Label();

    public ViewPetWindow(Pet pet){
        Stage primaryStage = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(10);

        lblName.setText("Pet Name:\t" + pet.name);
        lblAnimalType.setText("Type of Pet:\t" + pet.animalType);
        lblSpecies.setText("Species:\t" + pet.species);
        lblDoB.setText("Date of Birth:\t" + pet.dateOfBirth);
        lblVetBusinessName.setText("Vet's Business Name:\t" + pet.vetBusinessName);
        lblVetPhone.setText("Vet's Phone Number:\t" + pet.vetPhone);
        lblOwnerName.setText("Owner Name:\t" + pet.ownerName);
        lblOwnerPhone.setText("Phone Number:\t" + pet.ownerPhone);
        lblOwnerEmail.setText("Email:\t" + pet.ownerEmail);
        lblOwnerAddress.setText("Street Address:\t" + pet.ownerAddress);
        lblOwnerCity.setText("City:\t" + pet.ownerCity);
        lblOwnerState.setText("State:\t" + pet.ownerState);
        lblOwnerZip.setText("Zip Code:\t" + pet.ownerZip);
        lblComments.setText("Comments:\t" + pet.comments);

        lblComments.setMaxWidth(500);
        lblComments.setWrapText(true);

        gridPane.add(lblName, 0, 0);
        gridPane.add(lblAnimalType, 0, 1);
        gridPane.add(lblSpecies, 0, 2);
        gridPane.add(lblDoB, 0, 3);
        gridPane.add(lblVetBusinessName, 0, 4);
        gridPane.add(lblVetPhone, 0, 5);

        gridPane.add(lblOwnerName, 1, 0);
        gridPane.add(lblOwnerPhone, 1, 1);
        gridPane.add(lblOwnerEmail, 1, 2);
        gridPane.add(lblOwnerAddress, 1, 3);
        gridPane.add(lblOwnerCity, 1, 4);
        gridPane.add(lblOwnerState, 1, 5);
        gridPane.add(lblOwnerZip, 1, 6);

        gridPane.add(lblComments, 0, 7, 2, 1);
        
        Scene primaryScene = new Scene(gridPane, 550, 350);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("View Pet");
        primaryStage.show();
    }
}
