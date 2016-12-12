package com.jimmy.hospitalsapp.activities;

import android.content.Intent;
import android.inputmethodservice.KeyboardView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.jimmy.hospitalsapp.R;

public class Register_PatientAct extends AppCompatActivity implements View.OnClickListener{

    private EditText etNamePat;
    private EditText etIdPat;
    private EditText etAge;
    private EditText etEps;
    private RadioButton rdBtnMan;
    private RadioButton rdBtnWoman;
    private RadioButton rdBtnOther;
    private Button btnAddPatient;
    private BeginActivity bgActivity;
    private String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__patient);

        etNamePat = (EditText) findViewById(R.id.etNamePat);
        etIdPat = (EditText) findViewById(R.id.etIdPat);
        etAge = (EditText) findViewById(R.id.etAge);
        etEps = (EditText) findViewById(R.id.etEps);
        rdBtnMan = (RadioButton) findViewById(R.id.rdBtnMan);
        rdBtnWoman = (RadioButton) findViewById(R.id.rdBtnWoman);
        rdBtnOther = (RadioButton) findViewById(R.id.rdBtnOther);
        btnAddPatient = (Button) findViewById(R.id.btnAddPatient);

        rdBtnMan.setOnClickListener(this);
        rdBtnWoman.setOnClickListener(this);
        rdBtnOther.setOnClickListener(this);

        btnAddPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etNamePat.getText().length() > 0 && etIdPat.getText().length() > 0 && etAge.getText().length() > 0 && etEps.getText().length() > 0) {
                    if ( rdBtnMan.isActivated() == true || rdBtnWoman.isActivated() == true || rdBtnOther.isActivated() == true ) {
                        String name = etNamePat.getText().toString();
                        String id = etIdPat.getText().toString();
                        String age = etAge.getText().toString();
                        String eps = etEps.getText().toString();
                        if ( bgActivity.getMgApp().addPatient(name, id, Short.parseShort(age), gender, eps)) {

                            Intent addPatient = new Intent(Register_PatientAct.this, MenuActivity.class);
                            startActivity(addPatient);
                            onToastAdd();
                        }

                    } else {
                        onToast();
                    }
                } else {
                    onToast();
                }
            }
        });
    }

    public void onToast() {
        Toast toast = Toast.makeText(this, "Hay campos vacios o falta información", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onToastAdd() {
        Toast toast = Toast.makeText(this, "Paciente registrado", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }
}
