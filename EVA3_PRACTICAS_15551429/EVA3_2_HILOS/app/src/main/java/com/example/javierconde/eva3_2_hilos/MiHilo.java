package com.example.javierconde.eva3_2_hilos;

import android.util.Log;

public class MiHilo extends Thread {
    @Override
    public void run() {
        super.run();
        while (true){
            try{
                Log.wtf("Hilo", "Hola");
                Thread.sleep(500);
            }catch (Exception e){
                e.getStackTrace();
            }
        }
    }
}
