package com.jimmy.hospitalsapp.logic;

import java.util.ArrayList;

/**
 * Created by Jimmy on 09/12/2016.
 */

public class ManagementAppointment {


    public boolean addApirpointment(String date, String idDoc, String idPat){

        if(comparateIDoctor(idDoc) == false && compareIDPatinent(idPat) == false){
          return true;
        }
        return false;
    }

    public  boolean  comparateIDoctor(String idDoc){

        ArrayList<Doctor> doctoraux= (ArrayList<Doctor>) ManagementApp.getMgDoctors().getDoctors();
        for (int i = 0; i < doctoraux.size(); i++) {
            if (doctoraux.get(i).getId() == idDoc) {
                return true;
            }
        }
        return false;
    }


    public boolean compareIDPatinent(String idPat){
        ArrayList<Patient> patientaux =  (ArrayList<Patient>) ManagementApp.getMgPatient().getPatients();
        for (int i = 0; i < patientaux.size(); i++) {
            if (patientaux.get(i).getId() == idPat) {
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


    public ArrayList<Doctor> sorIdDoctors() {
        Doctor doc = null;
        ArrayList<Doctor> doctorAux = (ArrayList<Doctor>) ManagementApp.getMgDoctors().getDoctors();;
        for (int aux = doctorAux.size(); aux > 0; aux--) {
            for (int i = 0; i < aux - 1; i++) {
                if (doctorAux.get(i).getId().compareTo(doctorAux.get(i + 1).getId()) > 0) {
                    doc = doctorAux.get(i);
                    doctorAux.set(i, doctorAux.get(i + 1));
                    doctorAux.set(i + 1, doc);
                }
            }
        }
        return doctorAux;
    }

    public int findPatient(String idpat){
        ArrayList<Patient> patientAux = sortIdPatient();
        short middle = 0;
        short begin = 0;
        short finish = (short) (patientAux.size() - 1);
        while (begin <= finish) {
            middle = (short) ((begin + finish) / 2);
            if (patientAux.get(middle).getId().equals(idpat)) {
                return middle;
            } else if (patientAux.get(middle).getId().compareTo(idpat) > 0) {
                finish = (short) (middle - 1);
            } else {
                begin = (short) (middle + 1);
            }
        }
        return -1;
    }


    public  int findDoctor(String iddoc){

        ArrayList<Doctor> doctorAux = sorIdDoctors();
        short middle = 0;
        short begin = 0;
        short finish = (short) (doctorAux.size() - 1);
        while (begin <= finish) {
            middle = (short) ((begin + finish) / 2);
            if (doctorAux.get(middle).getId().equals(iddoc)) {
                return middle;
            } else if (doctorAux.get(middle).getId().compareTo(iddoc) > 0) {
                finish = (short) (middle - 1);
            } else {
                begin = (short) (middle + 1);
            }
        }
        return -1;
    }


}
