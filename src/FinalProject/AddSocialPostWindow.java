package FinalProject;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AddSocialPostWindow {
    TextArea txtDescription = new TextArea();
    Button btnConfirm = new Button("Add Post");

    public AddSocialPostWindow(VolunteerWindow parentForm){
        Stage primaryStage = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(10);

        txtDescription.setPromptText("Type your social post");
        txtDescription.setMaxWidth(500);
        btnConfirm.setMinWidth(500);
        txtDescription.setMaxHeight(150);
        txtDescription.setWrapText(true);
        btnConfirm.setMinWidth(510);

        gridPane.add(txtDescription, 0, 0);
        gridPane.add(btnConfirm, 0, 1);

        Scene primaryScene = new Scene(gridPane, 550, 350);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Add a Social Post");
        primaryStage.show();

        btnConfirm.requestFocus();

        btnConfirm.setOnAction(e -> {
            SocialPost sp = new SocialPost(parentForm.getCurrentDate(), parentForm.getCurrentTime(),
                    parentForm.currentUser.idNumber, txtDescription.getText());
            primaryStage.hide();
            parentForm.addSocialPost(sp.userID);;
        });
    }




}
