package com.cg.training.dao;

import com.cg.training.models.Appointment;
import com.cg.training.models.Patient;

/**
 * This interface defines the operations for a Medical Appointment System.
 * It includes methods for registering patients and doctors, booking and completing
 * appointments, viewing appointments and doctor profiles, and saving data.
 * 
 * <p>All implementing classes must provide concrete implementations of these methods.</p>
 * 
 * @author Rajarshi Das
 */
public interface AppointmentSystemDAO {

    /**
     * Registers a new patient with a unique ID and validates the name.
     * 
     * @param name the name of the patient to be registered
     */
    void registerPatient(String name);

    /**
     * Registers a new doctor with a unique ID and validates the name.
     * 
     * @param name the name of the doctor to be registered
     */
    void registerDoctor(String name);

    /**
     * Books an appointment for the given patient with the first available doctor.
     * 
     * @param patient the patient who wants to book an appointment
     * @return the booked appointment object
     */
    Appointment bookAppointment(Patient patient);

    /**
     * Marks the appointment at the given index as completed.
     * 
     * @param index the index of the appointment in the list
     */
    void completeAppointment(int index);

    /**
     * Displays the profile information of all registered doctors.
     */
    void showAllDoctors();

    /**
     * Displays all booked appointments.
     */
    void showAllAppointments();

    /**
     * Shows all appointments associated with a specific doctor using their ID.
     * 
     * @param doctorId the unique ID of the doctor
     */
    void showAppointmentsByDoctorId(String doctorId);

    /**
     * Shows all appointments associated with a specific patient using their ID.
     * 
     * @param patientId the unique ID of the patient
     */
    void showAppointmentsByPatientId(String patientId);

    /**
     * Finds and returns a patient using their ID.
     * 
     * @param id the unique ID of the patient
     * @return the Patient object, or null if not found
     */
    Patient findPatientById(String id);

    /**
     * Saves the details of all appointments to a file.
     * This is useful for keeping a record of scheduled and completed appointments.
     */
    void saveAppointmentsToFile();

    /**
     * Clears the contents of the appointments file before the application exits.
     */
    void clearContainsOfTheFile();
}
