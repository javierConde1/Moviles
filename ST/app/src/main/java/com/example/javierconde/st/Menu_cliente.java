package com.example.javierconde.st;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Menu_cliente extends AppCompatActivity {

    private TextView txtNumCliente, txtNomCliente, txtApePat, txtApeMat;
    private Button btnSalirCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cliente);

        btnSalirCliente = findViewById(R.id.btnSalirCliente);

        btnSalirCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu_cliente.this, Principal.class);
                startActivity(intent);

            }
        });


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