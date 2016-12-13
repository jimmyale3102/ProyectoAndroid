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

public class BeginActivity extends AppCompatActivity {

    private EditText etUserName;
    private EditText etPassword;
    private ImageButton btnLogin;
    private TextView tvRegistrer;
    private ManagementApp mgApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);

        mgApp = new ManagementApp(this);

        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (ImageButton) findViewById(R.id.btnLogin);
        tvRegistrer = (TextView) findViewById(R.id.tvRegistrer);

        tvRegistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registrer = new Intent(BeginActivity.this, Register_DoctorAct.class);
                startActivity(registrer);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etUserName.getText().length() > 0 && etPassword.getText().length() > 0) {
                    if (ManagementApp.validateUser(etUserName.getText().toString(), etPassword.getText().toString())) {
                        Intent login = new Intent(BeginActivity.this, MenuActivity.class);
                        startActivity(login);
                    } else {
                        onAlertDialog();
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

    public void onToast() {
        Toast toast = Toast.makeText(this, "Hay campos vacios", Toast.LENGTH_SHORT);
        toast.show();
    }

}

