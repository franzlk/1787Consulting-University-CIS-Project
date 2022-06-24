package FinalProject;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.layout.*;

public class Main extends Application{
    public static void main(String[] args){
        launch(args);

    }

    // Scene nodes
    TextField txtUsername = new TextField();
    PasswordField txtPassword = new PasswordField();
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
            for (int i = 0; i<Volunteer.volunteerArrayList.size(); i++){
                if ((txtUsername.getText().equals(Volunteer.volunteerArrayList.get(i).username))
                        && (CryptoHash.cryptoProtect(txtPassword.getText()).equals(Volunteer.volunteerArrayList.get(i).password))
                        && (Volunteer.volunteerArrayList.get(i).adminID==-1)){
                    AdminWindow vw = new AdminWindow(Volunteer.volunteerArrayList.get(i));
                    primaryStage.hide();
                    bool = true;

                }
                else if ((txtUsername.getText().equals(Volunteer.volunteerArrayList.get(i).username))
                        && (CryptoHash.cryptoProtect(txtPassword.getText()).equals(Volunteer.volunteerArrayList.get(i).password))) {
                    VolunteerWindow vw = new VolunteerWindow(Volunteer.volunteerArrayList.get(i));
                    primaryStage.hide();
                    bool = true;

                }
                else if (!bool){
                    if (i < Volunteer.volunteerArrayList.size() - 1){
                        continue;}
                    GenericWindow ew = new GenericWindow("Invalid Login", "The username and password you entered isn’t connected to an account.\n" +
                        "Please try again or contact an administrator.");
                }
            }
        });


        btnSignUp.setOnAction(e -> {
            SignUpWindow suw = new SignUpWindow();
            primaryStage.hide();
        });


    }

    @Override
    public void init(){
        // creating an initial admin user
        Volunteer admin = new Volunteer("Julie Markinson", "10/26/1998", "Administration",
                "genericemail@gmail.com", 20.0, "(999) 999-9999", "Full Volunteer",
                "800 South Main St.", "Harrisonburg", "VA", "22801", "(999) 999-9999",
                "James Madison University Bookstore", 948.5, "admin", "admin");
        admin.setAdminID(-1);
        // creating an initial regular volunteer
        Volunteer volunteer = new Volunteer("John Newby", "10/26/1998", "Animal Health Care",
                "genericemail@gmail.com", 20.0, "(999) 999-9999", "Full Volunteer",
                "800 South Main St.", "Harrisonburg", "VA", "22801", "(999) 999-9999",
                "James Madison University Bookstore", 154.0, "volunteer", "volunteer");
        // creating an initial pending application
        VolunteerApplication va = new VolunteerApplication("Sarah McInterested", "10/26/1998",
                "genericemail@email.com", "(999) 999-9999", "800 South Main St.", "Harrisonburg",
                "VA", "22801", "JMU Bookstore", "Adopter Relations",
                "Julie Markinson", "(999) 999-9999", "volunteerApplication",
                "password");
    }


}
