package com.cg.training.models;

import java.util.List;

import com.cg.training.annotations.Security;

/**
 * Represents an Admin user in the system who has the ability to manage doctors.
 * This class extends the User class and includes additional admin-level functionality.
 * <p>
 * Marked with the @Security annotation to indicate that only users with
 * admin role should have access to its functionality.
 * </p>
 * 
 * @author Rajarshi Das
 */
@Security(role = "Admin")
public class Admin extends User {

    /**
     * Constructor to create an Admin with a given ID and name.
     * 
     * @param id   the unique ID of the admin
     * @param name the name of the admin
     */
    public Admin(String id, String name) {
        super(id, name);
    }

    /**
     * Displays the admin's profile information including ID and name.
     * This method overrides the abstract method from the User class.
     */
    @Override
    public void showProfile() {
        System.out.println("Admin ID: " + id + ", Name: " + name);
    }

    /**
     * Removes a doctor from the given list of doctors based on doctor ID.
     * If the doctor list is empty, or if the doctor ID is not found, appropriate messages are shown.
     * 
     * @param doctors  the list of doctors
     * @param doctorId the ID of the doctor to be removed
     */
    public void removeDoctor(List<Doctor> doctors, String doctorId) {
        if (doctors.size() == 0) {
            System.out.println("No doctor in the list");
        } else {
            for (int i = 0; i < doctors.size(); i++) {
                Doctor d = doctors.get(i);
                if (d.getId().equals(doctorId)) {
                    doctors.remove(i);
                    System.out.println("Doctor removed.");
                    return;
                }
            }
            System.out.println("Doctor ID not found.");
        }
    }
}
