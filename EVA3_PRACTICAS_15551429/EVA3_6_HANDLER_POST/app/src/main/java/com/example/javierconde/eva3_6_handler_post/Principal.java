package com.example.javierconde.eva3_6_handler_post;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class  Principal extends AppCompatActivity {
    Handler hManejador = new Handler();
    TextView txtNumero;
    //RUNNEABLE 1 --> TRABAJO PESADIO EN SEGUNDO PLANO
    Runnable rSegundoplano = new Runnable() {
        @Override
        public void run() {
            while (true) {
                hManejador.post(rLigero);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    int iNum = 1;
//RUNNABLE 2 --> TRABAJO LIGERO Y TRANAJO EN LA UI
    Runnable rLigero = new Runnable() {
    @Override
    public void run() {
            txtNumero.append((iNum++) + " - ");
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Thread tHilo = new Thread(rSegundoplano);
        tHilo.start();
        txtNumero = findViewById(R.id.txtNumero);
    }
}
