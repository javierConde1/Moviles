package com.example.javierconde.eva3_11_broadcastreceiver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class Servicio extends Service {
    Thread tHilo;
    Intent inBrodcast;

    public Servicio() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        inBrodcast = new Intent("SERVICIO");
        inBrodcast.putExtra("MENSAJE","servicio creado ");
        sendBroadcast(inBrodcast);
    }

    @Override
    public void onStart(final Intent intent, int startId) {
        super.onStart(intent, startId);
        Runnable rnHilo = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        Toast.makeText(getApplicationContext(),"Iniciando", Toast.LENGTH_SHORT).show();
                        inBrodcast = new Intent("SERVICIO");
                        inBrodcast.putExtra("MENSAJE","Servicio iniciado ");
                        sendBroadcast(inBrodcast);
                        }catch (InterruptedException e) {
                            e.printStackTrace();
                            break;
                    }
                }
            }
        };
        tHilo = new Thread(rnHilo);
        tHilo.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        inBrodcast = new Intent("SERVICIO");
        inBrodcast.putExtra("MENSAJE","Servicio Destruido ");
        sendBroadcast(inBrodcast);

        tHilo.interrupt();
    }
}
