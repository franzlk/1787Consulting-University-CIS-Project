package FinalProject;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AddNewPetWindow {
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

    public <T> AddNewPetWindow(T parentForm){
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
    }
}
