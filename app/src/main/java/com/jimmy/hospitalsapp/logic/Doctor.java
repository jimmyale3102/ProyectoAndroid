package com.jimmy.hospitalsapp.logic;

import java.io.Serializable;

/**
* Clase encargada de manejar los atributos de un Doctor
        * Created by Jimmy and Sergio  on 06/12/2016.
        */

public class Doctor implements Comparable<Doctor>, Serializable{

    private static final long serialVersionUID = 123L;
    private String name;
    private String id;
    private String specialization;

    /**
     *
     * @param name atributo que le da el nombre al Doctor.
     * @param id (Tarjeta Profecional)  campo calve unico para un Doctor
     * @param specialization atributo que le da la especializacion al Doctor
     */

    public Doctor(String name, String id, String specialization) {
        this.name = name;
        this.id = id;
        this.specialization = specialization;
    }

    /**Metodo get que retorna el nombre de un Doctor de tipo String.
     *
     * @return nombre de el  doctor.
     */
    public String getName() {
        return name;
    }

    /**Metodo get que retorna el Id (Tarjeta Profecional) de un Doctortipo String.
     *
     * @return id del paciente.
     */
    public String getId() {
        return id;
    }

    /**Metodo get que retorna la especializacion de un Dcotor tipo String.
     *
     * @return especializacion de el Doctor.
     */
    public String getSpecialization() {
        return specialization;
    }

    /**Metodo set  que asigna el nombre de el Doctor en
     * parametro con el establecido en la clase.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**Metodo set  que asigna el Id de el Doctor  en
     * parametro con el establecido en la clase.
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * /**Metodo set  que asigna la especializacion de el Doctor en
     * parametro con el establecido en la clase.
     *
     *
     * @param specialization
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }


    /**
     * Representacion de tipo String de los atributos de la clase Doctor.
     * @return una representacion de tipo String  de Doctor.
     */
    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }

    /**
     * Metodo que compara el Id de el Doctor y retorna el id de el mismo
     * @param doctor
     * @return
     */
    @Override
    public int compareTo(Doctor doctor) {
        return this.id.compareTo(doctor.getId());
    }
}
