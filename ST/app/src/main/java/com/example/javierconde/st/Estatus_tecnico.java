package com.example.javierconde.st;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

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

public class Estatus_tecnico extends AppCompatActivity {
    TextView txtPrueba;
    Intent inMostrar;
    Intent inSalir;
    private String url =
            "https://javier-conde101.000webhostapp.com/Login.php";
    private RecyclerView mList;
    private DividerItemDecoration dividerItemDecorationTec;
    private LinearLayoutManager linearLayoutManager;
    private List<Listado_tecnico> cultivoList;
    private RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estatus_tecnico);
        mList = findViewById(R.id.main_list);
        cultivoList = new ArrayList<>();
        adapter = new Listado_tecnico_adapter(getApplicationContext(), cultivoList);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecorationTec = new DividerItemDecoration(mList.getContext(),
                linearLayoutManager.getOrientation());
        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecorationTec);
        mList.setAdapter(adapter);
        getData();

        inSalir = new Intent(this,Menu_tecnico.class);
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
                                Listado_tecnico listado_tecnico = new Listado_tecnico();
                                listado_tecnico.setNo_orden(jsonObject.getInt("orden"));
                                listado_tecnico.setEstado(jsonObject.getString("estado"));
                                listado_tecnico.setFecha(jsonObject.getString("fecha"));
                                listado_tecnico.setPrioridad(jsonObject.getString("prioridad"));
                                listado_tecnico.setDomicilio(jsonObject.getString("domicilio"));
                                cultivoList.add(listado_tecnico);
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
        /*Toast.makeText(getApplicationContext(), cultivoList.toString(),
        Toast.LENGTH_LONG).show();x|
        /*Toast.makeText(getApplicationContext(), String.valueOf(cultivoList.size()),
                Toast.LENGTH_LONG).show();*/
    }

    public void Salir(View view) {
        startActivity(inSalir);
        finish();
    }
}
