package com.jimmy.hospitalsapp.logic;

/**
 * Created by Jimmy on 06/12/2016.
 */

public class Appointment {

    private String date;
    private String hour;
    private Patient idPatient;
    private Doctor idDoctor;

    public Appointment(String date, String hour, Patient idPatient, Doctor idDoctor) {
        this.date = date;
        this.hour = hour;
        this.idPatient = idPatient;
        this.idDoctor = idDoctor;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setIdPatient(Patient idPatient) {
        this.idPatient = idPatient;
    }

    public void setIdDoctor(Doctor idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getDate() {
        return date;
    }

    public String getHour() {
        return hour;
    }

    public Patient getIdPatient() {
        return idPatient;
    }

    public Doctor getIdDoctor() {
        return idDoctor;
    }
}
