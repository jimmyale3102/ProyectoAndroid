package com.jimmy.hospitalsapp.logic;

import com.jimmy.hospitalsapp.activities.BeginActivity;

/**
 * Created by Jimmy on 09/12/2016.
 */

public class ManagementApp {

    private ManagementUser mgUser;
    private ManagementAppointment mgAppointment;

    public ManagementApp() {
        mgUser = new ManagementUser(new BeginActivity());
        mgAppointment = new ManagementAppointment();
    }

    public boolean validateUser(String userName) {
        if(mgUser.validateUserName(userName)) {

        }
        return false;
    }

    public boolean validateDoctor(String idDoctor) {
        return false;
    }

    public boolean validatePatient(String idPatient) {
        return false;
    }

    public Appointment searchAppointment() {
        return null;
    }

    public Patient findPatient(String idPatient) {
        return null;
    }

    public Doctor findDoctor(String idDoctor) {
        return null;
    }

}
