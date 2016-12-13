package com.jimmy.hospitalsapp.logic;

import java.util.ArrayList;

/**
 * Created by Jimmy on 09/12/2016.
 */

public class ManagementPatient {

    private ArrayList<Patient> patients;

    public ManagementPatient() {

        patients = new ArrayList<>();
    }

    public boolean addPatient(String name, String id, short age, String gender, String eps) {
        if(compareId(id)) {
            return false;
        }
        if(findPatient(id) == -1) {
            patients.add(new Patient(name, id, age, gender,eps));
            return true;
        }
        return false;
    }

    public boolean compareId(String id) {
        ArrayList<Patient> patientAux = (ArrayList<Patient>) patients.clone();
        for(int i = 0; i < patientAux.size(); i++) {
            if(patientAux.get(i).getId() == id) {
                return true;
            }
        }
        return  false;
    }

    public ArrayList<Patient> sortIdPatient() {
        Patient patientObj = null;
        ArrayList<Patient> patientAux = (ArrayList<Patient>) patients.clone();
        for (int aux = patientAux.size(); aux > 0; aux--) {
            for (int i = 0; i < aux-1; i++) {
                if (patientAux.get(i).getId().compareTo(patientAux.get(i + 1).getId()) > 0) {
                    patientObj = patientAux.get(i);
                    patientAux.set(i, patientAux.get(i + 1));
                    patientAux.set(i + 1, patientObj);
                }
            }
        }
        return patientAux;
    }

    public int findPatient(String id) {
        ArrayList<Patient> patientAux = sortIdPatient();
        short middle;
        short begin = 0;
        short finish = (short) (patientAux.size() - 1);
        while(begin <= finish) {
            middle = (short) ((begin + finish) / 2);
            if(patientAux.get(middle).getId().equals(id)) {
                return middle;
            } else if (patientAux.get(middle).getId().compareTo(id) > 0) {
                finish = (short) (middle - 1);
            } else {
                begin = (short) (middle + 1);
            }
        }
        return -1;
    }

    public ArrayList<Patient> getPatients() {
        return (ArrayList<Patient>) patients.clone();
    }

}
