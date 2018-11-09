package com.example.javierconde.st;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class Solicitar_cliente extends AppCompatActivity {
    CheckBox cbx1, cbx2, cbx3, cbx4, cbx5, cbx6, cbx7;
    EditText et_desc;
    Intent inEstatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_cliente);

        cbx1 = findViewById(R.id.cbx1);
        cbx2 = findViewById(R.id.cbx2);
        cbx3 = findViewById(R.id.cbx3);
        cbx4 = findViewById(R.id.cbx4);
        cbx5 = findViewById(R.id.cbx5);
        cbx6 = findViewById(R.id.cbx6);
        cbx7 = findViewById(R.id.cbx7);
        et_desc = findViewById(R.id.et_desc);
        inEstatus = new Intent(this, Estatus_cliente.class);
    }
    public void solicitar(View view) {
        /*boolean bPila = cbx1.isChecked();
        boolean bBateria = cbx2.isChecked();
        boolean bContra = cbx3.isChecked();
        boolean bCerca = cbx4.isChecked();
        boolean bCerebro = cbx5.isChecked();
        boolean bCableado = cbx6.isChecked();
        boolean bSensores = cbx7.isChecked();
        String sDescripcion = et_desc.getText().toString();

        Bundle bBundle = new Bundle();
        bBundle.putBoolean("PILA",bPila);
        bBundle.putBoolean("BATERIA",bBateria);
        bBundle.putBoolean("CONTRA",bContra);
        bBundle.putBoolean("CERCA",bCerca);
        bBundle.putBoolean("CEREBRO",bCerebro);
        bBundle.putBoolean("CABLEADO",bCableado);
        bBundle.putBoolean("SENSORES",bSensores);
        bBundle.putString("DESCRIPCION", sDescripcion);

        inEstatus.putExtras(bBundle);*/
        startActivity(inEstatus);
    }

}
