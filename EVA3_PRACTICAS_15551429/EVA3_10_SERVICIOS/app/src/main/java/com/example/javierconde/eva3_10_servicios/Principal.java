package com.example.javierconde.eva3_10_servicios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
Intent inServicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        inServicio = new Intent(this,Servicio.class);
    }

    public void Crear(View view) {
        //Toast.makeText(getApplicationContext(),"Se creo el servicio",Toast.LENGTH_LONG).show();
        startService(inServicio);
    }

    public void Destruir(View view) {
        //Toast.makeText(getApplicationContext(),"Se destruyo el servicio",Toast.LENGTH_LONG).show();
        stopService(inServicio);
    }
}
