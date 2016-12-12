package com.jimmy.hospitalsapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.jimmy.hospitalsapp.R;

public class Register_DoctorAct extends AppCompatActivity {

    private EditText namedoc;
    private EditText iddoc;
    private Spinner spinner2;
    private Button btnaddDoc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__doctor);


        namedoc = (EditText) findViewById(R.id.namedoc);
        iddoc = (EditText) findViewById(R.id.iddoc);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        btnaddDoc = (Button)findViewById(R.id.btnaddApp);








    }


}

