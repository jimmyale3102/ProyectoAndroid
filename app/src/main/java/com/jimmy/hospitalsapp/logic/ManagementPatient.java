package com.jimmy.hospitalsapp.logic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase encargada de manejar los operaciones de order y añadir de la Clase Patient
 * Created by Jimmy and Sergio  on 06/12/2016.
 */

public class ManagementPatient implements Serializable{

    private static final long serialVersionUID = 123L;
    private ArrayList<Patient> patients;

    public ManagementPatient() {

        patients = new ArrayList<>();
    }

    /**
     *Metodo para añadir un paciente
     *
     * @param name nombre del paciente atributo de tipo String
     * @param id id (C.C) de el paciente atributo de tipo String
     * @param age Edad del paciente atributo de tipo short
     * @param gender genero de el paciente atributo de tipo String
     * @param eps eps de el paciente atributo de tipo String
     * @return tipo boolean
     */
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

    /**
     * Metodo que comparada el id del Patient en existencias
     * @param id (C.C) de Patient de tipo String
     * @return tipo boolean
     */
    public boolean compareId(String id) {
        ArrayList<Patient> patientAux = (ArrayList<Patient>) patients.clone();
        for(int i = 0; i < patientAux.size(); i++) {
            if(patientAux.get(i).getId() == id) {
                return true;
            }
        }
        return  false;
    }

    /**
     *Metodo que orderna por id (C.C ) de Paciente
     * @return ArrayList<> ordenado clon de ArrayList<>Patient
     */
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

    /**
     *Metodo que busca el Paciente por id(C.C)
     * @param id (C.C ) de Paciente de tipo String
     * @return diferenciador(establecido) de tipo entero.
     */
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

    /**
     *
     * @param id
     * @return
     */
    public Patient getPatient(String id) {
        ArrayList<Patient> patientAux = sortIdPatient();
        short middle;
        short begin = 0;
        short finish = (short) (patientAux.size() - 1);
        while(begin <= finish) {
            middle = (short) ((begin + finish) / 2);
            if(patientAux.get(middle).getId().equals(id)) {
                return patientAux.get(middle);
            } else if (patientAux.get(middle).getId().compareTo(id) > 0) {
                finish = (short) (middle - 1);
            } else {
                begin = (short) (middle + 1);
            }
        }
        return null;
    }

    /**
     *Metodo que retorna un clon de el ArrayList<>Patient
     * @return clon de ArrayList<{@link Patient}>
     */

    public ArrayList<Patient> getPatients() {
        return (ArrayList<Patient>) patients.clone();
    }

}
