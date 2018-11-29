package com.example.javierconde.st;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Info_recycler_tecnico extends AppCompatActivity {

    private TextView txtNoCliente, txtProblema, txtFecha, txtFechaProg, txtPrioridad, txtDomicilio,txtDescripcion;
    private Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_recycler_tecnico);

        txtNoCliente = findViewById(R.id.textViewNoCliente_Tecnico2);
        txtProblema  = findViewById(R.id.textViewPrioridad_Tecnico2);
        txtFecha = findViewById(R.id.textViewFecha_Tecnico2);
        txtFechaProg = findViewById(R.id.textViewFechaProg_Tecnico2);
        txtPrioridad = findViewById(R.id.textViewPrioridad_Tecnico2);
        txtDomicilio = findViewById(R.id.textViewDomicilio_Tecnico2);
        txtDescripcion = findViewById(R.id.textViewDescripcion_Tecnico2);

        btnRegresar = findViewById(R.id.btnRegresar);

        //GIT

        Bundle bundle = getIntent().getExtras();

        String sNumOrden = bundle.get("orden").toString();
        String sFecha = bundle.get("fecha").toString();
        String sPrioridad = bundle.get("prioridad").toString();
        String sDomicilio = bundle.get("domicilio").toString();
        String sProblema = bundle.get("problema").toString();
        String sDesc = bundle.get("sdec").toString();
        String sFechaProg = bundle.get("fechaprog").toString();
        String sNumCliente = bundle.get("cliente").toString();

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

        txtNoCliente.setText(sNumCliente);
        txtFecha.setText(sFecha);
        txtPrioridad.setText(sPrioridad);
        txtDomicilio.setText(sDomicilio);
        txtProblema.setText(sProblema);
        txtDescripcion.setText(sDesc);
        txtFechaProg.setText(sFechaProg);

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Info_recycler_tecnico.this, Estatus_tecnico.class);
                startActivity(intent);
            }
        });
    }
}
