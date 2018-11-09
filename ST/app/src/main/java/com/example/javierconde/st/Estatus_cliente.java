package com.example.javierconde.st;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Estatus_cliente extends AppCompatActivity {
    TextView txtPrueba;
    Intent inMostrar;
    Intent inSalir;
    private String url =
            "https://javier-conde101.000webhostapp.com/Login.php";
    private RecyclerView mList;
    private DividerItemDecoration dividerItemDecoration;
    private LinearLayoutManager linearLayoutManager;
    private List<Listado_cliente> cultivoList;
    private RecyclerView.Adapter adapter;
    //RecyclerView rcView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estatus_cliente);
        mList = findViewById(R.id.main_list);
        cultivoList = new ArrayList<>();
        adapter = new Listado_adapter(getApplicationContext(), cultivoList);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList.getContext(),
                linearLayoutManager.getOrientation());
        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(adapter);
        getData();
        /*txtPrueba = findViewById(R.id.txtPrueba);
        //rcView = findViewById(R.id.rcView);

        /*LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcView.setLayoutManager(linearLayoutManager);*/


        /*mAdapter = new MyAdapter(myDataset);
        rcView.setAdapter(mAdapter);

        inMostrar = getIntent();
        Bundle bDatos = inMostrar.getExtras();
        txtPrueba.append("El problema es:" + "\n");
        if(bDatos.getBoolean("PILA")){
            txtPrueba.append(" Pila" + "\n");
        }if(bDatos.getBoolean("BATERIA")){
            txtPrueba.append(" Bateria" + "\n");
        }if(bDatos.getBoolean("CONTRA")){
            txtPrueba.append(" Contra chapa" + "\n");
        }if(bDatos.getBoolean("CERCA")){
            txtPrueba.append(" Cerca" + "\n");
        }if(bDatos.getBoolean("CEREBRO")){
            txtPrueba.append(" Cerebro" + "\n");
        }if(bDatos.getBoolean("CABLEADO")){
            txtPrueba.append(" Cableado" + "\n");
        }if(bDatos.getBoolean("SENSORES")){
            txtPrueba.append(" Sensores");
        }
        txtPrueba.append("La descripcion es:" + "\n");
        txtPrueba.append(bDatos.getString("DESCRIPCION"));
        */
        // mList.setAdapter(adapter);
        inSalir = new Intent(this,Menu_cliente.class);
        //Toast.makeText(this,"pendejo", Toast.LENGTH_SHORT).show();


    }
    private void getData(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Cargando ...");
        progressDialog.show();
        JsonArrayRequest jsonArrayRequest =
                new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++){
                            try {
                                JSONObject jsonObject = response.getJSONObject(i) ;
                                Listado_cliente listado_cliente = new Listado_cliente();
                                listado_cliente.setNo_orden(jsonObject.getInt("orden"));
                                listado_cliente.setEstado(jsonObject.getString("estado"));
                                listado_cliente.setFecha(jsonObject.getString("fecha"));
                                listado_cliente.setPrioridad(jsonObject.getString("prioridad"));
                                listado_cliente.setDomicilio(jsonObject.getString("domicilio"));
                                cultivoList.add(listado_cliente);
                                /*Toast.makeText(getApplicationContext(), cultivo.getNo_orden(),
                                        Toast.LENGTH_LONG).show();*/
                            }
                            catch (JSONException e){
                                e.printStackTrace();
                                progressDialog.dismiss();
                            }
                        }adapter.notifyDataSetChanged();
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", error.toString());
                        progressDialog.dismiss();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
        //Toast.makeText(getApplicationContext(), cultivoList.toString(),
                //Toast.LENGTH_LONG).show();
        /*Toast.makeText(getApplicationContext(), String.valueOf(cultivoList.size()),
                Toast.LENGTH_LONG).show();*/
    }

    public void Salir(View view) {
        startActivity(inSalir);
        finish();
    }
}