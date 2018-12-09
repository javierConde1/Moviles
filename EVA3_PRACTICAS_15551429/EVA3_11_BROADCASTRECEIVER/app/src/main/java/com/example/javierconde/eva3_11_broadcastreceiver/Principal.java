package com.example.javierconde.eva3_11_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    Intent inServicio;
    BroadcastReceiver brBrodReciv;
    TextView lblMensa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        lblMensa = findViewById(R.id.lblMensa);
        inServicio = new Intent(this,Servicio.class);
        brBrodReciv = new MiBroadCast();
        IntentFilter ifFiltrarServicios = new IntentFilter("SERVICIO");
        registerReceiver(brBrodReciv,ifFiltrarServicios);


    }

    public void Iniciar(View v) {
        startService(inServicio);

    }

    public void Detener(View v) {
        stopService(inServicio);
    }

    class MiBroadCast extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            String datos = intent.getStringExtra("MENSAJE");
            lblMensa.append(datos);
        }
    }
}
