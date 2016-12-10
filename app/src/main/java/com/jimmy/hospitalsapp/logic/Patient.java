package com.jimmy.hospitalsapp.logic;

/**
 * Created by Jimmy on 06/12/2016.
 */

public class Patient implements Comparable<Patient>{

    private String name;
    private String id;
    private short age;
    private String gender;

    public Patient(String name, String id, short age, String gender) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public short getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public int compareTo(Patient patient) {
        return this.id.compareTo(patient.getId());
    }
}
