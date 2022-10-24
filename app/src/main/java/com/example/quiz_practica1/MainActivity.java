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
        //Muestra la flecha de atrás en la barra de navegación
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Log.i("Inicio de la app", "App iniciada");

        int id = getResources().getIdentifier("sagrada_familia", "drawable", getPackageName());
    }

    public void onRadioButtonClicked(View view) {
        Log.i("radioButtonPulsado", "Pulsado");
    }


}