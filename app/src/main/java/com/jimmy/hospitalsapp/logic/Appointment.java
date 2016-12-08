package com.jimmy.hospitalsapp.logic;

/**
 * Created by Jimmy on 06/12/2016.
 */

public class Appointment {

    private String date;
    private String hour;
    private Patient patient;
    private Doctor doctor;

    public Appointment(String date, String hour, Patient patient, Doctor doctor) {
        this.date = date;
        this.hour = hour;
        this.patient = patient;
        this.doctor = doctor;
    }

    public String getDate() {
        return date;
    }

    public String getHour() {
        return hour;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }
}
