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
    ArrayList<Pregunta> respuestasIncorrectas = new ArrayList<>();
    Pregunta preguntaCorrecta;
    int numBotonCorrecto;
    int numpreguntas = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        respuesta1Button = findViewById(R.id.Respuesta1Button);
        respuesta2Button = findViewById(R.id.Respuesta2Button);
        respuesta3Button = findViewById(R.id.Respuesta3Button);
        respuesta4Button = findViewById(R.id.Respuesta4Button);

        //Rellena el ArrayList con las preguntas
        anadirPreguntasYRespuestas();

        restoPreguntas = (ArrayList<Pregunta>) preguntas.clone();

        //Texto donde se mostrará la pregunta
        preguntaTextView = findViewById(R.id.PreguntaText);

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
                finish();
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
                finish();

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
                finish();
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
                finish();
            }

        });

        //Boton Salir
        Button salirButton = findViewById(R.id.salirButtonMain);
        salirButton.setOnClickListener(v -> {
            finishAffinity();
        });

    }

    public int seleccionarPregunta(TextView pregunta){
        //Numero random de 0 a 9
        int posicionPregunta = (int) (Math.random() * restoPreguntas.size());
        int idPregunta = restoPreguntas.get(posicionPregunta).getId();
        //Colocar pregunta en el textview
        pregunta.setText(restoPreguntas.get(posicionPregunta).getPregunta());
        return idPregunta;
    }

    public void jugar(){

        //Seleccina la pregunta
        int idPregunta = seleccionarPregunta(preguntaTextView);

        for(int i = 0; i < restoPreguntas.size(); i++){
            if(restoPreguntas.get(i).getId() == idPregunta){
                preguntaCorrecta = restoPreguntas.get(i);
                restoPreguntas.remove(i);
            }
        }

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

        respuestasIncorrectas = (ArrayList<Pregunta>) preguntas.clone();
        respuestasIncorrectas.remove(preguntaCorrecta);

        //Barajar el array
        Collections.shuffle(respuestasIncorrectas);

        switch(numBotonCorrecto){

            case 1:
                respuesta2Button.setText(respuestasIncorrectas.get(0).getRespuesta());
                respuesta3Button.setText(respuestasIncorrectas.get(1).getRespuesta());
                respuesta4Button.setText(respuestasIncorrectas.get(2).getRespuesta());
                break;
            case 2:
                respuesta1Button.setText(respuestasIncorrectas.get(0).getRespuesta());
                respuesta3Button.setText(respuestasIncorrectas.get(1).getRespuesta());
                respuesta4Button.setText(respuestasIncorrectas.get(2).getRespuesta());
                break;
            case 3:
                respuesta1Button.setText(respuestasIncorrectas.get(0).getRespuesta());
                respuesta2Button.setText(respuestasIncorrectas.get(1).getRespuesta());
                respuesta4Button.setText(respuestasIncorrectas.get(2).getRespuesta());
                break;
            case 4:
                respuesta1Button.setText(respuestasIncorrectas.get(0).getRespuesta());
                respuesta2Button.setText(respuestasIncorrectas.get(1).getRespuesta());
                respuesta3Button.setText(respuestasIncorrectas.get(2).getRespuesta());
                break;
        }
        numpreguntas--;
    }

    public boolean seguirJugando(){
        if(numpreguntas == 0){
            Log.i("Juego", "Terminado");
            return false;
        }else{
            Log.i("Preguntas Restantes", String.valueOf(numpreguntas));
            return true;
        }
    }

    public void anadirPreguntasYRespuestas(){
        pregunta = new Pregunta("¿Cual es la capital de España?", "Madrid", 0);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Francia?", "Paris", 1);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Italia?", "Roma", 2);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Portugal?", "Lisboa", 3);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Alemania?", "Berlin", 4);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Inglaterra?", "Londres", 5);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Grecia?", "Atenas", 6);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Corea?", "Seul", 7);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de China?", "Pekin", 8);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Japon?", "Tokio", 9);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Rusia?", "Moscu", 10);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Egipto?", "El Cairo", 11);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Marruecos?", "Rabat", 12);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Argentina?", "Buenos Aires", 13);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Brasil?", "Brasilia", 14);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Colombia?", "Bogota", 15);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Mexico?", "Mexico", 16);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Venezuela?", "Caracas", 17);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Australia?", "Canberra", 18);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Nueva Zelanda?", "Wellington", 19);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Canada?", "Ottawa", 20);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Estados Unidos?", "Washington", 21);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Cuba?", "La Habana", 22);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Polonia?", "Varsovia", 23);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Suecia?", "Estocolmo", 24);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Noruega?", "Oslo", 25);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Finlandia?", "Helsinki", 26);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Dinamarca?", "Copenhague", 27);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Islandia?", "Reikiavik", 28);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Irlanda?", "Dublin", 29);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Ucrania?", "Kiev", 30);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Turquia?", "Ankara", 31);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de el Vaticano?", "Ciudad del Vaticano", 32);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Suiza?", "Bern", 33);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Austria?", "Viena", 34);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Bélgica?", "Bruselas", 35);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Holanda?", "Amsterdam", 36);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Luxemburgo?", "Luxemburgo", 37);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Bulgaria?", "Sofia", 38);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Hungría?", "Budapest", 39);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Rumania?", "Bucarest", 40);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Serbia?", "Belgrado", 41);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Croacia?", "Zagreb", 42);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Eslovenia?", "Ljubljana", 43);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Eslovaquia?", "Bratislava", 44);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de India?", "Nueva Delhi", 45);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Indonesia?", "Yakarta", 46);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Uruguay?", "Montevideo", 47);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Paraguay?", "Asunción", 48);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Chile?", "Santiago de Chile", 49);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Perú?", "Lima", 50);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Ecuador?", "Quito", 51);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Bolivia?", "La Paz", 52);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Panamá?", "Panamá", 53);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Costa Rica?", "San José", 54);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Nicaragua?", "Managua", 55);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Honduras?", "Tegucigalpa", 56);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de El Salvador?", "San Salvador", 57);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Guatemala?", "Ciudad de Guatemala", 58);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Belice?", "Belice", 59);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital Argelia?", "Argel", 60);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Congo?", "Brazzaville", 61);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Zimbabwe?", "Harare", 62);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Sudáfrica?", "Pretoria", 63);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Arabia Saudita?", "Riad", 64);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Cual es la capital de Pakistán?", "Islamabad", 65);
        preguntas.add(pregunta);

    }


}