package FinalProject;

import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;

public class Volunteer {
    static int count = 0;
    int idNumber;
    String name;
    String dateOfBirth;
    String specialization;
    String email;
    Double hoursServed;
    String phone;
    String status;
    String emergencyContactPhone;
    String workHistory;
    Double totalHours;
    int adminID = 0;
    String username;
    String password;

    static ArrayList<Volunteer> volunteerArrayList = new ArrayList<>();

    public Volunteer(String name, String dateOfBirth, String specialization,
                String email, Double hoursServed, String phone, String status,
                String emergencyContactPhone, String workHistory, Double totalHours, String username, String password) {

        this.idNumber = ++count;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.specialization = specialization;
        this.email = email;
        this.hoursServed = hoursServed;
        this.phone = phone;
        this.status = status;
        this.emergencyContactPhone = emergencyContactPhone;
        this.workHistory = workHistory;
        this.totalHours = totalHours;
        this.username = username;
        this.password = CryptoHash.cryptoProtect(password);

        count++;
        addVolunteers(this);
    }

    public static int getCount() {
        return count;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getHoursServed() {
        return hoursServed;
    }

    public void setHoursServed(Double hoursServed) {
        this.hoursServed = hoursServed;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }

    public String getWorkHistory() {
        return workHistory;
    }

    public void setWorkHistory(String workHistory) {
        this.workHistory = workHistory;
    }

    public Double getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(Double totalHours) {
        this.totalHours = totalHours;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public static ArrayList<Volunteer> getVolunteerArrayList() {
        return volunteerArrayList;
    }


    @Override
    public String toString() {
        return "Volunteer{" +
                "name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", hoursServed=" + hoursServed +
                ", status='" + status + '\'' +
                '}';
    }

    public static void addVolunteers(Volunteer... volunteers){
        for (Volunteer v : volunteers){
            Collections.addAll(volunteerArrayList, v);
        }

    }
}
