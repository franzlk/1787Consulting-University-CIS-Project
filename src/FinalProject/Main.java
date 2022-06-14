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
    Label lblSignUp = new Label("  If you are a new user, sign up below by\nfilling out an application to be a volunteer.");
    Button btnSignUp = new Button("New Application");

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
            boolean bool = false;
            for (Volunteer v : Volunteer.volunteerArrayList)
                if ((txtUsername.getText().equals(v.username))
                        && (CryptoHash.cryptoProtect(txtPassword.getText()).equals(v.password))
                        && (v.adminID==-1)){
                    AdminWindow vw = new AdminWindow(v);
                    primaryStage.hide();
                    bool = true;
                }
                else if ((txtUsername.getText().equals(v.username))
                        && (CryptoHash.cryptoProtect(txtPassword.getText()).equals(v.password))) {
                    VolunteerWindow vw = new VolunteerWindow(v);
                    primaryStage.hide();
                    bool = true;
                }
            if (bool == false)
                System.out.println("Invalid User");

        });

        btnSignUp.setOnAction(e -> {
            SignUpWindow suw = new SignUpWindow();
            primaryStage.hide();
        });


    }

    @Override
    public void init(){
        // creating an initial admin user
        String x = "admin";
        Volunteer admin = new Volunteer(x, x, x, x, 0.0, x, x, x, x, 0.0, x, x);
        admin.setAdminID(-1);
        // creating an initial regular volunteer
        String y = "volunteer";
        Volunteer volunteer = new Volunteer(y, y, y, y, 0.0, y, y, y, y, 0.0, y, y);

    }


}
