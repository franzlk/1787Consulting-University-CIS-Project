package FinalProject;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SignUpWindow {

    // Sign up scene nodes
    TextField txtName = new TextField();
    TextField txtEmail = new TextField();
    TextField txtUsername = new TextField();
    TextField txtPassword = new TextField();
    Button btnSignUp = new Button("Sign up");

    public SignUpWindow(){
        Stage primaryStage = new Stage();
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);

        txtName.setPromptText("Name");
        txtEmail.setPromptText("Email");
        txtUsername.setPromptText("Username");
        txtPassword.setPromptText("Password");
        vbox.getChildren().addAll(txtName, txtEmail, txtUsername, txtPassword, btnSignUp);
        txtName.setMaxWidth(225);
        txtEmail.setMaxWidth(225);
        txtUsername.setMaxWidth(225);
        txtPassword.setMaxWidth(225);

        Scene primaryScene = new Scene(vbox, 400, 500);

        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Bark Sign Up");
        primaryStage.show();

    }
}
