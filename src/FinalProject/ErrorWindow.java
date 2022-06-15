package FinalProject;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ErrorWindow {
    Label lblMessage = new Label();

    public ErrorWindow(String title, String message){
        Stage primaryStage = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(10);

        lblMessage.setStyle("-fx-font: 14 arial");
        lblMessage.setText(message);
        gridPane.add(lblMessage, 0, 0);

        Scene primaryScene = new Scene(gridPane, 475, 175);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle(title);
        primaryStage.show();
    }
}
