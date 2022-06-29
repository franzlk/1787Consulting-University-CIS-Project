package FinalProject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SocialPost {

    static int count = 0;
    int idNumber;
    String date;
    String time;
    int userID;
    String text;


    static ArrayList<SocialPost> socialPostArrayList = new ArrayList<>();

    // null pk constructor
    public SocialPost(String date, String time, int userID, String text) {

        this.idNumber = ++count;
        this.date = date;
        this.time = time;
        this.userID = userID;
        this.text = text;

        addPost(this);
    }

    public SocialPost(int idNumber, int userID, String text, String date, String time) {

        this.idNumber = idNumber;
        this.date = date;
        this.time = time;
        this.userID = userID;
        this.text = text;
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


    public int getUserID() {
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
