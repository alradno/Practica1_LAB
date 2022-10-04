package com.example.quiz_practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button boton;
    int puntosPartida = 0;
    ArrayList<Pregunta> preguntas = new ArrayList<>();
    ArrayList<Pregunta> respuestas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anadirPreguntas();
        anadirRespuestas();
        Button botonCorrecto = findViewById(R.id.Respuesta1Button);
        colocarBotonCorrecto(botonCorrecto);
        //Cambiar texto del boton
        //boton = findViewById(R.id.Respuesta1Button);
        //boton.setText("Respuesta 1");
        boton = findViewById(R.id.Respuesta2Button);
        boton.setText("Respuesta 2");
        boton = findViewById(R.id.Respuesta3Button);
        boton.setText("Respuesta 3");
        boton = findViewById(R.id.Respuesta4Button);
        boton.setText("Respuesta 4");

    }

    public void anadirPreguntas(){
        Pregunta pregunta = new Pregunta("¿Cual es la capital de España?", "Madrid");
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Francia?", "Paris");
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Italia?", "Roma");
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Portugal?", "Lisboa");
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Alemania?", "Berlin");
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Inglaterra?", "Londres");
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Grecia?", "Atenas");
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Corea?", "Seul");
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de China?", "Pekin");
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Japon?", "Tokio");
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la pelicula mas taquillera de la historia?", "Avatar");
    }

    public void anadirRespuestas(){
        ArrayList<Pregunta> respuestas = new ArrayList<>();
        //Pregunta random
        int random = (int) (Math.random() * preguntas.size());
        //Respuesta correcta
        respuestas.add(preguntas.get(random));
        //Respuestas incorrectas 3
        for (int i = 0; i < 2; i++) {
            random = (int) (Math.random() * preguntas.size());
            respuestas.add(preguntas.get(random));
        }
        this.respuestas = respuestas;

    }

    public void colocarBotonCorrecto(Button boton){
        //Numero random de 0 a 3
        int posicionBotonCorrecto = (int) (Math.random() * 4);
        switch (posicionBotonCorrecto){
            case 0:
                boton.setText(preguntas.get(0).getPregunta());
                break;
            case 1:
                boton.setText(preguntas.get(0).getPregunta());
                break;
            case 2:
                boton.setText(preguntas.get(0).getPregunta());
                break;
            case 3:
                boton.setText(preguntas.get(0).getPregunta());
                break;
        }
    }

}