package miguel.com.udemy.planificadoreventos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Listado extends AppCompatActivity {

    private Button btnPrueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        btnPrueba = findViewById(R.id.btnPrueba);

        getSupportActionBar().setTitle("Boda");

        btnPrueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Listado.this, Tipos.class);
                startActivity(intent);
            }
        });
    }
}
