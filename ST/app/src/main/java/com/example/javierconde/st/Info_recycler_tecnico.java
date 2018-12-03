package com.example.javierconde.st;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;



public class Info_recycler_tecnico extends AppCompatActivity {

    private TextView txtNoCliente, txtProblema, txtFecha, txtFechaProg, txtPrioridad, txtDomicilio,txtDescripcion;
    private Button btnRegresar;
    ProgressDialog pDialog;
    StringRequest stringRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_recycler_tecnico);

        txtNoCliente = findViewById(R.id.textViewNoCliente_Tecnico2);
        txtProblema  = findViewById(R.id.textViewProblema_Tecnico2);
        txtFecha = findViewById(R.id.textViewFecha_Tecnico2);
        txtFechaProg = findViewById(R.id.textViewFechaProg_Tecnico2);
        txtPrioridad = findViewById(R.id.textViewPrioridad_Tecnico2);
        txtDomicilio = findViewById(R.id.textViewDomicilio_Tecnico2);
        txtDescripcion = findViewById(R.id.textViewDescripcion_Tecnico2);

        btnRegresar = findViewById(R.id.btnRegresar30);

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
                finish();
            }
        });
    }


}
