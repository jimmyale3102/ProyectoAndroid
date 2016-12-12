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
    private ManagementPatient mgPatient;

    public ManagementApp(Context context) {
        this.context = context;
        this.mgUser = new ManagementUser(context);
        this.mgAppointment = new ManagementAppointment();
        this.mgPatient = mgPatient;
    }

    public boolean validateUser(String userName, String password) {
        return mgUser.validateUser(userName, password);
    }
    public boolean addPatient( String name, String id, short age, String gender, String eps ) {
        if(mgPatient.addPatient(name, id, age, gender, eps)) {
            return true;
        }
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
