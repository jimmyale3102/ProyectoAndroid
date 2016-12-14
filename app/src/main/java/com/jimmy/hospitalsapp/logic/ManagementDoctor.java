package com.jimmy.hospitalsapp.logic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase encargada de manejar los operaciones de order y añadir de la clase Doctor
 * Created by Jimmy and Sergio  on 06/12/2016.
 */

public class ManagementDoctor implements Serializable{

    private static final long serialVersionUID = 123L;
    private ArrayList<Doctor> doctors;

    public ManagementDoctor() {

        doctors = new ArrayList<>();
    }

    /**
     * Metodo para añadir un Doctor
     * @param name  nombre de el Doctor atributo tipo String
     * @param id (tarejeta profecional ) de el Doctor de tipo String
     * @param specialization Especializacion del el doctor atributo de tipo String
     * @return tipo boolean
     */

    public boolean addDoctor(String name, String id, String specialization) {
        if(compareId(id)) {
            return false;
        }
        if(findDoctor(id) == -1) {
            doctors.add(new Doctor(name, id, specialization));
            return true;
        }
        return false;
    }

    /**
     * Metodo que comparada el id del Doctor en existencias
     * @param id (tarejeta profecional ) de el Doctor de tipo String
     * @return tipo boolean
     */
    private boolean compareId(String id) {
        ArrayList<Doctor> doctorAux = (ArrayList<Doctor>) doctors.clone();
        for (int i = 0; i < doctorAux.size(); i++) {
            if (doctorAux.get(i).getId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     *Metodo que orderna por id (tarejeta profecional ) de el Doctor
     * @return ArrayList<> ordenado clon de ArrayList<>Doctor
     */

    public ArrayList<Doctor> sortIdDoctor() {
        Doctor doc = null;
        ArrayList<Doctor> doctorAux = (ArrayList<Doctor>) doctors.clone();
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

    /**
     *Metodo que busca el Doctor por id
     * @param id (tarejeta profecional ) de el Doctor de tipo String
     * @return diferenciador(establecido) de tipo entero.
     */
    public int findDoctor(String id) {
        ArrayList<Doctor> doctorAux = sortIdDoctor();
        short middle = 0;
        short begin = 0;
        short finish = (short) (doctorAux.size() - 1);
        while (begin <= finish) {
            middle = (short) ((begin + finish) / 2);
            if (doctorAux.get(middle).getId().equals(id)) {
                return middle;
            } else if (doctorAux.get(middle).getId().compareTo(id) > 0) {
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


    public Doctor getDoctor(String id) {
        ArrayList<Doctor> doctorAux = sortIdDoctor();
        short middle;
        short begin = 0;
        short finish = (short) (doctorAux.size() - 1);
        while(begin <= finish) {
            middle = (short) ((begin + finish) / 2);
            if(doctorAux.get(middle).getId().equals(id)) {
                return doctorAux.get(middle);
            } else if (doctorAux.get(middle).getId().compareTo(id) > 0) {
                finish = (short) (middle - 1);
            } else {
                begin = (short) (middle + 1);
            }
        }
        return null;
    }

    /**
     *Metodo que retorna un clon de el ArrayList<>Doctor
     * @return clon de ArrayList<Doctor>
     */
    public ArrayList<Doctor> getDoctors() {
        return (ArrayList<Doctor>) doctors.clone();
    }

}
