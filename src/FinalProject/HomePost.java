package FinalProject;

import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;

public class HomePost {

    static int count = 0;
    int idNumber;
    String date;
    String time;
    String userID;
    String text;

    static ArrayList<HomePost> homePostArrayList = new ArrayList<>();

    public HomePost(int idNumber, String date, String time, String userID, String text) {
        this.idNumber = ++count;
        this.date = date;
        this.time = time;
        this.userID = userID;
        this.text = text;

        addPost(this);
    }

    public static int getCount() {
        return count;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }


    public String getUserID() {
        return userID;
    }

    public String getText() {
        return text;
    }

    public static ArrayList<HomePost> getHomePostArrayList() {
        return homePostArrayList;
    }

    @Override
    public String toString() {
        return "HomePost{" +
                "idNumber=" + idNumber +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", userID='" + userID + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public static void addPost(HomePost... posts) {
        for (HomePost p : posts) {
            Collections.addAll(homePostArrayList, p);
        }
    }
}
