package com.example.quiz_practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity {

    Button respuesta1Button;
    Button respuesta2Button;
    Button respuesta3Button;
    Button respuesta4Button;

    Pregunta pregunta;

    TextView preguntaTextView;
    int puntosPartida = 0;
    ArrayList<Pregunta> preguntas = new ArrayList<>();
    ArrayList<Pregunta> restoPreguntas = new ArrayList<>();
    Pregunta preguntaCorrecta;
    int numBotonCorrecto;
    int numpreguntas = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        respuesta1Button = findViewById(R.id.Respuesta1Button);
        respuesta2Button = findViewById(R.id.Respuesta2Button);
        respuesta3Button = findViewById(R.id.Respuesta3Button);
        respuesta4Button = findViewById(R.id.Respuesta4Button);

        //Rellena el ArrayList con las preguntas
        anadirPreguntasYrespuestas();

        restoPreguntas = (ArrayList<Pregunta>) preguntas.clone();

        //Texto donde se mostrará la pregunta
        preguntaTextView = findViewById(R.id.PreguntaText);

        for(int i=0; i<restoPreguntas.size(); i++){
            Log.i("PreguntaRestante"+i, restoPreguntas.get(i).getPregunta());
        }

        for(int i=0; i<preguntas.size(); i++){
            Log.i("PreguntaOriginal"+i, preguntas.get(i).getPregunta());
        }

        jugar();

        //Boton pulsado1
        respuesta1Button.setOnClickListener(v -> {
            if (numBotonCorrecto == 1) {
                puntosPartida+=3;
            }
            else{
                puntosPartida-=2;
            }
            Log.i("Boton1", "Boton1 pulsado");
            if(seguirJugando()){
                jugar();
            }
            else{
                Intent intent = new Intent(this, Resultado.class);
                intent.putExtra("puntos", puntosPartida);
                startActivity(intent);
            }

        });
        //Boton pulsado2
        respuesta2Button.setOnClickListener(v -> {
            if (numBotonCorrecto == 2) {
                puntosPartida+=3;
            }
            else{
                puntosPartida-=2;
            }
            Log.i("Boton2", "Boton2 pulsado");
            if(seguirJugando()){
                jugar();
            }
            else{
                Intent intent = new Intent(this, Resultado.class);
                intent.putExtra("puntos", puntosPartida);
                startActivity(intent);
            }

        });
        //Boton pulsado3
        respuesta3Button.setOnClickListener(v -> {
            if (numBotonCorrecto == 3) {
                puntosPartida+=3;
            }
            else{
                puntosPartida-=2;
            }
            Log.i("Boton3", "Boton3 pulsado");
            if(seguirJugando()){
                jugar();
            }
            else{
                Intent intent = new Intent(this, Resultado.class);
                intent.putExtra("puntos", puntosPartida);
                startActivity(intent);
            }

        });
        //Boton pulsado4
        respuesta4Button.setOnClickListener(v -> {
            if (numBotonCorrecto == 4) {
                puntosPartida+=3;
            }
            else{
                puntosPartida-=2;
            }
            Log.i("Boton4", "Boton4 pulsado");
            if(seguirJugando()){
                jugar();
            }
            else{
                Intent intent = new Intent(this, Resultado.class);
                intent.putExtra("puntos", puntosPartida);
                startActivity(intent);
            }

        });
        numpreguntas++;

    }

    public void anadirPreguntasYrespuestas(){
        pregunta = new Pregunta("¿Cual es la capital de España?", "Madrid");
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
        //pregunta = new Pregunta("¿Cual es la pelicula mas taquillera de la historia?", "Avatar");
    }

    public int seleccionarPregunta(TextView pregunta){
        //Numero random de 0 a 9
        int posicionPregunta = (int) (Math.random() * restoPreguntas.size());
        //Colocar pregunta en el textview
        pregunta.setText(restoPreguntas.get(posicionPregunta).getPregunta());
        return posicionPregunta;
    }

    public void jugar(){

        //Seleccina la pregunta
        int numeroPregunta = seleccionarPregunta(preguntaTextView);
        Log.i("Pregunta",restoPreguntas.get(numeroPregunta).getPregunta());

        //Guarda la pregunta seleccionada en la variable preguntaCorrecta
        preguntaCorrecta = restoPreguntas.get(numeroPregunta);
        //Borra la pregunta seleccionada del ArrayList (para que no se repita)
        restoPreguntas.remove(numeroPregunta);

        //Colocar Boton Correcto
        int posicionBotonCorrecto = (int) (Math.random() * 4);
        switch (posicionBotonCorrecto) {
            case 0:
                respuesta1Button.setText(preguntaCorrecta.getRespuesta());
                numBotonCorrecto = 1;
                Log.i("Boton Correcto", "Boton 1");
                break;
            case 1:
                respuesta2Button.setText(preguntaCorrecta.getRespuesta());
                numBotonCorrecto = 2;
                Log.i("Boton Correcto", "Boton 2");
                break;
            case 2:
                respuesta3Button.setText(preguntaCorrecta.getRespuesta());
                numBotonCorrecto = 3;
                Log.i("Boton Correcto", "Boton 3");
                break;
            case 3:
                respuesta4Button.setText(preguntaCorrecta.getRespuesta());
                numBotonCorrecto = 4;
                Log.i("Boton Correcto", "Boton 4");
                break;
        }

        //Array de 0 a numero de restoPreguntas
        int [] respuestasIncorrectas = new int[preguntas.size()];
        for(int i=0; i<preguntas.size(); i++){
            if(i != numeroPregunta){
                respuestasIncorrectas[i] = i;
            }
            Log.i("RespuestasIncorrectas"+i, String.valueOf(respuestasIncorrectas[i]));
        }
        Collections.shuffle(Arrays.asList(respuestasIncorrectas));
        for(int i=0; i<preguntas.size(); i++) {
            Log.i("RespuestasIncMez", String.valueOf(respuestasIncorrectas[i]));
        }


        switch(numBotonCorrecto){

            case 1:
                respuesta2Button.setText(preguntas.get(respuestasIncorrectas[0]).getRespuesta());
                respuesta3Button.setText(preguntas.get(respuestasIncorrectas[1]).getRespuesta());
                respuesta4Button.setText(preguntas.get(respuestasIncorrectas[2]).getRespuesta());
                break;
            case 2:
                respuesta1Button.setText(preguntas.get(respuestasIncorrectas[0]).getRespuesta());
                respuesta3Button.setText(preguntas.get(respuestasIncorrectas[1]).getRespuesta());
                respuesta4Button.setText(preguntas.get(respuestasIncorrectas[2]).getRespuesta());
                break;
            case 3:
                respuesta1Button.setText(preguntas.get(respuestasIncorrectas[0]).getRespuesta());
                respuesta2Button.setText(preguntas.get(respuestasIncorrectas[1]).getRespuesta());
                respuesta4Button.setText(preguntas.get(respuestasIncorrectas[2]).getRespuesta());
                break;
            case 4:
                respuesta1Button.setText(preguntas.get(respuestasIncorrectas[0]).getRespuesta());
                respuesta2Button.setText(preguntas.get(respuestasIncorrectas[1]).getRespuesta());
                respuesta3Button.setText(preguntas.get(respuestasIncorrectas[2]).getRespuesta());
                break;
        }
    }

    public boolean seguirJugando(){
        if(restoPreguntas.size() == 0){
            Log.i("Juego", "Terminado");
            return false;
        }else{
            //Log.i("Preguntas Restantes", String.valueOf(restoPreguntas.size()));
            //Log.i("PreguntaOriginales", String.valueOf(preguntas.size()));
            for(int i=0; i<restoPreguntas.size(); i++){
                Log.i("PreguntaRestante"+i, restoPreguntas.get(i).getPregunta());
            }
            return true;
        }
    }


}