package FinalProject;

import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;

public class Event {
    String name;
    static int count = 0;
    int idNumber;
    String date;
    String time;
    String address;
    String city;
    String state;
    String description;

    static ArrayList<Event> eventArrayList = new ArrayList<>();

    public Event(String name, String date, String time, String address, String city, String state, String description) {
        this.idNumber = count +1;
        this.name = name;
        this.date = date;
        this.time = time;
        this.address = address;
        this.city = city;
        this.state = state;
        this.description = description;

        count++;
        addEvents(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdNumber() {
        return idNumber;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ArrayList<Event> getEventArrayList() {
        return eventArrayList;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static void addEvents(Event... events) {
        for (Event e : events) {
            Collections.addAll(eventArrayList, e);
        }
    }
}
