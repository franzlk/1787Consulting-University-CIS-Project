package FinalProject;

import java.io.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.collections.*;
import java.util.*;
import javafx.scene.layout.*;

import java.sql.*;
import oracle.jdbc.pool.*;

public class Main extends Application{
    public static void main(String[] args){
        launch(args);
    }

    // Scene nodes
    TextField txtUsername = new TextField();
    TextField txtPassword = new TextField();
    Button btnLogin = new Button("Login");
    Label lblSignUp = new Label("If you are a new user, sign up below.");
    Button btnSignUp = new Button("Sign up");
    TextField temp = new TextField();



    @Override
    public void start(Stage primaryStage) {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);

        txtUsername.setPromptText("Username");
        txtPassword.setPromptText("Password");
        vbox.getChildren().addAll(txtUsername, txtPassword, btnLogin, lblSignUp, btnSignUp);
        txtUsername.setMaxWidth(225);
        txtPassword.setMaxWidth(225);
        txtUsername.setFocusTraversable(false);
        txtPassword.setFocusTraversable(false);

        Scene primaryScene = new Scene(vbox, 500, 500);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("BARK Login");
        primaryStage.show();

        btnLogin.setOnAction(e -> {
            VolunteerWindow vw = new VolunteerWindow();
            primaryStage.hide();
        });

        btnSignUp.setOnAction(e -> {
            SignUpWindow suw = new SignUpWindow();
            primaryStage.hide();
        });


    }


}
