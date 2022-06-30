package FinalProject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class EditPetWindow {
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
    Button btnConfirm = new Button("Confirm Changes");
    
    public <T> EditPetWindow(T parentForm, Pet pet){
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
        txtVetPhone.setPromptText("Vet's Phone Number");//
        txtOwnerName.setPromptText("Owner Name");
        txtOwnerPhone.setPromptText("Phone Number");
        txtOwnerEmail.setPromptText("Email");
        txtOwnerAddress.setPromptText("Street Address");
        txtOwnerCity.setPromptText("City");
        txtOwnerState.setPromptText("State");
        txtOwnerZip.setPromptText("Zip Code");
        txtComments.setPromptText("Miscellaneous Comments");

        setMaxWidth(txtName, txtAnimalType, txtSpecies, txtDoB, txtVetBusinessName, txtVetPhone, txtOwnerName, txtOwnerPhone,
                txtOwnerEmail, txtOwnerAddress, txtOwnerCity, txtOwnerState, txtOwnerZip);

        txtName.setText(pet.name);
        txtAnimalType.setText(pet.animalType);
        txtSpecies.setText(pet.species);
        txtDoB.setText(pet.dateOfBirth);
        txtVetBusinessName.setText(pet.vetBusinessName);
        txtVetPhone.setText(pet.vetPhone);
        txtOwnerName.setText(pet.ownerName);
        txtOwnerPhone.setText(pet.ownerPhone);
        txtOwnerEmail.setText(pet.ownerEmail);
        txtOwnerAddress.setText(pet.ownerAddress);
        txtOwnerCity.setText(pet.ownerCity);
        txtOwnerState.setText(pet.ownerState);
        txtOwnerZip.setText(pet.ownerZip);
        txtComments.setText(pet.comments);
        
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
        btnConfirm.setMinWidth(510);
        gridPane.add(btnConfirm, 0, 8, 2, 1);

        Scene primaryScene = new Scene(gridPane, 550, 450);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Edit Pet Info");
        primaryStage.show();

        btnConfirm.requestFocus();

        btnConfirm.setOnAction(e -> {
            pet.setName(txtName.getText());
            pet.setAnimalType(txtAnimalType.getText());
            pet.setSpecies(txtSpecies.getText());
            pet.setDateOfBirth(txtDoB.getText());
            pet.setVetBusinessName(txtVetBusinessName.getText());
            pet.setVetPhone(txtVetPhone.getText());
            pet.setOwnerName(txtOwnerName.getText());
            pet.setOwnerPhone(txtOwnerPhone.getText());
            pet.setOwnerEmail(txtOwnerEmail.getText());
            pet.setOwnerAddress(txtOwnerAddress.getText());
            pet.setOwnerCity(txtOwnerCity.getText());
            pet.setOwnerState(txtOwnerState.getText());
            pet.setOwnerZip(txtOwnerZip.getText());
            pet.setComments(txtComments.getText());

            ObservableList<Pet> petObservableList
                    = FXCollections.observableArrayList(Pet.petArrayList);

            if (parentForm instanceof VolunteerWindow){
                ((VolunteerWindow) parentForm).clearUpdateTable(((VolunteerWindow) parentForm).petListView, Pet.petArrayList, petObservableList);
            }

            else if (parentForm instanceof AdminWindow){
                ((AdminWindow) parentForm).clearUpdateTable(((AdminWindow) parentForm).petListView, Pet.petArrayList, petObservableList);
            }

            // sql delete query for volunteer application
            String sqlPetEditQuery = "UPDATE PET SET " +
                    "Name = '" + pet.name + "', " +
                    "AnimalType = '" + pet.animalType + "', " +
                    "Species = '" + pet.species + "', " +
                    "DateOfBirth = '" + pet.dateOfBirth + "', " +
                    "OwnerName = '" + pet.ownerName + "', " +
                    "OwnerPhoneNumber = '" + pet.ownerPhone + "', " +
                    "OwnerEmailAddress = '" + pet.ownerEmail + "', " +
                    "OwnerAddress = '" + pet.ownerAddress + "', " +
                    "OwnerCity = '" + pet.ownerCity + "', " +
                    "OwnerState = '" + pet.ownerState + "', " +
                    "OwnerZip = " + pet.ownerZip + ", " + //
                    "Comments = '" + pet.comments + "', " +
                    "VetBusinessName = '" + pet.vetBusinessName + "', " +
                    "VetPhoneNumber = '" + pet.vetPhone + "' " +
                    "WHERE PETID = " + pet.idNumber;

            SqlExchange.sendDBCommand(sqlPetEditQuery);

        });

    }

    public void setMaxWidth(TextField... tf){
        for (TextField t: tf)
            t.setPrefWidth(250);
    }

}