package com.jimmy.hospitalsapp.activities;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.jimmy.hospitalsapp.R;
import com.jimmy.hospitalsapp.logic.Appointment;
import com.jimmy.hospitalsapp.logic.Doctor;
import com.jimmy.hospitalsapp.logic.ManagementApp;
import com.jimmy.hospitalsapp.logic.Patient;
import com.jimmy.hospitalsapp.serialization.SerializacionApp;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity
        implements OnNavigationItemSelectedListener {

    private ImageButton btnRgPatient;
    private ImageButton btnRgDoctor;
    private ImageButton btnRgAppointment;
    private FloatingActionButton save;
    private View inf;
    private View settings;
    private SerializacionApp serial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Menú");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.save);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        serial = new SerializacionApp(this, "app.dat");
        btnRgPatient = (ImageButton) findViewById(R.id.btnRgPatient);
        btnRgDoctor = (ImageButton) findViewById(R.id.btnRgDoctor);
        btnRgAppointment = (ImageButton) findViewById(R.id.btnRgAppointment);
        save = (FloatingActionButton) findViewById(R.id.save);

        open();

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

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //save();
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            onAlertDialogInfo();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            onAlertDialogFindPatient();
        } else if (id == R.id.nav_gallery) {
            onAlertDialogFindDoctor();
        } else if (id == R.id.nav_inf) {
            onAlertDialog();
        } else if (id == R.id.nav_thanks) {
            onAlertDialogThanks();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onAlertDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Acerca de");
        alertDialog.setMessage("Aplicación desarrollada por:\nSergio Andrés Rojas León\n201520089\n" +
                "\nJimmy Alejandro Plazas López\n201520048\n\nEscuela Ingeniería de Sistemas y Computación.");
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alertDialog.show();
    }

    public void onAlertDialogInfo() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Infromación");
        alertDialog.setMessage("HOSPITAL SApp\nversión 1.0.0");
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alertDialog.show();
    }

    public void onAlertDialogThanks() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Agradecimientos");
        alertDialog.setMessage("- Jairo Riaño.\n- Jahir Fiquitiva.");
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alertDialog.show();
    }

    @SuppressLint("InflateParams")
    public void onAlertDialogFindPatient() {

        View content = LayoutInflater.from(this).inflate(R.layout.find_patient, null, false);

        final EditText findPatient = (EditText) content.findViewById(R.id.etFindPatient);

        AlertDialog loginPrompt = new AlertDialog.Builder(this).setTitle("Información de paciente")
                .setView(content).create();

        loginPrompt.setButton(DialogInterface.BUTTON_POSITIVE, "Buscar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                onAlertDialogInfPatient(findPatient.getText().toString());
            }
        });
        loginPrompt.show();
    }

    public void onAlertDialogInfPatient(String idPatient) {
        if (!ManagementApp.findPatient(idPatient)) {
            ArrayList<Appointment> appointmentAux = ManagementApp.getMgAppointments().getAppointments();
            Patient patAux = ManagementApp.findInfoPatient(idPatient);
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Información de paciente");
            String name = patAux.getName();
            String id = patAux.getId();
            short age = patAux.getAge();
            String gender = patAux.getGender();
            String eps = patAux.getEps();
            String message = "Nombre: " + name + "\nId: " + id + "\nEdad: " + age + "\nGenero: " + gender + "\nEps: " + eps+"\n\nCitas: ";
            for(int i = 0; i < appointmentAux.size(); i++) {
                if(appointmentAux.get(i).getIdPatient().equals(id)) {
                    message = message + "\nDoctor: "+ManagementApp.findDoctor(appointmentAux.get(i).getTjDoctor()).getName()+""+
                            "\nEspecializado en "+ManagementApp.findDoctor(appointmentAux.get(i).getTjDoctor()).getSpecialization()+"" +
                            "\nFecha: "+appointmentAux.get(i).getDate()+"\nHora: "+appointmentAux.get(i).getHour()+"\n\n";
                }
            }
            alertDialog.setMessage(message);
            alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Volver", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            alertDialog.show();
        } else {
            errorPatient();
        }
    }

    public void errorPatient() {
        Toast toast = Toast.makeText(this, "El paciente no existe", Toast.LENGTH_SHORT);
        toast.show();
    }

    @SuppressLint("InflateParams")
    public void onAlertDialogFindDoctor() {

        View content = LayoutInflater.from(this).inflate(R.layout.find_doctor, null, false);

        final EditText findDoctor = (EditText) content.findViewById(R.id.etFindDoctor);

        AlertDialog loginPrompt = new AlertDialog.Builder(this).setTitle("Información de doctor")
                .setView(content).create();

        loginPrompt.setButton(DialogInterface.BUTTON_POSITIVE, "Buscar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                onAlertDialogInfDoc(findDoctor.getText().toString());
            }
        });
        loginPrompt.show();
    }

    public void onAlertDialogInfDoc(String tjDoctor) {
        if (!ManagementApp.validateDoctor(tjDoctor)) {
            ArrayList<Appointment> appointmentAux = ManagementApp.getMgAppointments().getAppointments();
            Doctor docAux = ManagementApp.findDoctor(tjDoctor);
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Información de doctor");
            String name = docAux.getName();
            String tj = docAux.getId();
            String esp = docAux.getSpecialization();
            String message = "Nombre: " + name + "\nN° Tarjeta profesional: " + tj + "\nEspecializado en " + esp+"\n\nCitas: ";
            for(int i = 0; i < appointmentAux.size(); i++) {
                if(appointmentAux.get(i).getTjDoctor().equals(tj)) {
                    message = message + "\nPaciente: "+ManagementApp.findInfoPatient(appointmentAux.get(i).getIdPatient()).getName()+"" +
                            "\nFecha: "+appointmentAux.get(i).getDate()+"\nHora: "+appointmentAux.get(i).getHour()+"\n\n";
                }
            }
            alertDialog.setMessage(message);
            alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Volver", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            alertDialog.show();
        } else {
            errorDoctor();
        }
    }

    public void errorDoctor() {
        Toast toast = Toast.makeText(this, "El doctor no existe", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onToastSaved() {
        Toast toast = Toast.makeText(this, "Se guardaron los datos", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onToastLoad() {
        Toast toast = Toast.makeText(this, "Se cargaron los datos", Toast.LENGTH_SHORT);
        toast.show();
    }

    private void open(){
        serial.open();
        ManagementApp mgApp1= serial.readerSerializable();

        ManagementApp.setMgAppointment(mgApp1.getMgAppointment());
        ManagementApp.setMgDoc(mgApp1.getMgDoc());
        ManagementApp.setMgPatient(mgApp1.getMgPatient());
        ManagementApp.setMgUser(mgApp1.getMgUser());
        onToastLoad();
    }

    public void save(){
        serial.open();
        serial.writeSerializable(ManagementApp.get());
        onToastSaved();
    }

    @Override
    protected void onDestroy(){
      super.onDestroy();
        save();
        finish();
    }

}
