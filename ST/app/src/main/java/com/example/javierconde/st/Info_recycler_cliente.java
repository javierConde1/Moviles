package com.example.javierconde.st;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Info_recycler_cliente extends AppCompatActivity {

    private TextView txtProblema, txtFecha, txtFechaProg, txtTecnico, txtEstatus, txtPrioridad;
    private Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_recycler_cliente);

        txtProblema = findViewById(R.id.textViewProblema2);
        txtFecha = findViewById(R.id.textViewFecha2);
        txtFechaProg = findViewById(R.id.textViewFechaProg2);
        txtTecnico = findViewById(R.id.textViewTecnico2);
        txtEstatus = findViewById(R.id.textViewEstatus2);
        txtPrioridad = findViewById(R.id.textViewPrioridad2);
        btnRegresar = findViewById(R.id.btnRegresar);

        Bundle bundle = getIntent().getExtras();

        String sNumOrden = bundle.get("orden").toString();
        String sEstado = bundle.get("estado").toString();
        String sFecha = bundle.get("fecha").toString();
        String sPrioridad = bundle.get("prioridad").toString();

        getSupportActionBar().setTitle("Orden No. " + sNumOrden);

        switch(sPrioridad){
            case "baja":
                sPrioridad = "Baja";
                break;
            case "media":
                sPrioridad = "Media";
                break;
            case "alta":
                sPrioridad = "Alta";
                break;
        }

        switch(sEstado){
            case "pendiente":
                sEstado = "Pendiente";
                break;
            case "finalizada":
                sEstado = "Finalizada";
                break;
        }

        txtEstatus.setText(sEstado);
        txtFecha.setText(sFecha);
        txtPrioridad.setText(sPrioridad);

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Info_recycler_cliente.this, Estatus_cliente.class);
                startActivity(intent);
            }
        });
    }
}
