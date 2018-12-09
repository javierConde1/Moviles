package com.example.javierconde.eva3_1_threads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Principal extends AppCompatActivity {
//RUNNEABLE
    Runnable  rMiHiloRun = new Runnable() {
    @Override
    public void run() {
        for(int i = 0; i < 20; i++){
            Log.wtf("RUNNEABLE", i + "");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //RUNNEABLES (INTERFAZ) Y THREADS (CLASE)
        //MTODO RUN
        Thread tHilo = new Thread(rMiHiloRun);
        tHilo.start();
        MiHilo tMiHilo = new MiHilo();
        tMiHilo.start();
    }
    class MiHilo extends Thread{
        @Override
        public void run() {
            super.run();
            for(int i = 0; i < 20; i++){
                Log.wtf("THREAD", i + "");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
