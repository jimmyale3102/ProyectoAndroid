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
        } else {
            appointments.add(new Appointment(date, hour, idPat, tjDoc));
            return true;
        }
    }

    public boolean compareAppointment(Appointment appointment){

        ArrayList<Appointment> appointmentAux = (ArrayList<Appointment>) appointments.clone();
        for (int i = 0; i < appointmentAux.size(); i++) {
            if (appointmentAux.get(i).equals(appointment)) {
                return true;
            }
        }
        return false;
    }
}
