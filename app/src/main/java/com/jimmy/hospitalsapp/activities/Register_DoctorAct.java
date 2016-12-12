package com.jimmy.hospitalsapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.jimmy.hospitalsapp.R;
import com.jimmy.hospitalsapp.logic.ManagementApp;

public class Register_DoctorAct extends AppCompatActivity {

    private EditText namedoc;
    private EditText iddoc;
    private Spinner spinner2;
    private Button btnaddDoc;
    private String docname;
    private String docid;
    private String espci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__doctor);

        namedoc = (EditText) findViewById(R.id.namedoc);
        iddoc = (EditText) findViewById(R.id.iddoc);
        btnaddDoc = (Button)findViewById(R.id.btnaddApp);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        logindatos();

        btnaddDoc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
            if(namedoc.getText().length()>0  && iddoc.getText().length()>0 ){

                docname = namedoc.getText().toString();
                docid= iddoc.getText().toString();
                espci = "";

                if(ManagementApp.addDoctor(docname,docid,espci)){

                    Intent addDoct = new Intent(Register_DoctorAct.this, MenuActivity.class);
                    startActivity(addDoct);
                    onToastAdd();
                }

            }else {onToast();}

            }
        });

    }

    public void logindatos(){
        String [] datosspe = {"Neurologo","Pediatra","Cardiologo"};
        ArrayAdapter<String> datosadap= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,datosspe);
        spinner2.setAdapter(datosadap);

        //spinner2.setOnItemSelectedListener(new);
    }

    public void onToast(){
        Toast toast = Toast.makeText(this,"Hay campos vacias o Falta información",Toast.LENGTH_SHORT);
        toast.show();

    }

    public void onToastAdd(){
        Toast.makeText(this, "Doctor Registrado", Toast.LENGTH_SHORT).show();
    }


}

