package com.example.javierconde.st;

import android.app.ProgressDialog;
import android.content.Intent;
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
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

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

        btnRegresar = findViewById(R.id.btnRegresar);

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

    public void Finalizar(View view) {
        pDialog=new ProgressDialog(this);
        pDialog.setMessage("Cargando...");
        pDialog.show();

        

        String u = "https://javier-conde101.000webhostapp.com/update.php";

        stringRequest=new StringRequest(Request.Method.POST, u, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                pDialog.hide();

                if (response.trim().equalsIgnoreCase("actualiza")){
                    // etiNombre.setText("");
                    //  txtDocumento.setText("");
                    //   etiProfesion.setText("");
                    Toast.makeText(Info_recycler_tecnico.this,"Se ha Actualizado con exito",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Info_recycler_tecnico.this,"No se ha Actualizado ",Toast.LENGTH_SHORT).show();
                    Log.i("RESPUESTA: ",""+response);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Info_recycler_tecnico.this,"No se ha podido conectar",Toast.LENGTH_SHORT).show();
                pDialog.hide();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                String estado ="finalizado";

                Map<String,String> parametros=new HashMap<>();
                parametros.put("estado",estado);

                return parametros;
            }
        };
        //request.add(stringRequest);
        VolleySingleton.getIntanciaVolley(this).addToRequestQueue(stringRequest);
    }

}
