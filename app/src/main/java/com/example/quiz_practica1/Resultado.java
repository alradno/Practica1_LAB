package com.example.quiz_practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    int puntosPartida;
    TextView numPuntosTextView;
    Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        //Get puntosPartida from MainActivity
        puntosPartida = getIntent().getIntExtra("puntosPartida", 0);

        if(puntosPartida < 0){
            puntosPartida = 0;
        }

        numPuntosTextView = findViewById(R.id.numPuntosText);
        numPuntosTextView.setText("Puntos: " + puntosPartida);

        //Boton volver
        volver = findViewById(R.id.volverButton);

        volver.setOnClickListener(v -> {
            //Volver a MainActivity
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            //Cerrar esta activity
            finish();
        });

        //Boton salir
        Button salir = findViewById(R.id.salirPuntuacion);
        salir.setOnClickListener(v -> {
            //Cerrar la app
            finishAffinity();
        });
    }
}