package com.jimmy.hospitalsapp.logic;

import android.content.Context;

import com.jimmy.hospitalsapp.activities.BeginActivity;

/**
 * Created by Jimmy on 09/12/2016.
 */

public class ManagementApp {

    private Context context;
    private static  ManagementUser mgUser;
    private static ManagementDoctor mgDoc;
    private static ManagementAppointment mgAppointment;
    private static ManagementPatient mgPatient;

    public ManagementApp(Context context) {
        this.context = context;
        this.mgDoc = new ManagementDoctor();
        this.mgUser = new ManagementUser(context);
        this.mgAppointment = new ManagementAppointment();
        this.mgPatient = new ManagementPatient();
    }

    public static boolean validateUser(String userName, String password) {
        if (mgUser.validateUser(userName, password)) {

            return true;
        }
        return false;
    }


    public static boolean addAppointment(String date, String idDoctor, String idPatient) {
        return false;
    }

    public boolean validateDoctor(String idDoctor) {
        return false;
    }


    public static boolean addPatient(String name, String id, short age, String gender, String eps) {
        if (mgPatient.addPatient(name, id, age, gender, eps)) {
            return true;
        }
        return false;
    }

    public static boolean addDoctor(String namedoc, String iddoc, String spespecializa) {
        if (mgDoc.addDoctor(namedoc, iddoc, spespecializa)) {
            return true;
        }
        return false;
    }

    public static Appointment searchAppointment() {
        return null;
    }

    public static Patient findPatient(String idPatient) {
        return null;
    }

    public static Doctor findDoctor(String idDoctor) {
        return null;
    }

}
