//1787 Consulting
//Course: CIS 484
//Final Project
//I promise that this work was done in accordance with the JMU honor code and
//I did not receive nor give unauthorized assistance in writing this program.
package FinalProject;

import java.lang.reflect.Array;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;

public class Specialization {
    static ArrayList<String> specializationArrayList = new ArrayList<String>(){
        {
            add("Animal Health Care");
            add("Feeding");
            add("Enclosure Care");
            add("Adopter Relations");
            add("Event Volunteer");
            add("Office Administration");

        }


    };

    public static ArrayList<String> getSpecializationArrayList() {
        return specializationArrayList;
    }
}
