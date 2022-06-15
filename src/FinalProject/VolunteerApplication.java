package FinalProject;

import java.util.ArrayList;
import java.util.Collections;

public class VolunteerApplication {
    static int count = 0;
    int idNumber;
    String name;
    String DoB;
    String email;
    String phone;
    String address;
    String city;
    String State;
    String zip;
    String workHistory;
    String specializationPreference;
    String ShadowPreference;
    String EmergencyContactPhone;

    String username;

    static ArrayList<VolunteerApplication> volunteerApplicationArrayList = new ArrayList<>();

    public VolunteerApplication(int idNumber, String name, String doB, String email,
                                String phone, String address, String city, String state,
                                String zip, String workHistory, String specializationPreference,
                                String shadowPreference, String emergencyContactPhone, String username) {
        this.idNumber = ++count;
        this.name = name;
        DoB = doB;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        State = state;
        this.zip = zip;
        this.workHistory = workHistory;
        this.specializationPreference = specializationPreference;
        ShadowPreference = shadowPreference;
        EmergencyContactPhone = emergencyContactPhone;
        this.username = username;

        addVolunteerApplication(this);
    }

    public int getIdNumber() {
        return idNumber;
    }

    @Override
    public String toString() {
        return "VolunteerApplication{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", specializationPreference='" + specializationPreference + '\'' +
                '}';
    }

    public static void addVolunteerApplication(VolunteerApplication... apps) {
        for (VolunteerApplication va : apps) {
            Collections.addAll(volunteerApplicationArrayList, va);
        }
    }
}
