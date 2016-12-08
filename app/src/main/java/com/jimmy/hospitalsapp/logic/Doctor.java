package com.jimmy.hospitalsapp.logic;

/**
 * Created by Jimmy on 06/12/2016.
 */

public class Doctor {

    private String nameDoctor;
    private String idDoctor;

    public Doctor(String nameDoctor, String idDoctor) {
        this.nameDoctor = nameDoctor;
        this.idDoctor = idDoctor;
    }

    public String getNameDoctor() {
        return nameDoctor;
    }

    public String getIdDoctor() {
        return idDoctor;
    }
}
