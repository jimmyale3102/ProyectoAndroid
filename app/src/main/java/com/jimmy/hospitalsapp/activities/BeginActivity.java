package com.jimmy.hospitalsapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.jimmy.hospitalsapp.R;
import com.jimmy.hospitalsapp.logic.ManagementUser;

public class BeginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);

        EditText etUserName = (EditText) findViewById(R.id.etUserName);
        ImageButton btnLogin = (ImageButton) findViewById(R.id.btnLogin);
        ManagementUser mgUser = new ManagementUser(this);
        EditText etRegistrer = (EditText) findViewById(R.id.etRegistrer);

        etRegistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mgUser.validateUserName(etUserName.getText())) {
                    Intent intent = new Intent(BeginActivity.this, RegisterActivity.class);
                    startActivity(intent);
                }

            }
        });
    }

}
