package com.jimmy.hospitalsapp.logic;

/**
 * Created by Jimmy on 06/12/2016.
 */

public class Doctor implements Comparable<Doctor>{

    private String name;
    private String id;
    private String specialization;

    public Doctor(String name, String id, String specialization) {
        this.name = name;
        this.id = id;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }


    @Override
    public int compareTo(Doctor doctor) {
        return this.id.compareTo(doctor.getId());
    }
}
