package com.jimmy.hospitalsapp.logic;

import android.content.Context;

import com.jimmy.hospitalsapp.activities.BeginActivity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase encargada de manejar todos Management del proyecto
 * Created by Jimmy and Sergio  on 06/12/2016.
 */

public class ManagementApp implements Serializable {

    private static final long serialVersionUID = 123L;
    private Context context;
    private static  ManagementUser mgUser;
    private static ManagementDoctor mgDoc;
    private static ManagementAppointment mgAppointment;
    private static ManagementPatient mgPatient;
    private static ManagementApp manaApp;

    /**
     *
     * @param context
     */

    public ManagementApp(Context context) {
        context = context;
        mgDoc = new ManagementDoctor();
        mgUser = new ManagementUser(context);
        mgAppointment = new ManagementAppointment();
        mgPatient = new ManagementPatient();
        manaApp = this;
    }

    /**Metodo para validar el usuario
     *
     * @param userName atributo usuario de tipo String
     * @param password atributo password (clave de tipo String);
     * @return tipo boolean
     */
    public static boolean validateUser(String userName, String password) {
        if (mgUser.validateUser(userName, password)) {

            return true;
        }
        return false;
    }

    /**
     * Metodo para añadir una cita medica
     *
     * @param date fecha de la cita a asignar de tipo String.
     * @param hour hora de la cita a asiganr de tipo  String
     * @param idPatient id de el paciente para asignar la cita.
     * @param tjDoctor tarjeta profecional de Doctor para asiganr la cita.
     * @return tipo boolean
     */
    public static boolean addAppointment(String date, String hour, String idPatient, String tjDoctor) {
        return mgAppointment.addAppointment(date, hour, idPatient, tjDoctor);
    }

    /**
     * Metodo que valida la existencia de un Doctor
     * @param tjDoctor  id (tarjeta profecional) de Doctor tipo String.
     * @return tipo boolean
     */
    public static boolean validateDoctor(String tjDoctor) {
        if(mgDoc.findDoctor(tjDoctor) == -1){
            return true;
        }
        return false;
    }

    /**
     * Metodo para añadir un paciente
     * @param name nombre del Paciente de tipo String
     * @param id id(C.cC) del paciete de tipo String
     * @param age edad del paciente de tipo String
     * @param gender genero del paciente de tipo String
     * @param eps eps del paciente de tipo String
     * @return tipo boolean
     */
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

    /**
     *
     * @param idPatient
     * @return
     */
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

    /**
     *
     * @param idDoctor
     * @return
     */

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
