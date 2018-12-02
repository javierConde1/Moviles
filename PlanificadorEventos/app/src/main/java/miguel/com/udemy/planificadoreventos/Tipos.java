package miguel.com.udemy.planificadoreventos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Tipos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipos);

        getSupportActionBar().setTitle("Selecciona un evento");
    }
}
