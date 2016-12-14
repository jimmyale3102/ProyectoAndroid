package com.jimmy.hospitalsapp.logic;

import java.io.Serializable;

/**
 * Created by Jimmy on 06/12/2016.
 */

public class Appointment implements Serializable{

    private static final long serialVersionUID = 123L;
    private String date;
    private String hour;
    private String idPatient;
    private String tjDoctor;

    public Appointment(String date, String hour, String idPatient, String tjDoctor) {
        this.date = date;
        this.hour = hour;
        this.idPatient = idPatient;
        this.tjDoctor = tjDoctor;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setIdPatient(String idPatient) {

        this.idPatient = idPatient;
    }

    public void setTjDoctor(Doctor idDoctor) {
        this.tjDoctor = tjDoctor;
    }

    public String getDate() {
        return date;
    }

    public String getHour() {
        return hour;
    }

    public String getIdPatient() {
        return idPatient;
    }

    public String getTjDoctor() {
        return tjDoctor;
    }
}
