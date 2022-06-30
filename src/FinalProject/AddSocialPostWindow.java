package FinalProject;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddSocialPostWindow {
    TextArea txtDescription = new TextArea();
    Button btnConfirm = new Button("Add Post");

    public <T> AddSocialPostWindow(T parentForm){
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
            if (parentForm instanceof VolunteerWindow){
                SocialPost sp = new SocialPost(((VolunteerWindow)parentForm).getCurrentDate(), ((VolunteerWindow)parentForm).getCurrentTime(),
                        ((VolunteerWindow)parentForm).currentUser.idNumber, txtDescription.getText());
                primaryStage.hide();
                ((VolunteerWindow)parentForm).addSocialPost(sp.userID);
                ((VolunteerWindow)parentForm).btnRefreshFeed.fire();

                String sqlSocialPostInsertQuery = "INSERT INTO SOCIALPOSTS (PostID, VolunteerID, Content, CreationDate, Time) " +
                        "values (" + sp.idNumber + ", " + ((VolunteerWindow)parentForm).currentUser.idNumber + ", '" + sp.text +
                        "', '" + sp.date + "', '" + sp.time + "')";

                SqlExchange.sendDBCommand(sqlSocialPostInsertQuery);

            }

            else if (parentForm instanceof AdminWindow){
                SocialPost sp = new SocialPost(((AdminWindow)parentForm).getCurrentDate(), ((AdminWindow)parentForm).getCurrentTime(),
                        ((AdminWindow)parentForm).currentUser.idNumber, txtDescription.getText());
                primaryStage.hide();
                ((AdminWindow)parentForm).addSocialPost(sp.userID);
                ((AdminWindow)parentForm).btnRefreshFeed.fire();

                String sqlSocialPostInsertQuery = "INSERT INTO SOCIALPOSTS (PostID, VolunteerID, Content, CreationDate, Time) " +
                        "values (" + sp.idNumber + ", " + ((AdminWindow)parentForm).currentUser.idNumber + ", '" + sp.text +
                        "', '" + sp.date + "', '" + sp.time + "')";

                SqlExchange.sendDBCommand(sqlSocialPostInsertQuery);

                }
        });
    }



}
