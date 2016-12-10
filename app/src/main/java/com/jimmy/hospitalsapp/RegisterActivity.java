package com.jimmy.hospitalsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText etUserName = (EditText) findViewById(R.id.etUserName);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button btnRegister = (Button) findViewById(R.id.btnRegister);

    }
}
