package com.jimmy.hospitalsapp.activities;

import android.content.Context;
import android.content.Intent;
import android.inputmethodservice.KeyboardView;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.jimmy.hospitalsapp.R;

public class Register_PatientAct extends AppCompatActivity implements View.OnClickListener {

    private EditText etNamePat;
    private EditText etIdPat;
    private EditText etAge;
    private EditText etEps;
    private RadioButton rdBtnMan;
    private RadioButton rdBtnWoman;
    private RadioButton rdBtnOther;
    private BeginActivity bgActivity;
    private String eps = "";
    private String name = "";
    private String id = "";
    private String age = "";
    private String gender = "";


    private Context context;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__patient);

        context = this;
        etNamePat = (EditText) findViewById(R.id.etNamePat);
        etIdPat = (EditText) findViewById(R.id.etIdPat);
        etAge = (EditText) findViewById(R.id.etAge);
        etEps = (EditText) findViewById(R.id.etEps);
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
                if (etNamePat.getText().length() > 0 && etIdPat.getText().length() > 0 && etAge.getText().length() > 0 && etEps.getText().length() > 0) {
                    if (gender.length() > 0) {
                        name = etNamePat.getText().toString();
                        id = etIdPat.getText().toString();
                        age = etAge.getText().toString();
                        eps = etEps.getText().toString();
                        if (bgActivity.getMgApp().addPatient(name, id, Short.parseShort(age), gender, eps)) {

                            Intent addPatient = new Intent(context, MenuActivity.class);
                            startActivity(addPatient);
                        }

                    } else {
                        onToast();
                    }
                } else {
                    onToast();
                }
            }
        });
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void onToast() {
        Toast toast = Toast.makeText(this, "Hay campos vacios o falta información", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onToastAdd() {
        Toast toast = Toast.makeText(this, "Paciente Registrado", Toast.LENGTH_SHORT);
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

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Register_PatientAct Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
