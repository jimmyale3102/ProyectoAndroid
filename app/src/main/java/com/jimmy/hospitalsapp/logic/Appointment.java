package com.jimmy.hospitalsapp.logic;

import java.io.Serializable;

/**
 * Clase encargada de manejar los atributos de una Cita medica
 * * Created by Jimmy and Sergio  on 06/12/2016.
 */

public class Appointment implements Serializable{

    private static final long serialVersionUID = 123L;
    private String date;
    private String hour;
    private String idPatient;
    private String tjDoctor;

    /**
     *
     * @param date atributo que da la fecha en la que se asigna la cita.
     * @param hour atributo que da la hora en la que se asigna la cita.
     * @param idPatient id(C.C) de paciente para la asignacion de la cita.
     * @param tjDoctor Tarjeta profesional de Dotor para poder asignar la cita.
     */

    public Appointment(String date, String hour, String idPatient, String tjDoctor) {
        this.date = date;
        this.hour = hour;
        this.idPatient = idPatient;
        this.tjDoctor = tjDoctor;
    }

    /**Metodo set  que asigna la fecha de la cita  en
     * parametro con el establecido en la clase.
     *
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**Metodo set  que asigna la hora  de la cita en
     * parametro con el establecido en la clase.
     *
     * @param hour
     */
    public void setHour(String hour) {
        this.hour = hour;
    }

    /**Metodo set  que asigna el Id de el paciente  en
     * parametro con el establecido en la clase.
     *
     * @param idPatient
     */
    public void setIdPatient(String idPatient) {

        this.idPatient = idPatient;
    }

    /**Metodo set  que asigna el Id de el Doctor  en
     * parametro con el establecido en la clase.
     *
     * @param idDoctor
     */
    public void setTjDoctor(Doctor idDoctor) {
        this.tjDoctor = tjDoctor;
    }

    /**Metodo get que retorna la fecha de la cita de tipo String.
     *
     * @return fecha de cita asignada.
     */
    public String getDate() {
        return date;
    }
    /**Metodo get que retorna hora de la cita de tipo String.
     *
     * @return hora de la cita asignada.
     */

    public String getHour() {
        return hour;
    }
    /**Metodo get que retorna el id de un paciente de tipo String.
     *
     * @return id del paciente para asiganar la cita.
     */

    public String getIdPatient() {
        return idPatient;
    }
    /**Metodo get que retorna el id(Targeta Profecional) de un Doctor de tipo String.
     *
     * @return id de doctor para asignar la cita.
     */

    public String getTjDoctor() {
        return tjDoctor;
    }
}
