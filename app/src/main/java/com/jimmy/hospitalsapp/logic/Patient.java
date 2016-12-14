package com.jimmy.hospitalsapp.logic;

import java.io.Serializable;

/**
 * Clase encargada de manejar los atributos de un paciente
 * Created by Jimmy and Sergio  on 06/12/2016.
 */


public class Patient implements Comparable<Patient>, Serializable{

    private static final long serialVersionUID = 123L;
    private String name;
    private String id;
    private short age;
    private String gender;
    private String eps;

    /**
     *
     * @param name atributo que le da el nombre al paciente
     * @param id (cedula de cuidania ) campo clave unico de un paciente
     * @param age atributo Short edad de un paciente
     * @param gender atributo String genero de  un paciente
     * @param eps atributo String de Eps(Empresa Prestadora de Salud), de un paciente.
     */

    public Patient(String name, String id, short age, String gender,String eps) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.eps= eps;
    }

    /**Metodo get que retorna el nombre de un paciente tipo String.
     *
     * @return nombre de el  paciente.
     */
    public String getName() {
        return name;
    }

    /**Metodo get que retorna el id (C.C) de un paciente tipo String.
     *
     * @return id de el  paciente.
     */

    public String getId() {
        return id;
    }

    /**Metodo get que retorna la edad  de un paciente tipo short.
     *
     * @return edad de un  paciente.
     */

    public short getAge() {
        return age;
    }

    /**Metodo get que retorna el genero de un paciente tipo String.
     *
     * @return genero de el  paciente.
     */

    public String getGender() {
        return gender;
    }


    /**Metodo set  que asigna el nombre de el paciente en
     * parametro con el establecido en la clase.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**Metodo set  que asigna el id de el paciente en
     * parametro con el establecido en la clase.
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**Metodo set  que asigna la edad de el paciente en
     * parametro con el establecido en la clase.
     *
     * @param age
     */
    public void setAge(short age) {
        this.age = age;
    }

    /**Metodo set  que asigna el genero  de el paciente en
     * parametro con el establecido en la clase.
     *
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**Metodo get que retorna la EPS de un paciente tipo String.
     *
     * @return genero de el  paciente.
     */

    public String getEps(){return eps;}
    /**Metodo set  que asigna el nombre de el paciente en
     * parametro con el establecido en la clase.
     *
     * @return
     */

    public void setEps(String eps){this.eps=eps;}

    /**
     * Representacion de tipo String de los atributos de el paciente.
     * @return una representacion de tipo String  de paciente.
     */
    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public int compareTo(Patient patient) {
        return this.id.compareTo(patient.getId());
    }
}
