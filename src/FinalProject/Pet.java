//1787 Consulting
//Course: CIS 484
//Final Project
//I promise that this work was done in accordance with the JMU honor code and
//I did not receive nor give unauthorized assistance in writing this program.
package FinalProject;

import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;

public class Pet {

    int idNumber;
    String name;
    String animalType;
    String species;
    String dateOfBirth;
    String ownerName;
    String ownerPhone;
    String ownerEmail;
    String ownerAddress;
    String ownerCity;
    String ownerState;
    String ownerZip;
    String comments;
    String vetBusinessName;
    String vetPhone;

    static ArrayList<Pet> petArrayList = new ArrayList<>();
    static int count = 0;

    // null pk constructor
    public Pet(String name, String animalType, String species, String dateOfBirth, String ownerName, String ownerPhone,
               String ownerEmail, String ownerAddress, String ownerCity, String ownerState, String ownerZip,
               String comments, String vetBusinessName, String vetPhone) {

        this.idNumber = ++count;
        this.name = name;
        this.animalType = animalType;
        this.species = species;
        this.dateOfBirth = dateOfBirth;
        this.ownerName = ownerName;
        this.ownerPhone = ownerPhone;
        this.ownerEmail = ownerEmail;
        this.ownerAddress = ownerAddress;
        this.ownerCity = ownerCity;
        this.ownerState = ownerState;
        this.ownerZip = ownerZip;
        this.comments = comments;
        this.vetBusinessName = vetBusinessName;
        this.vetPhone = vetPhone;

        addPets(this);
    }

    public Pet(int idNumber, String name, String animalType, String species, String dateOfBirth, String ownerName, String ownerPhone,
               String ownerEmail, String ownerAddress, String ownerCity, String ownerState, String ownerZip,
               String comments, String vetBusinessName, String vetPhone) {
        this.idNumber = idNumber;
        this.name = name;
        this.animalType = animalType;
        this.species = species;
        this.dateOfBirth = dateOfBirth;
        this.ownerName = ownerName;
        this.ownerPhone = ownerPhone;
        this.ownerEmail = ownerEmail;
        this.ownerAddress = ownerAddress;
        this.ownerCity = ownerCity;
        this.ownerState = ownerState;
        this.ownerZip = ownerZip;
        this.comments = comments;
        this.vetBusinessName = vetBusinessName;
        this.vetPhone = vetPhone;



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

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getOwnerCity() {
        return ownerCity;
    }

    public void setOwnerCity(String ownerCity) {
        this.ownerCity = ownerCity;
    }

    public String getOwnerState() {
        return ownerState;
    }

    public void setOwnerState(String ownerState) {
        this.ownerState = ownerState;
    }

    public String getOwnerZip() {
        return ownerZip;
    }

    public void setOwnerZip(String ownerZip) {
        this.ownerZip = ownerZip;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getVetBusinessName() {
        return vetBusinessName;
    }

    public void setVetBusinessName(String vetBusinessName) {
        this.vetBusinessName = vetBusinessName;
    }

    public String getVetPhone() {
        return vetPhone;
    }

    public void setVetPhone(String vetPhone) {
        this.vetPhone = vetPhone;
    }

    public static ArrayList<Pet> getPetArrayList() {
        return petArrayList;
    }

    @Override
    public String toString() {
        return "Name: " + name + ",\tType: " + animalType +
                ",\tOwner: " + ownerName + ",\tPhone: " + ownerPhone;
    }

    public static void addPets(Pet... pets){
        for (Pet p : pets){
            Collections.addAll(petArrayList, p);
        }

    }
}
