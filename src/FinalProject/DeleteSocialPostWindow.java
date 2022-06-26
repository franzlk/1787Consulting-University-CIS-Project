package FinalProject;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class DeleteSocialPostWindow {
    Label lblMessage = new Label("Are you sure you want to delete this post?");
    Button btnDelete = new Button("Delete");
    Button btnCancel = new Button("Cancel");

    public DeleteSocialPostWindow(int ID, VolunteerWindow parentForm){
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
        primaryStage.setTitle("Delete Post");
        primaryStage.show();

        btnDelete.setOnAction(e -> {
            for (SocialPost sp : SocialPost.socialPostArrayList){
                if (sp.getIdNumber()==ID){
                    SocialPost.socialPostArrayList.remove(sp);
                    parentForm.btnRefreshFeed.fire();
                    break;
                }
            }

            primaryStage.hide();
        });

        btnCancel.setOnAction(e -> {
            primaryStage.hide();
        });

    }
}
