package FinalProject;

import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;

public class SocialPost {

    static int count = 0;
    int idNumber;
    String date;
    String time;
    String userID;
    String text;

    static ArrayList<SocialPost> socialPostArrayList = new ArrayList<>();

    public SocialPost(int idNumber, String date, String time, String userID, String text) {
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

    public static ArrayList<SocialPost> getHomePostArrayList() {
        return socialPostArrayList;
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

    public static void addPost(SocialPost... posts) {
        for (SocialPost sp : posts) {
            Collections.addAll(socialPostArrayList, sp);
        }
    }

    public static SocialPost getByID(int ID){
        SocialPost sp = socialPostArrayList.get(0);
        for (SocialPost s : socialPostArrayList){
            if (ID==s.idNumber){
                sp = s;}
        }
        return sp;
    }
}
