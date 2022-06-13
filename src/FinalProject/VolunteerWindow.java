package FinalProject;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VolunteerWindow {
    // home tab nodes
    Button addPost = new Button("Add Post");

    // event tab nodes

    // time entry tab nodes
    Label lblEventHours = new Label("Log event hours:\t");
    TextField txtEventHours = new TextField();
    Label lblTotalMileage = new Label("Log total mileage:\t");
    TextField txtTotalMileage = new TextField();
    Label lblEventType = new Label("Log event type\t");
    ComboBox cbEventType = new ComboBox();
    Button btnSubmit = new Button("Submit Info");

    // account tab nodes
    Label lblMyAccountInfo = new Label("My Account Info");
    Label lblName = new Label("Name\t");
    TextField txtName = new TextField();
    Label lblEmail = new Label("Email\t");
    TextField txtEmail = new TextField();
    Label lblAddress = new Label("Address\t");
    TextField txtAddress = new TextField();
    Label lblSpecialization = new Label("Specialization\t");
    ComboBox cbSpecialization = new ComboBox();
    Button btnEdit = new Button("Edit");
    Label lblAllVolunteers = new Label("All Volunteers");
    ListView listView = new ListView();

    public VolunteerWindow(){
        Stage primaryStage = new Stage();

        // TabPanes to be used in each Scene
        TabPane TabPane = new TabPane();
        Tab Tab1 = new Tab("Home");
        Tab Tab2 = new Tab("Event");
        Tab Tab3 = new Tab("Time Entry");
        Tab Tab4 = new Tab("Account");

        // GridPanes to hold the nodes (buttons, labels) of each scene
        //--------home tab
        VBox content = new VBox(5);
        ScrollPane scroller = new ScrollPane(content);
        scroller.setFitToWidth(true);
        BorderPane HomePane = new BorderPane(scroller, null, null, addPost, null);
        //--------event tab
        GridPane eventPane = new GridPane();
        //--------account tab
        GridPane timeEntryPane = new GridPane();
        //--------home tab
        GridPane accountPane = new GridPane();

        setPositionAlignment(timeEntryPane, accountPane);

        //Tab1.setContent(HomePane);
        Tab1.setContent(HomePane);
        Tab2.setContent(eventPane);
        Tab3.setContent(timeEntryPane);
        Tab4.setContent(accountPane);
        TabPane.getTabs().addAll(Tab1, Tab2, Tab3, Tab4);

        // nodal content of HomePane

        // nodal content of EventPane

        // nodal content of TimeEntryPane
        timeEntryPane.add(lblEventHours, 0, 0);
        timeEntryPane.add(txtEventHours, 1, 0);
        timeEntryPane.add(lblTotalMileage, 0, 1);
        timeEntryPane.add(txtTotalMileage, 1, 1);
        timeEntryPane.add(lblEventType, 0, 2);
        timeEntryPane.add(cbEventType, 1, 2);
        timeEntryPane.add(btnSubmit, 0, 3);

        // nodal content of AccountPane
        accountPane.add(lblMyAccountInfo, 0, 0);
        lblMyAccountInfo.setStyle("-fx-font: 18 arial");
        accountPane.add(lblName, 0,1);
        accountPane.add(txtName, 1, 1);
        accountPane.add(lblEmail, 0, 2);
        accountPane.add(txtEmail, 1, 2);
        accountPane.add(lblAddress, 0, 3);
        accountPane.add(txtAddress, 1, 3);
        accountPane.add(lblSpecialization, 0, 4);
        accountPane.add(cbSpecialization, 1, 4);
        accountPane.add(btnEdit, 1, 5);
        accountPane.add(lblAllVolunteers, 2, 0);
        lblAllVolunteers.setStyle("-fx-font: 18 arial");
        accountPane.add(listView, 2, 1, 1, 6);

        Scene primaryScene = new Scene(TabPane, 600, 600);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Bark Volunteer View");
        primaryStage.show();


        addPost.setOnAction(e -> {
            AnchorPane anchorPane = new AnchorPane();
            anchorPane.setStyle("-fx-background-color: WHITE");
            Label label = new Label("Pane "+(content.getChildren().size()+1));
            AnchorPane.setLeftAnchor(label, 5.0);
            AnchorPane.setTopAnchor(label, 5.0);
            Button button = new Button("Remove");
            button.setOnAction(evt -> content.getChildren().remove(anchorPane));
            AnchorPane.setRightAnchor(button, 5.0);
            AnchorPane.setTopAnchor(button, 5.0);
            AnchorPane.setBottomAnchor(button, 5.0);
            anchorPane.getChildren().addAll(label, button);
            content.getChildren().add(anchorPane);
        });



    }

    public void setPositionAlignment(GridPane... gp){
        for (GridPane g : gp){
            g.setAlignment(Pos.CENTER);
            g.setHgap(10);
            g.setVgap(4);
        }
    }
}
