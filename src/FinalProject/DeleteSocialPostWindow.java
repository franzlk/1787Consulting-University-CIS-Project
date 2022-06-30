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

    public <T> DeleteSocialPostWindow(int ID, T parentForm, VBox homeVBox, AnchorPane anchorPane){
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
            if (parentForm instanceof VolunteerWindow){
                SocialPost.socialPostArrayList.remove(SocialPost.getByID(ID));
                ((VolunteerWindow)parentForm).btnRefreshFeed.fire();

            }
            else if (parentForm instanceof AdminWindow){
                SocialPost.socialPostArrayList.remove(SocialPost.getByID(ID));
                ((AdminWindow)parentForm).btnRefreshFeed.fire();
            }

            // sql delete query for volunteer application
            String sqlSocialPostDeleteQuery = "DELETE from javauser.socialposts where postid = " + ID;

            SqlExchange.sendDBCommand(sqlSocialPostDeleteQuery);

            homeVBox.getChildren().remove(anchorPane);

            primaryStage.hide();
        });

        btnCancel.setOnAction(e -> {
            primaryStage.hide();
        });

    }
}
