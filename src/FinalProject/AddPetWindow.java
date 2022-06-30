package FinalProject;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AddPetWindow {
    TextField txtName = new TextField();
    TextField txtAnimalType = new TextField();
    TextField txtSpecies = new TextField();
    TextField txtDoB = new TextField();
    TextField txtOwnerName = new TextField();
    TextField txtOwnerPhone = new TextField();
    TextField txtOwnerEmail = new TextField();
    TextField txtOwnerAddress = new TextField();
    TextField txtOwnerCity = new TextField();
    TextField txtOwnerState = new TextField();
    TextField txtOwnerZip = new TextField();
    TextArea txtComments = new TextArea();
    TextField txtVetBusinessName = new TextField();
    TextField txtVetPhone = new TextField();
    Button btnAdd = new Button("Add Pet");



    public <T> AddPetWindow(T parentForm, int currentUserID){
        Stage primaryStage = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(10);

        txtName.setPromptText("Pet Name");
        txtAnimalType.setPromptText("Type of Pet");
        txtSpecies.setPromptText("Species");
        txtDoB.setPromptText("Date of Birth");
        txtVetBusinessName.setPromptText("Vet's Business Name");
        txtVetPhone.setPromptText("Vet's Phone Number (no spaces or special characters)");
        txtOwnerName.setPromptText("Owner Name");
        txtOwnerPhone.setPromptText("Phone Number (no spaces or special characters)");
        txtOwnerEmail.setPromptText("Email");
        txtOwnerAddress.setPromptText("Street Address");
        txtOwnerCity.setPromptText("City");
        txtOwnerState.setPromptText("State");
        txtOwnerZip.setPromptText("Zip Code (no spaces or special characters)");
        txtComments.setPromptText("Miscellaneous Comments");

        setMaxWidth(txtName, txtAnimalType, txtSpecies, txtDoB, txtVetBusinessName, txtVetPhone, txtOwnerName, txtOwnerPhone,
                txtOwnerEmail, txtOwnerAddress, txtOwnerCity, txtOwnerState, txtOwnerZip);

        gridPane.add(txtName, 0, 0);
        gridPane.add(txtAnimalType, 0, 1);
        gridPane.add(txtSpecies, 0, 2);
        gridPane.add(txtDoB, 0, 3);
        gridPane.add(txtVetBusinessName, 0, 4);
        gridPane.add(txtVetPhone, 0, 5);

        gridPane.add(txtOwnerName, 1, 0);
        gridPane.add(txtOwnerPhone, 1, 1);
        gridPane.add(txtOwnerEmail, 1, 2);
        gridPane.add(txtOwnerAddress, 1, 3);
        gridPane.add(txtOwnerCity, 1, 4);
        gridPane.add(txtOwnerState, 1, 5);
        gridPane.add(txtOwnerZip, 1, 6);

        txtComments.setMaxHeight(150);
        txtComments.setWrapText(true);
        gridPane.add(txtComments, 0, 7, 2, 1);
        btnAdd.setMinWidth(510);
        gridPane.add(btnAdd, 0, 8, 2, 1);

        Scene primaryScene = new Scene(gridPane, 550, 450);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Add New Pet");
        primaryStage.show();

        btnAdd.requestFocus();





        btnAdd.setOnAction(e -> {
            Pet pet = new Pet(txtName.getText(), txtAnimalType.getText(), txtSpecies.getText(), txtDoB.getText(),
                    txtOwnerName.getText(), txtOwnerPhone.getText(), txtOwnerEmail.getText(), txtOwnerAddress.getText(),
                    txtOwnerCity.getText(), txtOwnerState.getText(), txtOwnerZip.getText(), txtComments.getText(),
                    txtVetBusinessName.getText(), txtVetPhone.getText());
            primaryStage.hide();

            ObservableList<Pet> petObservableList
                    = FXCollections.observableArrayList(Pet.petArrayList);

            if (parentForm instanceof VolunteerWindow){
                ((VolunteerWindow) parentForm).clearUpdateTable(((VolunteerWindow) parentForm).petListView, Pet.petArrayList, petObservableList);
            }

            else if (parentForm instanceof AdminWindow){
                ((AdminWindow) parentForm).clearUpdateTable(((AdminWindow) parentForm).petListView, Pet.petArrayList, petObservableList);
            }

            String sqlPetInsertQuery = "INSERT INTO PET (PetID, Name, AnimalType, Species, DateOfBirth, OwnerName, " +
                    "OwnerPhoneNumber, OwnerEmailAddress, OwnerAddress, OwnerCity, OwnerState, OwnerZip, Comments, VetBusinessName, VetPhoneNumber) " +
                    "values (" + pet.idNumber + ", '" + pet.name + "', '" + pet.animalType + "', '" + pet.species + "', '" + pet.dateOfBirth + "', " +
                    "'" + pet.ownerName + "', " + pet.ownerPhone + ",'" + pet.ownerEmail + "'," +
                    "'" + pet.ownerAddress + "', '" + pet.ownerCity + "', '" + pet.ownerState + "', " + pet.ownerZip +
                    ", '" + pet.comments + "', '" + pet.vetBusinessName + "', " + pet.vetPhone + ")";

            SqlExchange.sendDBCommand(sqlPetInsertQuery);
        });

    }

    public void setMaxWidth(TextField... tf){
        for (TextField t: tf)
            t.setPrefWidth(250);
    }

}
