package FinalProject;

import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class TimeHistory {

    int idNumber;
    int volunteerID;
    String date;
    String timeIn;
    String timeOut;

    static ArrayList<TimeHistory> timeHistoryArrayList = new ArrayList<>();
    static int count = 0;

    // no pk constructor
    public TimeHistory(int volunteerID, String date, String timeIn, String timeOut) {

        this.idNumber = ++count;
        this.volunteerID = volunteerID;
        this.date = date;
        this.timeIn = timeIn;
        this.timeOut = timeOut;

        timeHistoryArrayList.add(this);
    }

    // present pk constructor
    public TimeHistory(int idNumber, int volunteerID, String date, String timeIn, String timeOut) {
        this.idNumber = idNumber;
        this.volunteerID = volunteerID;
        this.date = date;
        this.timeIn = timeIn;
        this.timeOut = timeOut;


    }

    @Override
    public String toString() {
        return  "Volunteer =" + Volunteer.getByID(volunteerID).name +
                ", date=" + date +
                ", timeIn=" + timeIn +
                ", timeOut=" + timeOut;
    }

    public static void addTimeHistory(TimeHistory... timeHistories){
        for (TimeHistory t : timeHistories){
            Collections.addAll(timeHistoryArrayList, t);
        }
}

}
