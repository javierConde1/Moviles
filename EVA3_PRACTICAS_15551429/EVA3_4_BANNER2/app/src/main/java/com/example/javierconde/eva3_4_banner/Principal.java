package com.example.javierconde.eva3_4_banner;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class Principal extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    ImageView imImagen;
    int iImag = 1;
    SeekBar sbVel;
    int iProgreso;
    int iBarra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        imImagen = findViewById(R.id.imImagen);
        sbVel=findViewById(R.id.sbVel);

        sbVel.setOnSeekBarChangeListener(this);
        iProgreso = 2000;

        Banner b = new Banner();
        b.start();

    }
    Handler hdrManeja = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (iImag) {
                case 1:
                    imImagen.setImageResource(R.drawable.cloudy);
                    iImag++;
                    break;
                case 2:
                    imImagen.setImageResource(R.drawable.rainy);
                    iImag++;
                    break;
                case 3:
                    imImagen.setImageResource(R.drawable.sunny);
                    iImag++;
                    break;
                default:
                    imImagen.setImageResource(R.drawable.light_rain);
                    iImag = 1;
                    break;
            }

        }
    };

    @Override
    public void onProgressChanged(SeekBar seekBar, int iProg, boolean fromUser) {
        iBarra = iProg;
        switch (iBarra) {
            case 1:
                iProgreso = 900;
                break;
            case 2:
                iProgreso = 800;
                break;
            case 3:
                iProgreso = 700;
                break;
            case 4:
                iProgreso = 600;
                break;
            case 5:
                iProgreso = 500;
                break;
            case 6:
                iProgreso = 400;
                break;
            case 7:
                iProgreso = 300;
                break;
            case 8:
                iProgreso = 200;
                break;
            case 9:
                iProgreso = 100;
                break;

        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    class Banner extends Thread {
        @Override
        public void run() {
            super.run();
            while(true) {
                try {
                    Thread.sleep(iProgreso);
                    int i = 0;
                    Message msg = hdrManeja.obtainMessage(1, i);
                    hdrManeja.sendMessage(msg);
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
