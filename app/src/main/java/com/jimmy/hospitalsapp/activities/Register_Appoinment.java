package com.jimmy.hospitalsapp.activities;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.jimmy.hospitalsapp.R;
import com.jimmy.hospitalsapp.logic.ManagementApp;

import java.util.Calendar;

public class Register_Appoinment extends AppCompatActivity {

    private EditText tjDoc;
    private EditText idPat;
    private Button btnAddAppointment;
    private Button btnDate;
    private String date;
    private Spinner hour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__appoinment);

        tjDoc = (EditText) findViewById(R.id.tjDoc);
        idPat = (EditText) findViewById(R.id.idPat);
        hour = (Spinner) findViewById(R.id.spHour);
        btnAddAppointment = (Button) findViewById(R.id.btnAddAppointment);
        btnDate =  (Button) findViewById(R.id.btnDate);


        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickDate();
            }
        });

        btnAddAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (idPat.getText().length() > 0) {
                   if(ManagementApp.validateDoctor(tjDoc.getText().toString()) || ManagementApp.findPatient(idPat.getText().toString())) {
                       onAlertDialog2();
                   } else {
                       if (ManagementApp.addAppointment(date, hour.getSelectedItem().toString(), idPat.getText().toString(), tjDoc.getText().toString())) {
                           onAlertDialog();
                       } else {
                           onToastAdd();
                       }
                   }
                } else {
                    onToast();
                }
            }
        });
    }

    private void pickDate() {
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int day, int month, int year) {
                date = String.valueOf(day)+" ~ "+String.valueOf(month)+" ~ "+String.valueOf(year);
            }
        }, day, month, year);
        dialog.getDatePicker().setMinDate(c.getTime().getTime());
        c.add(Calendar.MONTH,1);
        dialog.getDatePicker().setMaxDate(c.getTime().getTime());
        dialog.show();
    }

    public void onToast() {
        Toast toast = Toast.makeText(this, "Hay campos vacios o falta información", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onToastAdd() {
        Toast toast = Toast.makeText(this, "Imposible, la Cita ya Existe", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onAlertDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("¡Exito!");
        alertDialog.setMessage("La cita se registró correctamente");
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alertDialog.show();
    }

    public void onAlertDialog2() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Error");
        alertDialog.setMessage("El paciente y/o el doctor no existen");
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alertDialog.show();
    }
}
