package com.jimmy.hospitalsapp.logic;

/**
 * Created by Jimmy on 06/12/2016.
 */

public class Patient {

    private String namePatient;
    private String idPatient;

    public Patient(String namePatient, String idPatient) {
        this.namePatient = namePatient;
        this.idPatient = idPatient;
    }

    public String getNamePatient() {
        return namePatient;
    }

    public String getIdPatient() {
        return idPatient;
    }
}
