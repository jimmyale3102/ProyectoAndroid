package com.jimmy.hospitalsapp.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.jimmy.hospitalsapp.R;
import com.jimmy.hospitalsapp.logic.ManagementApp;

public class Register_PatientAct extends AppCompatActivity implements View.OnClickListener {

    private EditText etNamePat;
    private EditText etIdPat;
    private EditText etAge;
    private Spinner spnEps;
    private RadioButton rdBtnMan;
    private RadioButton rdBtnWoman;
    private RadioButton rdBtnOther;
    private String eps = "";
    private String name = "";
    private String id = "";
    private String age = "";
    private String gender = "";
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__patient);

        context = this;
        etNamePat = (EditText) findViewById(R.id.etNamePat);
        etIdPat = (EditText) findViewById(R.id.etIdPat);
        etAge = (EditText) findViewById(R.id.etAge);
        spnEps = (Spinner) findViewById(R.id.spnEps);
        rdBtnMan = (RadioButton) findViewById(R.id.rdBtnMan);
        rdBtnWoman = (RadioButton) findViewById(R.id.rdBtnWoman);
        rdBtnOther = (RadioButton) findViewById(R.id.rdBtnOther);
        Button btnAddPatient = (Button) findViewById(R.id.btnAddPatient);

        rdBtnMan.setOnClickListener(this);
        rdBtnWoman.setOnClickListener(this);
        rdBtnOther.setOnClickListener(this);

        btnAddPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etNamePat.getText().length() > 0 && etIdPat.getText().length() > 0 && etAge.getText().length() > 0 && spnEps.toString().length() > 0)
                    if (gender.length() > 0) {
                        name = etNamePat.getText().toString();
                        id = etIdPat.getText().toString();
                        age = etAge.getText().toString();
                        eps = spnEps.getSelectedItem().toString();
                        if (ManagementApp.addPatient(name, id, Short.parseShort(age), gender, eps)) {
                            onAlertDialog();
                        } else {
                            onToastAdd();
                        }

                    } else {
                        onToast();
                    }
                else {
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
        Toast toast = Toast.makeText(this, "El paciente ya existe", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.rdBtnMan:
                rdBtnWoman.setChecked(false);
                rdBtnOther.setChecked(false);
                gender = rdBtnMan.getText().toString();
                break;
            case R.id.rdBtnWoman:
                rdBtnMan.setChecked(false);
                rdBtnOther.setChecked(false);
                gender = rdBtnWoman.getText().toString();
                break;
            case R.id.rdBtnOther:
                rdBtnWoman.setChecked(false);
                rdBtnMan.setChecked(false);
                gender = rdBtnOther.getText().toString();
                break;
        }
    }

    public void onAlertDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("¡Exito!");
        alertDialog.setMessage("El paciente se registró correctamente");
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alertDialog.show();
    }

}
