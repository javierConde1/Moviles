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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estatus_cliente);
        mList = findViewById(R.id.main_list);
        cultivoList = new ArrayList<>();
        adapter = new Listado_adapter(getApplicationContext(), cultivoList, new Listado_adapter.OnItemClickListener() {
            @Override
            public void onItemClick(Listado_cliente list, int position) {
               Intent intent = new Intent(Estatus_cliente.this, Info_recycler_cliente.class);
               intent.putExtra("orden",list.getNo_orden());
               intent.putExtra("estado",list.getEstado());
               intent.putExtra("fecha",list.getFecha());
               intent.putExtra("prioridad",list.getPrioridad());
               startActivity(intent);
            }
        });
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList.getContext(),
                linearLayoutManager.getOrientation());
        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(adapter);
        getData();

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
        //startActivity(inSalir);
        finish();
    }
}