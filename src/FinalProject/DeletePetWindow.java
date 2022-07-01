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

public class DeletePetWindow {
    Label lblMessage = new Label("Are you sure you want to remove this pet?");
    Button btnDelete = new Button("Delete");
    Button btnCancel = new Button("Cancel");

    public <T> DeletePetWindow(Pet pet, T parentForm){
        Stage primaryStage = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(10);

        lblMessage.setStyle("-fx-font: 14 arial");
        lblMessage.setTextAlignment(TextAlignment.CENTER);

        gridPane.add(lblMessage, 0, 0, 2, 1);
        gridPane.add(btnCancel, 0, 1);
        gridPane.add(btnDelete, 1, 1);

        Scene primaryScene = new Scene(gridPane, 475, 175);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Delete Pet");
        primaryStage.show();

        ObservableList<Pet> petObservableList
                = FXCollections.observableArrayList(Pet.petArrayList);

        btnDelete.setOnAction(e -> {
            if (parentForm instanceof VolunteerWindow){
                for (Pet p : Pet.petArrayList){
                    if (p.getIdNumber()==pet.idNumber){
                        // sql delete query for pet
                        String sqlPetDeleteQuery = "DELETE from javauser.pet where petid = " + p.idNumber;
                        SqlExchange.sendDBCommand(sqlPetDeleteQuery);

                        Pet.petArrayList.remove(p);
                        ((VolunteerWindow)parentForm).clearUpdateTable(((VolunteerWindow) parentForm).petListView, Pet.petArrayList, petObservableList);
                        break;
                    }
                }}
            else if (parentForm instanceof AdminWindow){
                for (Pet p : Pet.petArrayList){
                    if (p.getIdNumber()==pet.idNumber){
                        // sql delete query for pet
                        String sqlPetDeleteQuery = "DELETE from javauser.pet where petid = " + p.idNumber;

                        SqlExchange.sendDBCommand(sqlPetDeleteQuery);

                        Pet.petArrayList.remove(p);
                        ((AdminWindow)parentForm).clearUpdateTable(((AdminWindow) parentForm).petListView, Pet.petArrayList, petObservableList);
                        break;
                    }
                }

            }

            primaryStage.hide();
        });

        btnCancel.setOnAction(e -> {
            primaryStage.hide();
        });

    }

}
