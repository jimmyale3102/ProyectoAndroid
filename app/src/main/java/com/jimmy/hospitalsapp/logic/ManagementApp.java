package com.jimmy.hospitalsapp.logic;

import android.content.Context;

import com.jimmy.hospitalsapp.activities.BeginActivity;

/**
 * Created by Jimmy on 09/12/2016.
 */

public class ManagementApp {

    private Context context;
    private ManagementUser mgUser;
    private ManagementAppointment mgAppointment;

    public ManagementApp(Context context) {
        this.context = context;
        this.mgUser = new ManagementUser(context);
        this.mgAppointment = new ManagementAppointment();
    }

    public boolean validateUser(String userName, String password) {
        return mgUser.validateUser(userName, password);
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
