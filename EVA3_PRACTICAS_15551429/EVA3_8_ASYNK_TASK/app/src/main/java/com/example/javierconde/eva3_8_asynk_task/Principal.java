package com.example.javierconde.eva3_8_asynk_task;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
TextView txtConteo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtConteo = findViewById(R.id.txtConteo);
        MiClaseAsincrona maTareaAsin = new MiClaseAsincrona();
        maTareaAsin.execute(100);
    }
    class MiClaseAsincrona extends AsyncTask<Integer, Integer,Void>{
        String sCade;
        int i = 1;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            txtConteo.setText(sCade + " Iniciando la tarea asincrona");
            //unico metodo que no se comunica con la interfaz grafica
        }
        @Override
        protected Void doInBackground(Integer... integers) {
            //sCade = strings[0] + " " + strings[1];
            i = integers[0];
            while(true){
                try{
                    Thread.sleep(1000);
                    publishProgress(i++);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            txtConteo.append(i + " - ");
        }
    }
}
