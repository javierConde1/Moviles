package com.example.javierconde.st;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Info_recycler_cliente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_recycler_cliente);

        Bundle bundle = getIntent().getExtras();

        String sNumOrden = bundle.get("orden").toString();
        String sEstado = bundle.get("estado").toString();
        String sFecha = bundle.get("fecha").toString();
        String sPrioridad = bundle.get("prioridad").toString();

        getSupportActionBar().setTitle("Orden No. " + sNumOrden);
    }
}
