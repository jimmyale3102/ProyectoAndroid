package com.jimmy.hospitalsapp.logic;

import android.content.Context;

import com.jimmy.hospitalsapp.activities.BeginActivity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Jimmy on 09/12/2016.
 */

public class ManagementApp implements Serializable {

    private static final long serialVersionUID = 123L;
    private Context context;
    private static  ManagementUser mgUser;
    private static ManagementDoctor mgDoc;
    private static ManagementAppointment mgAppointment;
    private static ManagementPatient mgPatient;
    private static ManagementApp manaApp;

    public ManagementApp(Context context) {
        context = context;
        mgDoc = new ManagementDoctor();
        mgUser = new ManagementUser(context);
        mgAppointment = new ManagementAppointment();
        mgPatient = new ManagementPatient();
        manaApp = this;
    }

    public static boolean validateUser(String userName, String password) {
        if (mgUser.validateUser(userName, password)) {

            return true;
        }
        return false;
    }


    public static boolean addAppointment(String date, String hour, String idPatient, String tjDoctor) {
        return mgAppointment.addAppointment(date, hour, idPatient, tjDoctor);
    }

    public static boolean validateDoctor(String tjDoctor) {
        if(mgDoc.findDoctor(tjDoctor) == -1){
            return true;
        }
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

    public static boolean findPatient(String idPatient) {
        if (mgPatient.findPatient(idPatient) == -1) {
            return true;
        }
        return false;
    }

    public static Patient findInfoPatient(String idPatient) {
        if (mgPatient.getPatient(idPatient) != null) {
            return mgPatient.getPatient(idPatient);
        }
        return null;
    }

    public static Doctor findDoctor(String idDoctor) {
        if (mgDoc.getDoctor(idDoctor) != null) {
            return mgDoc.getDoctor(idDoctor);
        }
        return null;
    }






    public static void setMgUser(ManagementUser managementUser){
        ManagementApp.mgUser= managementUser;

    }
    public static void setMgDoc(ManagementDoctor managementDoctor){
        ManagementApp.mgDoc= managementDoctor;
    }

    public static void setMgAppointment(ManagementAppointment managementAppointment){
        ManagementApp.mgAppointment= managementAppointment;

    }
    public static void setMgPatient(ManagementPatient managementPatient){
        ManagementApp.mgPatient= managementPatient;

    }


    public static ManagementUser getMgUser() {
        return mgUser;
    }

    public static  ManagementDoctor getMgDoc() {
        return mgDoc;
    }

    public static ManagementAppointment getMgAppointments() {
        return mgAppointment;
    }
    public  static ManagementAppointment getMgAppointment() {
        return mgAppointment;
    }

    public static ManagementPatient getMgPatient() {
        return mgPatient;
    }

    public static ManagementApp get(){
        return manaApp;
    }

}
