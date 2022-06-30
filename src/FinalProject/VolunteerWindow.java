package FinalProject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VolunteerWindow {
    // home tab nodes
    Label lblHome = new Label("Share a post with other volunteers!\nYou cannot edit or delete other volunteer's posts.");
    Button btnAddPost = new Button("Add Post");
    Button btnRefreshFeed = new Button("Refresh");
    VBox homeVBox = new VBox(5);

    // event tab nodes
    Label lblEvent = new Label("Create an event for volunteers to attend!\nYou cannot edit or delete other volunteer's events.");
    Button btnAddEvent = new Button("Add Event");
    Button btnRefreshEventFeed = new Button("Refresh");
    VBox eventVBox = new VBox(5);

    // pet tab nodes
    ListView petListView = new ListView();//
    Button btnViewPet = new Button("View Selected Pet");
    Button btnAddPet = new Button("Add New Pet");
    Button btnEditPet = new Button("Edit Selected Pet");
    Button btnDeletePet = new Button("Delete Selected Pet");

    // clock in/out nodes
    Button btnClockIn = new Button("Clock-In");
    Label lblClockInTime = new Label();
    Button btnClockOut = new Button("Clock-Out");
    Label lblClockOutTime = new Label();
    Label lblSpacer = new Label();
    Button btnViewTimeHistory = new Button("View Clock-In History");

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
    Button btnViewVolunteers = new Button("View Volunteers");
    Button btnLogout = new Button("Logout");
    Volunteer currentUser;

    public VolunteerWindow(Volunteer activeUser) {
        currentUser = activeUser;
        Stage primaryStage = new Stage();

        // TabPanes to be used in each Scene
        TabPane TabPane = new TabPane();
        Tab Tab1 = new Tab("Home");
        Tab Tab2 = new Tab("Event");
        Tab Tab3 = new Tab("Pets");
        Tab Tab4 = new Tab("Clock-In/Clock-Out");
        Tab Tab5 = new Tab("Account");

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
        //--------clock in/out tab
        GridPane clockIOPane = new GridPane();
        //--------account tab
        GridPane accountPane = new GridPane();

        setPositionAlignment(clockIOPane, accountPane);
        
        Tab1.setContent(homeBorderPane);
        Tab2.setContent(eventBorderPane);
        Tab3.setContent(petVBox);
        Tab4.setContent(clockIOPane);
        Tab5.setContent(accountPane);
        TabPane.getTabs().addAll(Tab1, Tab2, Tab3, Tab4, Tab5);

        // nodal content of HomePane
        homeGridPane.setHgap(10);
        homeGridPane.setVgap(10);
        homeGridPane.add(lblHome, 0, 0, 2, 1);
        homeGridPane.add(btnAddPost, 0, 1);
        homeGridPane.add(btnRefreshFeed, 1, 1);

        // nodal content of EventPane
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

        // nodal content of AccountPane
        // formatting
        setMaxWidth(txtWorkHistory, txtName, txtDoB, txtEmail, txtPhone,
                txtEmergencyContactPhone, txtAddress, txtCity, txtState, txtZip);
        txtWorkHistory.setMaxHeight(150);
        txtWorkHistory.setWrapText(true);

        accountPane.add(lblMyAccountInfo, 0, 0, 2, 1);
        lblMyAccountInfo.setStyle("-fx-font: 18 arial");
        accountPane.add(lblName, 0, 1);
        accountPane.add(txtName, 0, 2);
        accountPane.add(lblDoB, 0, 3);
        accountPane.add(txtDoB, 0, 4);
        accountPane.add(lblEmail, 0, 5);
        accountPane.add(txtEmail, 0, 6);
        accountPane.add(lblPhone, 0, 7);
        accountPane.add(txtPhone, 0, 8);
        accountPane.add(lblAddress, 0, 9);
        accountPane.add(txtAddress, 0, 10);
        accountPane.add(lblCity, 0, 11);
        accountPane.add(txtCity, 0, 12);
        accountPane.add(lblState, 0, 13);
        accountPane.add(txtState, 0, 14);
        accountPane.add(lblZip, 0, 15);
        accountPane.add(txtZip, 0, 16);
        accountPane.add(lblWorkHistory, 1, 1, 3, 1);
        accountPane.add(txtWorkHistory, 1, 2, 3, 5);
        accountPane.add(lblSpecialization, 1, 7, 3, 1);
        accountPane.add(cbSpecialization, 1, 8, 3, 1);
        accountPane.add(lblShadow, 1, 9, 3, 1);
        accountPane.add(cbShadow, 1, 10, 3, 1);
        accountPane.add(lblEmergencyContactPhone, 1, 11, 3, 1);
        accountPane.add(txtEmergencyContactPhone, 1, 12, 3, 1);
        accountPane.add(btnChangePassword, 1, 14);
        accountPane.add(btnEdit, 1, 16);
        accountPane.add(btnViewVolunteers, 2, 16);
        accountPane.add(btnLogout, 3, 16);

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
        primaryStage.setTitle("BARK Volunteer View");
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

        // event tab lambda expressions
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

                    SqlExchange.sendDBCommand(sqlTimeHistoryEditQuery);
                }

                else{
                    continue;
                }
            }


        });

        btnViewTimeHistory.setOnAction(e -> {


            ViewTimeHistoryWindow vthw = new ViewTimeHistoryWindow();
        });

        // account tab lambda expressions
        btnChangePassword.setOnAction(e -> {
            ChangePasswordWindow cpw = new ChangePasswordWindow(currentUser.idNumber);
        });

        btnViewVolunteers.setOnAction(e -> {
            ViewVolunteersWindow vv = new ViewVolunteersWindow();
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
        // only posts made by the current user are removable (however, in adminwindow all posts are removable for moderation purposes)
        if (SocialPost.getByID(ID).userID == currentUser.idNumber){
            Button btnRemove = new Button("Remove");
            btnRemove.setOnAction(event -> {
                DeleteSocialPostWindow dspw = new DeleteSocialPostWindow(ID, this, homeVBox, postAnchorPane);
            });
            AnchorPane.setRightAnchor(btnRemove, 5.0);
            AnchorPane.setTopAnchor(btnRemove, 20.0);
            AnchorPane.setBottomAnchor(btnRemove, 20.0);
            postAnchorPane.getChildren().addAll(lblPostMetaData, lblPostContent, btnRemove);}
        else{
            postAnchorPane.getChildren().addAll(lblPostMetaData, lblPostContent);
        }
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

        Button btnViewEvent = new Button ("View");

        AnchorPane.setLeftAnchor(lblEventDescription, 200.0);
        AnchorPane.setTopAnchor(lblEventDescription, 5.0);

        AnchorPane.setRightAnchor(btnViewEvent, 100.0);
        AnchorPane.setTopAnchor(btnViewEvent, 20.0);
        AnchorPane.setBottomAnchor(btnViewEvent, 20.0);
        btnViewEvent.setOnAction(evt -> {
            ViewEventWindow vew = new ViewEventWindow(ID);
        });

        // only events made by the current user are removable (however, in adminwindow all events are removable for moderation purposes)
        if (Event.getByID(ID).eventCreatorID == currentUser.idNumber){
        Button btnDeleteEvent = new Button ("Delete"); // event still needs to be deleted from arraylist
        Button btnEditEvent = new Button ("Edit");

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
        eventAnchorPane.getChildren().addAll(lblEventMetaData, lblEventDescription, btnDeleteEvent, btnEditEvent, btnViewEvent);}
        else{
            eventAnchorPane.getChildren().addAll(lblEventMetaData, lblEventDescription, btnViewEvent);
        }
        eventVBox.getChildren().add(eventAnchorPane);

    }
    public void clearUpdateTable(ListView lv, ArrayList al, ObservableList obsList) {
        lv.getItems().clear();
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

    public void setPositionAlignment(GridPane... gp) {
        for (GridPane g : gp) {
            g.setAlignment(Pos.CENTER);
            g.setHgap(10);
            g.setVgap(4);
        }
    }

    public void setMaxWidth(TextArea ta, TextField... tf) {
        for (TextField t : tf)
            t.setPrefWidth(250);
        ta.setPrefWidth(250);
    }


}
