package com.example.javierconde.eva2_examen_15551429;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Principal extends AppCompatActivity {
Intent inCapturar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        inCapturar = new Intent(this, Datos.class);
    }

    public void Capturar(View view) {
        startActivity(inCapturar);
    }
}
