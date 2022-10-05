package com.example.quiz_practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    int puntosPartida;
    TextView numPuntosTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        //Get puntosPartida from MainActivity
        puntosPartida = getIntent().getIntExtra("puntos", 0);

        if(puntosPartida < 0){
            puntosPartida = 0;
        }

        numPuntosTextView = findViewById(R.id.numPuntosText);
        numPuntosTextView.setText("Puntos: " + puntosPartida);
    }
}