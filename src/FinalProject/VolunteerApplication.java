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
    String password;
    String username;

    static ArrayList<VolunteerApplication> volunteerApplicationArrayList = new ArrayList<>();

    public VolunteerApplication(String name, String DoB, String email,
                                String phone, String address, String city, String state,
                                String zip, String workHistory, String specializationPreference,
                                String shadowPreference, String emergencyContactPhone, String username, String password) {
        this.idNumber = ++count;
        this.name = name;
        this.DoB = DoB;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.State = state;
        this.zip = zip;
        this.workHistory = workHistory;
        this.specializationPreference = specializationPreference;
        ShadowPreference = shadowPreference;
        EmergencyContactPhone = emergencyContactPhone;
        this.username = username;
        this.password = CryptoHash.cryptoProtect(password);

        addVolunteerApplication(this);
    }

    public int getIdNumber() {
        return idNumber;
    }

    @Override
    public String toString() {
        return name +";\t\tPhone: " + phone;
    }

    public static void addVolunteerApplication(VolunteerApplication... apps) {
        for (VolunteerApplication va : apps) {
            Collections.addAll(volunteerApplicationArrayList, va);
        }
    }
}
