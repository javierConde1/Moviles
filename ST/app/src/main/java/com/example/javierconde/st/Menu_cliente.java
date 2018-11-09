package com.example.javierconde.st;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu_cliente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cliente);
    }
    public void Estatus(View view) {
        Intent inEstatus;
        inEstatus =new Intent(this,Estatus_cliente.class);
        startActivity(inEstatus);
        finish();
    }

    public void Solicitar(View view) {
        Intent inSolicitar;
        inSolicitar = new Intent(this,Solicitar_cliente.class);
        startActivity(inSolicitar);
        finish();
    }
}