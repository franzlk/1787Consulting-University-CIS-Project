//1787 Consulting
//Course: CIS 484
//Final Project
//I promise that this work was done in accordance with the JMU honor code and
//I did not receive nor give unauthorized assistance in writing this program.
package FinalProject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    Label lblHome = new Label("Share a post with other volunteers!");
    Button btnAddPost = new Button("Add Post");
    Button btnRefreshFeed = new Button("Refresh");
    VBox homeVBox = new VBox(5);

    // event tab nodes
    Label lblEvent = new Label("Create an event for volunteers to attend!");
    Button btnAddEvent = new Button("Add Event");
    Button btnRefreshEventFeed = new Button("Refresh");
    VBox eventVBox = new VBox(5);

    // pet tab nodes
    ListView petListView = new ListView();
    Button btnAddPet = new Button("Add New Pet");
    Button btnViewPet = new Button("View Selected Pet");
    Button btnEditPet = new Button("Edit Selected Pet");
    Button btnDeletePet = new Button("Delete Selected Pet");


    // Clock-In/Clock-Out tab nodes
    Button btnClockIn = new Button("Clock-In");
    Label lblClockInTime = new Label();
    Button btnClockOut = new Button("Clock-Out");
    Label lblClockOutTime = new Label();
    Label lblSpacer = new Label();
    Button btnViewTimeHistory = new Button("View Clock-In History");

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
    ComboBox cbSpecialization = new ComboBox(FXCollections
            .observableArrayList(Specialization.getSpecializationArrayList()));
    Label lblShadow = new Label("Shadow name");
    ComboBox cbShadow = new ComboBox(FXCollections
            .observableArrayList(Volunteer.volunteerNameArrayList));
    Label lblEmergencyContactPhone = new Label("Emergency Contact Phone Number\t");
    TextField txtEmergencyContactPhone = new TextField();
    Button btnChangePassword = new Button("Change Password");

    Button btnEdit = new Button("Confirm Account Changes");
    Button btnLogout = new Button("Logout");
    Volunteer currentUser;
    
public AdminWindow(Volunteer activeUser) {
    currentUser = activeUser;
    Stage primaryStage = new Stage();

    // TabPanes to be used in each Scene
    TabPane TabPane = new TabPane();
    Tab Tab1 = new Tab("Home");
    Tab Tab2 = new Tab("Event");
    Tab Tab3 = new Tab("Pets");
    Tab Tab4 = new Tab("Clock-In/Clock-Out");
    Tab Tab5 = new Tab("Volunteer Management");
    Tab Tab6 = new Tab("Account");

    // Panes to hold the nodes (buttons, labels) of each tab
    //--------home tab
    GridPane homeGridPane = new GridPane();
    ScrollPane homeScroller = new ScrollPane(homeVBox);
    homeScroller.setFitToWidth(true);
    BorderPane homeBorderPane = new BorderPane(homeScroller, homeGridPane, null, null, null);
    homeBorderPane.setMargin(homeGridPane, new Insets(12, 12, 12, 12));
    //--------event tab
    GridPane eventGridPane = new GridPane();
    ScrollPane eventScroller = new ScrollPane(eventVBox);
    eventScroller.setFitToWidth(true);
    BorderPane eventBorderPane = new BorderPane(eventScroller, eventGridPane, null, null, null);
    eventBorderPane.setMargin(eventGridPane, new Insets(12, 12, 12, 12));
    //--------pet tab
    VBox petVBox = new VBox();
    //--------clock i/o tab
    GridPane clockIOPane = new GridPane();
    //--------volunteers tab
    GridPane volunteerGridPane = new GridPane();
    //--------account tab
    GridPane accountGridPane = new GridPane();

    setPositionAlignment(volunteerGridPane, clockIOPane, accountGridPane);

    Tab1.setContent(homeBorderPane);
    Tab2.setContent(eventBorderPane);
    Tab3.setContent(petVBox);
    Tab4.setContent(clockIOPane);
    Tab5.setContent(volunteerGridPane);
    Tab6.setContent(accountGridPane);
    TabPane.getTabs().addAll(Tab1, Tab2, Tab3, Tab4, Tab5, Tab6);

    // nodal content of homeGridPane
    homeGridPane.setHgap(10);
    homeGridPane.setVgap(10);
    homeGridPane.add(lblHome, 0, 0, 2, 1);
    homeGridPane.add(btnAddPost, 0, 1);
    homeGridPane.add(btnRefreshFeed, 1, 1);

    // nodal content of eventGridPane
    eventGridPane.setHgap(10);
    eventGridPane.setVgap(10);
    eventGridPane.add(lblEvent, 0, 0, 2, 1);
    eventGridPane.add(btnAddEvent, 0, 1);
    eventGridPane.add(btnRefreshEventFeed, 1, 1);

    // nodal content of petVBox
    ObservableList<Pet> petObservableList
            = FXCollections.observableArrayList(Pet.petArrayList);
    clearUpdateTable(petListView, Pet.petArrayList, petObservableList );
    petVBox.setAlignment(Pos.CENTER);
    petVBox.setSpacing(10);
    petVBox.getChildren().addAll(petListView, btnAddPet, btnViewPet, btnEditPet, btnDeletePet);
    petListView.setMaxWidth(700);

    // nodal content of clockIOPane
    btnClockIn.setPrefWidth(250);
    btnClockIn.setPrefHeight(60);
    btnClockIn.setStyle("-fx-font: 16 arial");
    btnClockOut.setPrefWidth(250);
    btnClockOut.setPrefHeight(60);
    btnClockOut.setStyle("-fx-font: 16 arial");
    btnViewTimeHistory.setPrefWidth(250);
    lblSpacer.setMinHeight(200);
    clockIOPane.add(btnClockIn, 0, 0);
    clockIOPane.add(lblClockInTime, 0, 1);
    clockIOPane.add(btnClockOut, 0, 2);
    clockIOPane.add(lblClockOutTime, 0, 3);
    clockIOPane.add(lblSpacer, 0, 4);
    clockIOPane.add(btnViewTimeHistory, 0, 5);
    for (TimeHistory element : TimeHistory.timeHistoryArrayList){ //checking if user is already clocked in
        if ((element.volunteerID==currentUser.idNumber)&&(element.timeOut.equals("0"))){
            lblClockInTime.setText("You are already Clocked-In.");
        }
        else{
            continue;
        }}

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
    accountGridPane.add(cbShadow, 1, 10, 3, 1);
    accountGridPane.add(lblEmergencyContactPhone, 1, 11, 3, 1);
    accountGridPane.add(txtEmergencyContactPhone, 1, 12, 3, 1);
    accountGridPane.add(btnChangePassword, 1, 14);
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
    cbSpecialization.getSelectionModel().select(activeUser.specialization);
    cbShadow.getSelectionModel().selectFirst();
    txtEmergencyContactPhone.setText(activeUser.getEmergencyContactPhone());

    Scene primaryScene = new Scene(TabPane, 775, 600);
    primaryStage.setScene(primaryScene);
    primaryStage.setTitle("BARK Admin View");
    primaryStage.show();



    // home tab lambda expressions
    btnAddPost.setOnAction(e -> {
        AddSocialPostWindow aspw = new AddSocialPostWindow(this);
    });

    btnRefreshFeed.setOnAction(e -> {
        homeVBox.getChildren().clear();

        for (SocialPost sp : SocialPost.socialPostArrayList){
            addSocialPost(sp.idNumber);
        }
    });

    // event tab lambda expression
    btnAddEvent.setOnAction(e -> {
        AddEventWindow aew = new AddEventWindow(this, currentUser.idNumber);
    });

    btnRefreshEventFeed.setOnAction(e -> {
        eventVBox.getChildren().clear();

        for (Event element : Event.eventArrayList){
            addEvent(element.idNumber);

        }
    });

    // pet tab lambda expressions
    btnAddPet.setOnAction(e -> {
        AddPetWindow anpw = new AddPetWindow(this, currentUser.idNumber);
    });

    btnViewPet.setOnAction(e -> {
        ViewPetWindow vpw = new ViewPetWindow((Pet)petListView.getSelectionModel().getSelectedItem());
    });

    btnEditPet.setOnAction(e -> {
        EditPetWindow epw = new EditPetWindow(this, (Pet)petListView.getSelectionModel().getSelectedItem());
    });

    btnDeletePet.setOnAction(e -> {
        DeletePetWindow dpw = new DeletePetWindow((Pet)petListView.getSelectionModel().getSelectedItem(), this);
    });

    // clock in/out tab lambda expressions
    btnClockIn.setOnAction(e -> {
        TimeHistory T = new TimeHistory(currentUser.idNumber, getCurrentDate(), getCurrentTime(), "0");
        lblClockInTime.setText("Clock-In Time:\t\t" + getCurrentDate() + " " + getCurrentTime());

        String sqlTimeHistoryInsertQuery = "INSERT INTO TIMEHISTORY (ClockInID, VolunteerID, clockDate, TimeIn, TimeOut) " +
                "values (" + T.idNumber + ", " + currentUser.idNumber + ", '" + T.date +
                "', '" + T.timeIn + "', '" + T.timeOut + "')";

        SqlExchange.sendDBCommand(sqlTimeHistoryInsertQuery);
    });

    btnClockOut.setOnAction(e -> {
        for (TimeHistory element : TimeHistory.timeHistoryArrayList){
            if ((element.volunteerID==currentUser.idNumber)&&(element.timeOut.equals("0"))){
                lblClockOutTime.setText("Clock-Out Time:\t" + getCurrentDate() + " " + getCurrentTime());
                element.timeOut = getCurrentTime();
                element.date = getCurrentDate();

                // sql edit query for timeclock
                String sqlTimeHistoryEditQuery = "UPDATE TIMEHISTORY SET " +
                        "clockDate = '" + element.date + "', " +
                        "TimeIn = '" + element.timeIn + "', " +
                        "TimeOut = '" + element.timeOut + "' " +
                        "WHERE ClockInID = " + element.idNumber;

                SqlExchange.sendDBCommand(sqlTimeHistoryEditQuery);}
            else{
                continue;
            }
        }


    });

    btnViewTimeHistory.setOnAction(e -> {


        ViewTimeHistoryWindow vthw = new ViewTimeHistoryWindow();
    });

    // volunteer management tab lambda expressions
    btnViewVolInfo.setOnAction(e -> {
        ViewSelectedVolunteerWindow vsvw = new ViewSelectedVolunteerWindow((Volunteer) volunteerListView.getSelectionModel().getSelectedItem());
    });

    btnEditVolInfo.setOnAction(e -> {
        EditSelectedVolunteerWindow esvw = new EditSelectedVolunteerWindow((Volunteer) volunteerListView.getSelectionModel().getSelectedItem(), this);
    });

    btnDelVol.setOnAction(e -> {
        DeleteSelectedVolunteerWindow dsvw = new DeleteSelectedVolunteerWindow((Volunteer) volunteerListView.getSelectionModel().getSelectedItem(), this);
    });

    btnViewApp.setOnAction(e -> {
        ViewSelectedApplicationWindow vsaw = new ViewSelectedApplicationWindow((VolunteerApplication) applicationListView.getSelectionModel().getSelectedItem());
    });

    btnApproveApp.setOnAction(event -> {
        ApproveSelectedApplicationWindow asaw = new ApproveSelectedApplicationWindow((VolunteerApplication) applicationListView.getSelectionModel().getSelectedItem(), this);
    });

    btnDenyApp.setOnAction(event -> {
        DenySelectedApplicationWindow dsaw = new DenySelectedApplicationWindow((VolunteerApplication) applicationListView.getSelectionModel().getSelectedItem(), this);
    });

    // account tab lambda expressions
    btnChangePassword.setOnAction(e -> {
        ChangePasswordWindow cpw = new ChangePasswordWindow(currentUser.idNumber);
    });

    btnEdit.setOnAction(e -> {
        ConfirmAccountChangesWindow cecw = new ConfirmAccountChangesWindow(currentUser.idNumber, this);
    });

    btnLogout.setOnAction(e -> {
        Main m = new Main();
        m.start(new Stage());
        primaryStage.hide();
    });
}

    public void addSocialPost(int ID){
        AnchorPane postAnchorPane = new AnchorPane();
        postAnchorPane.setStyle("-fx-background-color: WHITE");
        Label lblPostMetaData = new Label("" + SocialPost.getByID(ID).date+ "\n" + SocialPost.getByID(ID).time + "\n" +
                Volunteer.getByID(SocialPost.getByID(ID).userID).name);
        AnchorPane.setLeftAnchor(lblPostMetaData, 5.0);
        AnchorPane.setTopAnchor(lblPostMetaData, 5.0);
        Label lblPostContent = new Label((SocialPost.getByID(ID).text));
        lblPostContent.setMaxWidth(450);
        lblPostContent.setWrapText(true);
        AnchorPane.setLeftAnchor(lblPostContent, 175.0);
        AnchorPane.setTopAnchor(lblPostContent, 5.0);
        Button btnRemove = new Button("Remove");
        btnRemove.setOnAction(event -> {
            DeleteSocialPostWindow dspw = new DeleteSocialPostWindow(ID, this, homeVBox, postAnchorPane);
        });
        AnchorPane.setRightAnchor(btnRemove, 5.0);
        AnchorPane.setTopAnchor(btnRemove, 20.0);
        AnchorPane.setBottomAnchor(btnRemove, 20.0);
        postAnchorPane.getChildren().addAll(lblPostMetaData, lblPostContent, btnRemove);
        homeVBox.getChildren().add(postAnchorPane);

    }

    public void addEvent(int ID){
        AnchorPane eventAnchorPane = new AnchorPane();
        eventAnchorPane.setStyle("-fx-background-color: WHITE");
        Label lblEventMetaData = new Label("Event: " + (Event.getByID(ID).name) + "\n" + (Event.getByID(ID).date) + "\n" + (Event.getByID(ID).time) + "\n" +
                "Created by: " + Volunteer.getByID(Event.getByID(ID).eventCreatorID).name);
        Label lblEventDescription = new Label(Event.getByID(ID).description);
        lblEventDescription.setMaxWidth(300);
        lblEventDescription.setWrapText(true);
        AnchorPane.setLeftAnchor(lblEventMetaData, 5.0);
        AnchorPane.setTopAnchor(lblEventMetaData, 5.0);

        Button btnSignUp = new Button("Sign-Up");
        Button btnDeleteEvent = new Button ("Delete");
        Button btnEditEvent = new Button ("Edit");
        Button btnViewEvent = new Button ("View");

        AnchorPane.setLeftAnchor(lblEventDescription, 200.0);
        AnchorPane.setTopAnchor(lblEventDescription, 5.0);

        AnchorPane.setRightAnchor(btnSignUp, 145.0);
        AnchorPane.setTopAnchor(btnSignUp, 20.0);
        AnchorPane.setBottomAnchor(btnSignUp, 20.0);
        btnSignUp.setOnAction(evt -> {
            EventSignUpWindow esuw = new EventSignUpWindow(ID, currentUser);
        });

        AnchorPane.setRightAnchor(btnViewEvent, 100.0);
        AnchorPane.setTopAnchor(btnViewEvent, 20.0);
        AnchorPane.setBottomAnchor(btnViewEvent, 20.0);
        btnViewEvent.setOnAction(evt -> {
            ViewEventWindow vew = new ViewEventWindow(ID);
        });
        AnchorPane.setRightAnchor(btnEditEvent, 60.0);
        AnchorPane.setTopAnchor(btnEditEvent, 20.0);
        AnchorPane.setBottomAnchor(btnEditEvent, 20.0);
        btnEditEvent.setOnAction(evt -> {
            EditEventWindow eew = new EditEventWindow(ID, this);
        });
        AnchorPane.setRightAnchor(btnDeleteEvent, 5.0);
        AnchorPane.setTopAnchor(btnDeleteEvent, 20.0);
        AnchorPane.setBottomAnchor(btnDeleteEvent, 20.0);
        btnDeleteEvent.setOnAction(evt -> {
            //show delete window
            DeleteEventWindow gcw = new DeleteEventWindow(ID, this);

        });
        eventAnchorPane.getChildren().addAll(lblEventMetaData, lblEventDescription, btnSignUp, btnDeleteEvent, btnEditEvent, btnViewEvent);
        eventVBox.getChildren().add(eventAnchorPane);

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
        obsList.clear();
        obsList.addAll(al);
        for (int i = 0; i<al.size(); i++)
            lv.getItems().add(obsList.get(i));
    }

    public String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        return (dtf.format(now));
    }

    public String getCurrentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return (dtf.format(now));
    }
}