package com.jimmy.hospitalsapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.jimmy.hospitalsapp.R;

public class MenuActivity extends AppCompatActivity {

    private ImageButton btnRgPatient;
    private ImageButton btnRgDoctor;
    private ImageButton btnRgAppointment;
    private ImageButton btnConsult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnRgPatient = (ImageButton) findViewById(R.id.btnRgPatient);
        btnRgDoctor = (ImageButton) findViewById(R.id.btnRgDoctor);
        btnRgAppointment = (ImageButton) findViewById(R.id.btnRgAppointment);
        btnConsult = (ImageButton) findViewById(R.id.btnConsult);

        btnRgDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regDoctor = new Intent(MenuActivity.this, Register_DoctorAct.class);
                startActivity(regDoctor);
            }
        });

        btnRgPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regPatient = new Intent(MenuActivity.this, Register_PatientAct.class);
                startActivity(regPatient);
            }
        });

        btnRgAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regAppointment = new Intent(MenuActivity.this, Register_Appoinment.class);
                startActivity(regAppointment);
            }
        });
    }
}
