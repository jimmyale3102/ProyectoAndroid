package com.jimmy.hospitalsapp.logic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase encargada de manejar los operaciones de order y añadir
 * Created by Jimmy and Sergio  on 06/12/2016.
 */

public class ManagementAppointment implements Serializable{

    private static final long serialVersionUID = 123L;
    private ArrayList<Appointment> appointments;

    public ManagementAppointment() {

        appointments = new ArrayList<>();
    }

    /**
     *Metodo para añadir una cita medica
     * @param date fecha de la cita asignada, atributo de tipo String
     * @param hour hora de la cita asignada, atributo de tipo String
     * @param idPat id(C.C) de le paciente, atributo de tipo String
     * @param tjDoc (Tarjeta de profeción ), atributo de tipo String
     * @return tipo boolean
     */
    public boolean addAppointment(String date, String hour, String idPat, String tjDoc){
        Appointment appointment = new Appointment(date, hour, idPat, tjDoc);
        if(compareAppointment(appointment)){
          return false;
        } else {
            appointments.add(new Appointment(date, hour, idPat, tjDoc));
            return true;
        }
    }

    /** Metod que compara las citas que sea las mismas en la misca fecha y hora
     *
     * @param appointment Objeto de la clase Appointment
     * @return tipo boolean
     */

    public boolean compareAppointment(Appointment appointment){

        ArrayList<Appointment> appointmentAux = (ArrayList<Appointment>) appointments.clone();
        for (int i = 0; i < appointmentAux.size(); i++) {
            if (appointmentAux.get(i).getDate().equals(appointment.getDate())) {
                if (appointmentAux.get(i).getHour().equals(appointment.getHour())) {
                    if(appointmentAux.get(i).getIdPatient().equals(appointment.getIdPatient())) {
                        if(appointmentAux.get(i).getTjDoctor().equals(appointment.getTjDoctor())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     *
     * @return
     */
    public ArrayList<Appointment> getAppointments() {
        return (ArrayList<Appointment>) appointments.clone();
    }


}
