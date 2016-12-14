package com.jimmy.hospitalsapp.logic;

import java.util.ArrayList;

/**
 * Created by Jimmy on 09/12/2016.
 */

public class ManagementAppointment {

    private ArrayList<Appointment> appointments;

    public ManagementAppointment() {
        appointments = new ArrayList<>();
    }

    public boolean addAppointment(String date, String hour, String idPat, String tjDoc){

        Appointment appointment = new Appointment(date, hour, idPat, tjDoc);
        if(compareAppointment(appointment)){
          return false;
        }
        if(findAppointment(appointment) == null) {
            appointments.add(new Appointment(date, hour, idPat, tjDoc));
            return true;
        }
        return false;
    }

    public  boolean  compareAppointment(Appointment appointment){

        ArrayList<Appointment> appointmentAux = (ArrayList<Appointment>) appointments.clone();
        for (int i = 0; i < appointmentAux.size(); i++) {
            if (appointmentAux.get(i).equals(appointment)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Patient> sortIdPatient(){
        Patient pat = null;
        ArrayList<Patient> patientAux = ManagementApp.getMgPatient().getPatients();
        for (int aux = patientAux.size(); aux > 0; aux--) {
            for (int i = 0; i < aux - 1; i++) {
                if (patientAux.get(i).getId().compareTo(patientAux.get(i + 1).getId()) > 0) {
                    pat = patientAux.get(i);
                    patientAux.set(i, patientAux.get(i + 1));
                    patientAux.set(i + 1, pat);
                }
            }
        }
        return patientAux;

    }


    public ArrayList<Appointment> sortAppointment() {
        Appointment appAux;
        ArrayList<Appointment> appointmentAux = (ArrayList<Appointment>) appointments.clone();
        for (int aux = appointmentAux.size(); aux > 0; aux--) {
            for (int i = 0; i < aux - 1; i++) {
                if ((appointmentAux.get(i).getTjDoctor().compareTo(appointmentAux.get(i + 1).getTjDoctor())) > 0) {
                    appAux = appointmentAux.get(i);
                    appointmentAux.set(i, appointmentAux.get(i + 1));
                    appointmentAux.set(i + 1, appAux);
                }
            }
        }
        return appointmentAux;
    }

    public Appointment findAppointment(Appointment appointment){
        ArrayList<Appointment> appointmentAux = sortAppointment();
        for (int i = 0; i < appointmentAux.size(); i++) {
            if(appointmentAux.get(i).equals(appointment)) {
                return appointment;
            }
        }
        return null;
    }
}
