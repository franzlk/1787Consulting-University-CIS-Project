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

    // null pk constructor
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
        this.password = password;

        addVolunteerApplication(this);// this is only not necessary when the volunteer array list is initially populated by the db
        // so we don't need to include this method call below in the 'present pk constructor'
    }

    // present pk constructor
    public VolunteerApplication(int idNumber, String name, String DoB, String email,
                                String phone, String address, String city, String state,
                                String zip, String workHistory, String specializationPreference,
                                String shadowPreference, String emergencyContactPhone, String username, String password) {
        this.idNumber = idNumber;
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
