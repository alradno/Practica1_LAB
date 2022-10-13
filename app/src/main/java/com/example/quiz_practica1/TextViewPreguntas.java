package com.example.quiz_practica1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class TextViewPreguntas extends AppCompatActivity {

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
        setContentView(R.layout.activity_text_view_preguntas);

        respuesta1Button = findViewById(R.id.respuesta1Button);
        respuesta2Button = findViewById(R.id.respuesta2Button);
        respuesta3Button = findViewById(R.id.respuesta3Button);
        respuesta4Button = findViewById(R.id.respuesta4Button);

        Jugar partida = new Jugar();

        preguntas = partida.anadirPreguntasYRespuestas();
        //restoPreguntas = (ArrayList<Pregunta>) preguntas.clone();
        restoPreguntas = (ArrayList<Pregunta>) getIntent().getSerializableExtra("restoPreguntas");
        puntosPartida = getIntent().getIntExtra("puntosPartida", 0);

        //Texto donde se mostrará la pregunta
        preguntaTextView = findViewById(R.id.preguntaTextView);

        jugarTextView();

        //Boton pulsado1
        respuesta1Button.setOnClickListener(v -> {
            if (numBotonCorrecto == 1) {
                puntosPartida+=3;
                volverAmain();
            }
            else{
                puntosPartida-=2;
                volverAmain();
            }
            Log.i("Boton1", "Boton1 pulsado");


        });
        //Boton pulsado2
        respuesta2Button.setOnClickListener(v -> {
            if (numBotonCorrecto == 2) {
                puntosPartida+=3;
                volverAmain();
            }
            else{
                puntosPartida-=2;
                volverAmain();
            }
            Log.i("Boton2", "Boton2 pulsado");

        });
        //Boton pulsado3
        respuesta3Button.setOnClickListener(v -> {
            if (numBotonCorrecto == 3) {
                puntosPartida+=3;
                volverAmain();
            }
            else{
                puntosPartida-=2;
                volverAmain();
            }
            Log.i("Boton3", "Boton3 pulsado");


        });
        //Boton pulsado4
        respuesta4Button.setOnClickListener(v -> {
            if (numBotonCorrecto == 4) {
                puntosPartida+=3;
                volverAmain();
            }
            else{
                puntosPartida-=2;
                volverAmain();
            }
            Log.i("Boton4", "Boton4 pulsado");

        });

        //Boton Salir
        Button salirButton = findViewById(R.id.salirButtonTextView);
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

    public void jugarTextView(){

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

    public void volverAmain(){
        if(numpreguntas == 0){
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("puntosPartida", puntosPartida);
            startActivity(intent);
            finish();
        }
        else {
            //Mostrar MainActivity
            Intent intent = new Intent(this, MainActivity.class);
            //Pasar restoPreguntas
            intent.putExtra("restoPreguntas", restoPreguntas);
            //Pasar puntos
            intent.putExtra("puntosPartida", puntosPartida);
            //Pasar numpreguntas
            intent.putExtra("numpreguntas", numpreguntas);
            startActivity(intent);
            finish();
        }
    }

}