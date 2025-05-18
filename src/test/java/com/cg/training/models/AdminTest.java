package com.cg.training.models;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains unit tests for the Admin and Doctor classes.
 * It checks various functionalities such as removing doctors,
 * checking doctor availability, and verifying profile display.
 * 
 * <p>This is written for beginner-level understanding.</p>
 * 
 * @author Sampritee Dey
 */
public class AdminTest {

    private Admin admin;
    private List<Doctor> doctors;

    /**
     * This method runs before each test. It creates an Admin object
     * and a list of Doctor objects to use in the tests.
     */
    @Before
    public void setUp() {
        admin = new Admin("A1", "AdminName");
        doctors = new ArrayList<>();
        doctors.add(new Doctor("D1001", "Ram"));
        doctors.add(new Doctor("D1002", "Laxman"));
        doctors.add(new Doctor("D1003", "Bharat"));
    }

    /**
     * This test checks if a doctor with a valid ID is successfully removed
     * from the list by the admin.
     */
    @Test
    public void testRemoveDoctor_ValidId() {
        admin.removeDoctor(doctors, "D1002");

        assertEquals(2, doctors.size());
        assertFalse(doctors.stream().anyMatch(d -> d.getId().equals("D1002")));
    }

    /**
     * This test checks that if the admin tries to remove a doctor with
     * an invalid ID, the list remains unchanged.
     */
    @Test
    public void testRemoveDoctor_InvalidId() {
        admin.removeDoctor(doctors, "D9999");

        assertEquals(3, doctors.size());
    }

    /**
     * This test simply calls the showProfile method of the admin.
     * It checks that the method runs without errors.
     */
    @Test
    public void testShowProfile() {
        admin.showProfile();
    }

    /**
     * This test checks the availability status of a doctor.
     * It verifies that the status can be changed.
     */
    @Test
    public void testDoctorAvailability() {
        Doctor d = new Doctor("D2001", "Hanuman");

        assertTrue(d.isAvailable());

        d.setAvailable(false);
        assertFalse(d.isAvailable());
    }

    /**
     * This test runs the showProfile method for a doctor.
     * It ensures the method works without throwing any exceptions.
     */
    @Test
    public void testDoctorShowProfile() {
        Doctor d = new Doctor("D2002", "Sita");
        d.showProfile();
    }

    /**
     * This test checks if the list of doctors was created correctly
     * and contains the right IDs and names.
     */
    @Test
    public void testDoctorListIntegrity() {
        assertEquals("D1001", doctors.get(0).getId());
        assertEquals("D1002", doctors.get(1).getId());
        assertEquals("D1003", doctors.get(2).getId());

        assertEquals("Ram", doctors.get(0).getName());
        assertEquals("Laxman", doctors.get(1).getName());
        assertEquals("Bharat", doctors.get(2).getName());
    }

    /**
     * This test checks if the admin's ID and name can be correctly retrieved.
     */
    @Test
    public void testAdminGetters() {
        assertEquals("A1", admin.getId());
        assertEquals("AdminName", admin.getName());
    }
}
