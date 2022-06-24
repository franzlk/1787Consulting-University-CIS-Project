package FinalProject;

import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class AdminWindow {
    // home tab nodes

    // event tab nodes

    // pet tab nodes
    ListView petListView = new ListView();
    Button btnViewPet = new Button("View Selected Pet");
    Button btnEditPet = new Button("Edit Selected Pet");
    Button btnDeletePet = new Button("Delete Selected Pet");

    // volunteer tab nodes
    Label lblVolunteer = new Label("Volunteers");
    ListView volunteerListView = new ListView();
    Button btnViewVolInfo = new Button("View Selected\nVolunteer's Info");
    Button btnEditVolInfo = new Button("Edit Selected\nVolunteer's Info");
    Button btnDelVol = new Button("Delete Selected\nVolunteer");
    Label lblPendingApplications = new Label("Pending Applications");
    ListView applicationListView = new ListView();
    Button btnViewApp = new Button("View Selected\nApplication");
    Button btnApproveApp = new Button("Approve Selected\nApplication");
    Button btnDenyApp = new Button("Deny Selected\nApplication");

    // account tab nodes
    Label lblMyAccountInfo = new Label("My Account Info");
    Label lblName = new Label("Name\t");
    TextField txtName = new TextField();
    Label lblDoB = new Label("Date of Birth\t");
    TextField txtDoB = new TextField();
    Label lblEmail = new Label("Email\t");
    TextField txtEmail = new TextField();
    Label lblPhone = new Label("Phone\t");
    TextField txtPhone = new TextField();
    Label lblAddress = new Label("Street Address\t");
    TextField txtAddress = new TextField();
    Label lblCity = new Label("City\t");
    TextField txtCity = new TextField();
    Label lblState = new Label("State\t");
    TextField txtState = new TextField();
    Label lblZip = new Label("Zip Code\t");
    TextField txtZip = new TextField();
    Label lblWorkHistory = new Label("Work History\t");
    TextArea txtWorkHistory = new TextArea();
    Label lblSpecialization = new Label("Specialization\t");
    ComboBox cbSpecialization = new ComboBox();
    Label lblShadow = new Label("Shadow name");
    Label lblShadowName = new Label("Example Name");
    Label lblEmergencyContactPhone = new Label("Emergency Contact Phone Number\t");
    TextField txtEmergencyContactPhone = new TextField();

    Button btnEdit = new Button("Confirm Account Changes");
    Button btnLogout = new Button("Logout");
    
public AdminWindow(Volunteer activeUser){
    Stage primaryStage = new Stage();

    // TabPanes to be used in each Scene
    TabPane TabPane = new TabPane();
    Tab Tab1 = new Tab("Home");
    Tab Tab2 = new Tab("Event");
    Tab Tab3 = new Tab("Pets");
    Tab Tab4 = new Tab("Volunteer Management");
    Tab Tab5 = new Tab("Account");

    // Panes to hold the nodes (buttons, labels) of each tab
    //--------home tab
    GridPane homeGridPane = new GridPane();
    //--------event tab
    GridPane eventGridPane = new GridPane();
    //--------pet tab
    VBox petVBox = new VBox();
    //--------volunteers tab
    GridPane volunteerGridPane = new GridPane();
    //--------account tab
    GridPane accountGridPane = new GridPane();

    setPositionAlignment(homeGridPane, eventGridPane, volunteerGridPane, accountGridPane);

    Tab1.setContent(homeGridPane);
    Tab2.setContent(eventGridPane);
    Tab3.setContent(petVBox);
    Tab4.setContent(volunteerGridPane);
    Tab5.setContent(accountGridPane);
    TabPane.getTabs().addAll(Tab1, Tab2, Tab3, Tab4, Tab5);

    // nodal content of homeGridPane

    // nodal content of eventGridPane

    // nodal content of petVBox
    petVBox.setAlignment(Pos.CENTER);
    petVBox.setSpacing(20);
    petVBox.getChildren().addAll(petListView, btnViewPet, btnEditPet, btnDeletePet);
    petListView.setMaxWidth(700);

    // nodal content of volunteerGridPane
    volunteerGridPane.setVgap(10);
    volunteerGridPane.setHgap(10);
    ObservableList<Volunteer> volunteerObservableList
            = FXCollections.observableArrayList(Volunteer.volunteerArrayList);
    ObservableList<VolunteerApplication> applicationObservableList
            = FXCollections.observableArrayList(VolunteerApplication.volunteerApplicationArrayList);
    clearUpdateTable(volunteerListView, Volunteer.volunteerArrayList, volunteerObservableList);
    clearUpdateTable(applicationListView, VolunteerApplication.volunteerApplicationArrayList, applicationObservableList);

    setButtonFormatting(btnViewVolInfo, btnEditVolInfo, btnDelVol, btnViewApp, btnApproveApp, btnDenyApp);

    volunteerGridPane.add(lblVolunteer, 0, 0, 3, 1);
    lblVolunteer.setStyle("-fx-font: 16 arial");
    volunteerGridPane.add(volunteerListView, 0, 1, 3, 1);
    volunteerListView.setPrefWidth(350);
    volunteerGridPane.add(btnViewVolInfo, 0, 2);
    volunteerGridPane.add(btnEditVolInfo, 1, 2);
    volunteerGridPane.add(btnDelVol, 2, 2);

    volunteerGridPane.add(lblPendingApplications, 3, 0, 3, 1);
    lblPendingApplications.setStyle("-fx-font: 16 arial");
    volunteerGridPane.add(applicationListView, 3, 1, 3, 1);
    applicationListView.setPrefWidth(350);
    volunteerGridPane.add(btnViewApp, 3, 2);
    volunteerGridPane.add(btnApproveApp, 4, 2);
    volunteerGridPane.add(btnDenyApp, 5, 2);

    // nodal content of accountGridPane
    // formatting
    setMaxWidth(txtWorkHistory, txtName, txtDoB, txtEmail, txtPhone,
            txtEmergencyContactPhone, txtAddress, txtCity, txtState, txtZip);
    txtWorkHistory.setMaxHeight(150);
    txtWorkHistory.setWrapText(true);

    accountGridPane.add(lblMyAccountInfo, 0, 0, 2, 1);
    lblMyAccountInfo.setStyle("-fx-font: 18 arial");
    accountGridPane.add(lblName, 0, 1);
    accountGridPane.add(txtName, 0, 2);
    accountGridPane.add(lblDoB, 0, 3);
    accountGridPane.add(txtDoB, 0, 4);
    accountGridPane.add(lblEmail, 0, 5);
    accountGridPane.add(txtEmail, 0, 6);
    accountGridPane.add(lblPhone, 0, 7);
    accountGridPane.add(txtPhone, 0, 8);
    accountGridPane.add(lblAddress, 0, 9);
    accountGridPane.add(txtAddress, 0, 10);
    accountGridPane.add(lblCity, 0, 11);
    accountGridPane.add(txtCity, 0, 12);
    accountGridPane.add(lblState, 0, 13);
    accountGridPane.add(txtState, 0, 14);
    accountGridPane.add(lblZip, 0, 15);
    accountGridPane.add(txtZip, 0, 16);
    accountGridPane.add(lblWorkHistory, 1, 1, 3, 1);
    accountGridPane.add(txtWorkHistory, 1, 2, 3, 5);
    accountGridPane.add(lblSpecialization, 1, 7, 3, 1);
    accountGridPane.add(cbSpecialization, 1, 8, 3, 1);
    accountGridPane.add(lblShadow, 1, 9, 3, 1);
    accountGridPane.add(lblShadowName, 1, 10, 3, 1);
    accountGridPane.add(lblEmergencyContactPhone, 1, 11, 3, 1);
    accountGridPane.add(txtEmergencyContactPhone, 1, 12, 3, 1);
    accountGridPane.add(btnEdit, 1, 16);
    accountGridPane.add(btnLogout, 3, 16);

    txtName.setText(activeUser.getName());
    txtDoB.setText(activeUser.getDateOfBirth());
    txtEmail.setText(activeUser.getEmail());
    txtPhone.setText(activeUser.getPhone());
    txtAddress.setText(activeUser.getAddress());
    txtCity.setText(activeUser.getCity());
    txtState.setText(activeUser.getState());
    txtZip.setText(activeUser.getZip());
    txtWorkHistory.setText(activeUser.getWorkHistory());
    //cbSpecialization.setText
    //lblShadowName.setText();
    txtEmergencyContactPhone.setText(activeUser.getEmergencyContactPhone());
    
    Scene primaryScene = new Scene(TabPane, 775, 600);
    primaryStage.setScene(primaryScene);
    primaryStage.setTitle("BARK Admin View");
    primaryStage.show();

    // home tab lambda expressions
    // event tab lambda expression
    // volunteer management tab lambda expressions
    // account tab lambda expressions
    btnLogout.setOnAction(e -> {
        Main m = new Main();
        m.start(new Stage());
        primaryStage.hide();
    });
}

    public void setPositionAlignment(GridPane... gp) {
        for (GridPane g : gp) {
            g.setAlignment(Pos.CENTER);
            g.setHgap(10);
            g.setVgap(4);
        }
    }

    public void setButtonFormatting(Button... buttons){
        for (Button b : buttons){
            b.setPrefHeight(60);
            b.setTextAlignment(TextAlignment.CENTER);
            b.setPrefWidth(110);
        }

    }

    public void setMaxWidth(TextArea ta, TextField... tf) {
        for (TextField t : tf)
            t.setPrefWidth(250);
        ta.setPrefWidth(250);
    }

    public void clearUpdateTable(ListView lv, ArrayList al, ObservableList obsList) {
        lv.getItems().clear();
        for (int i = 0; i<al.size(); i++)
            lv.getItems().add(obsList.get(i));
    }
}
