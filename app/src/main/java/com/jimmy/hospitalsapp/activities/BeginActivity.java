package com.jimmy.hospitalsapp.activities;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.jimmy.hospitalsapp.R;
import com.jimmy.hospitalsapp.logic.ManagementApp;
import com.jimmy.hospitalsapp.serialization.SerializacionApp;

public class BeginActivity extends AppCompatActivity {

    private EditText etUserName;
    private EditText etPassword;
    private ImageButton btnLogin;
    private ManagementApp mgApp;
    private int cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);

        mgApp = new ManagementApp(this);
        cont = 1;
        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (ImageButton) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etUserName.getText().length() > 0 && etPassword.getText().length() > 0) {
                    if (cont == 3) {
                        finish();
                    }
                    if(cont == 2) {
                        onToastError();
                    }
                    if (ManagementApp.validateUser(etUserName.getText().toString(), etPassword.getText().toString())) {
                        onToastBegin(etUserName.getText().toString());
                        Intent login = new Intent(BeginActivity.this, MenuActivity.class);
                        startActivity(login);
                    } else {
                        onAlertDialog();
                        cont = cont+1;
                    }
                } else {
                    onToast();
                }
            }
        });
    }

    public void onAlertDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Error");
        alertDialog.setMessage("El usuario y/o la contraseña son incorrectos");
        alertDialog.show();
    }

    public void onToastError() {
        Toast toast = Toast.makeText(this, "Queda 1 intento o se cerrará la aplicación", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onToast() {
        Toast toast = Toast.makeText(this, "Hay campos vacios", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onToastBegin(String nameUser) {
        Toast toast = Toast.makeText(this, "Bienvenido "+nameUser, Toast.LENGTH_SHORT);
        toast.show();
    }

}

