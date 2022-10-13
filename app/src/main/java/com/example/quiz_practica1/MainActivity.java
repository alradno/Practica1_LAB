package com.example.quiz_practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    //static int numpreguntas;
    //static int puntosPartida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Inicio de la app", "Inicio de la app");

        /*Jugar partida = new Jugar();

        ArrayList<Pregunta> restoPreguntas = partida.anadirPreguntasYRespuestas();


        //Numero aleatorio de 0 o 1
        //int estiloPregunta = (int) (Math.random() * 2);
        int estiloPregunta = 0;


        if (estiloPregunta == 0) {
            //Pasar restopreguntas a TextViewPreguntas
            Intent intent = new Intent(this, TextViewPreguntas.class);
            numpreguntas = intent.getIntExtra("numpreguntas", 10);
            intent.putExtra("restoPreguntas", restoPreguntas);
            //Pasar puntosPartida a TextViewPreguntas
            intent.putExtra("puntosPartida", puntosPartida);
            Log.i("PuntosPartidaMain", String.valueOf(puntosPartida));
            startActivity(intent);

        } else if (estiloPregunta == 1) {
            //Preguntas de tipo RadioButton
            //Intent intent = new Intent(this, RadioButtonPreguntas.class);
            //startActivity(intent);


        Log.i("numpreguntas", String.valueOf(numpreguntas));
        }
        else{
            //Pasar a la pantalla de resultados
            Intent intent2 = new Intent(this, Resultado.class);
            intent2.putExtra("puntosPartida", puntosPartida);
            startActivity(intent2);
        }

        //Las preguntas de distintos tipos se tienen que intercalar
        //Preguntas de tipo TextView
        //Preguntas de tipo RadioButton
        //Cada activity que devuelva resultado de correcto o fallo
        //La puntuacion se va calculando en el main activity

    */
    }
    public void onRadioButtonClicked(View view) {
        Log.i("radioButtonPulsado", "Pulsado");
    }


}