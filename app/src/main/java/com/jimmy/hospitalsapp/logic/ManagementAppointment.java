package com.jimmy.hospitalsapp.logic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Jimmy on 09/12/2016.
 */

public class ManagementAppointment implements Serializable{

    private static final long serialVersionUID = 123L;
    private ArrayList<Appointment> appointments;

    public ManagementAppointment() {

        appointments = new ArrayList<>();
    }

    public boolean addAppointment(String date, String hour, String idPat, String tjDoc){
        Appointment appointment = new Appointment(date, hour, idPat, tjDoc);
        if(compareAppointment(appointment)){
          return false;
        } else {
            appointments.add(new Appointment(date, hour, idPat, tjDoc));
            return true;
        }
    }

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

    public ArrayList<Appointment> getAppointments() {
        return (ArrayList<Appointment>) appointments.clone();
    }


}
