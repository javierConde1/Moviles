package com.example.javierconde.eva3_2_hilos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
TextView txtHola;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtHola = findViewById(R.id.txtHola);
        Runnable rHilo =  new Runnable() {
            @Override
            public void run() {
                while (true){
                    try{
                        txtHola.setText("holi");
                    Thread.sleep(500);


                }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread tHilo = new Thread(rHilo);
        tHilo.start();
        MiHilo mhPerpetuo = new MiHilo();
        //mhPerpetuo.run(); //rabar la app
        mhPerpetuo.start(); // segundo plano
    }
}
