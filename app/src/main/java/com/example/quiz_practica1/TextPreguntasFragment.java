package com.example.quiz_practica1;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class TextPreguntasFragment extends Fragment {
    int numeroPreguntas;
    int puntosPartida;

    TextView preguntaTextView;
    //AtomicInteger puntosPartida = new AtomicInteger();
    Jugar partida = new Jugar();
    final ArrayList<Pregunta> preguntas = partida.anadirPreguntasYRespuestas();
    ArrayList<Pregunta> restoPreguntas = (ArrayList<Pregunta>) preguntas.clone();
    ArrayList<Pregunta> respuestasIncorrectas = new ArrayList<>();
    ArrayList<Pregunta> restoPreguntasImagen = new ArrayList<>();
    Pregunta preguntaCorrecta = null;
    int numBotonCorrecto = 0;


    public TextPreguntasFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getParentFragmentManager().setFragmentResultListener("variables", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {
                numeroPreguntas = bundle.getInt("numeroPreguntas");
            }
        });
        getParentFragmentManager().setFragmentResultListener("variablesRadio", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {
                numeroPreguntas = bundle.getInt("numpreguntasRadio");
                puntosPartida = bundle.getInt("puntosPartidaRadio");
                //Obtiene restoPreguntas del bundle
                restoPreguntas = (ArrayList<Pregunta>) bundle.getSerializable("restoPreguntasRadio");
                Log.i("NumpreguntasEntra", String.valueOf(numeroPreguntas));

            }
        });
        getParentFragmentManager().setFragmentResultListener("variablesImagen", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {
                numeroPreguntas = bundle.getInt("numeroPreguntas");
                puntosPartida = bundle.getInt("puntosPartida");
                //Obtiene restoPreguntas del bundle
                restoPreguntas = (ArrayList<Pregunta>) bundle.getSerializable("restoPreguntas");

            }
        });



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text_preguntas, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //final NavController navController = Navigation.findNavController(view);

        Button respuesta1Button = view.findViewById(R.id.respuestaText1);
        Button respuesta2Button = view.findViewById(R.id.respuestaText2);
        Button respuesta3Button = view.findViewById(R.id.respuestaText3);
        Button respuesta4Button = view.findViewById(R.id.respuestaText4);

        //Texto donde se mostrará la pregunta
        preguntaTextView = view.findViewById(R.id.PreguntaTextFragment);

        jugarTextView(respuesta1Button, respuesta2Button, respuesta3Button, respuesta4Button);

        respuesta1Button.setOnClickListener(v -> {
            if (numBotonCorrecto == 1) {
                puntosPartida+=3;
                Toast.makeText(getContext(), "¡Correcto!", Toast.LENGTH_SHORT).show();
                tipoPregunta(view, respuesta1Button, respuesta2Button, respuesta3Button, respuesta4Button);
            }
            else{
                puntosPartida-=2;
                Toast.makeText(getContext(), "¡Has Fallado!", Toast.LENGTH_SHORT).show();
                tipoPregunta(view, respuesta1Button, respuesta2Button, respuesta3Button, respuesta4Button);
            }
            Log.i("Boton1", "Boton1 pulsado");


        });
        //Boton pulsado2
        respuesta2Button.setOnClickListener(v -> {
            if (numBotonCorrecto == 2) {
                puntosPartida+=3;
                Toast.makeText(getContext(), "¡Correcto!", Toast.LENGTH_SHORT).show();
                tipoPregunta(view, respuesta1Button, respuesta2Button, respuesta3Button, respuesta4Button);
            }
            else{
                puntosPartida-=2;
                Toast.makeText(getContext(), "¡Has Fallado!", Toast.LENGTH_SHORT).show();
                tipoPregunta(view, respuesta1Button, respuesta2Button, respuesta3Button, respuesta4Button);
            }
            Log.i("Boton2", "Boton2 pulsado");

        });
        //Boton pulsado3
        respuesta3Button.setOnClickListener(v -> {
            if (numBotonCorrecto == 3) {
                puntosPartida+=3;
                Toast.makeText(getContext(), "¡Correcto!", Toast.LENGTH_SHORT).show();
                tipoPregunta(view, respuesta1Button, respuesta2Button, respuesta3Button, respuesta4Button);
            }
            else{
                puntosPartida-=2;
                Toast.makeText(getContext(), "¡Has Fallado!", Toast.LENGTH_SHORT).show();
                tipoPregunta(view, respuesta1Button, respuesta2Button, respuesta3Button, respuesta4Button);
            }
            Log.i("Boton3", "Boton3 pulsado");


        });
        //Boton pulsado4
        respuesta4Button.setOnClickListener(v -> {
            if (numBotonCorrecto == 4) {
                puntosPartida+=3;
                Toast.makeText(getContext(), "¡Correcto!", Toast.LENGTH_SHORT).show();
                tipoPregunta(view, respuesta1Button, respuesta2Button, respuesta3Button, respuesta4Button);
            }
            else{
                puntosPartida-=2;
                Toast.makeText(getContext(), "¡Has Fallado!", Toast.LENGTH_SHORT).show();
                tipoPregunta(view, respuesta1Button, respuesta2Button, respuesta3Button, respuesta4Button);
            }
            Log.i("Boton4", "Boton4 pulsado");

        });

        //Boton atrás que vuelva a la pantalla de inicio
        Button atras = view.findViewById(R.id.reiniciarButton2);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_textPreguntasFragment_to_inicioFragment);
            }
        });

    }

    public int seleccionarPregunta(TextView pregunta, ArrayList<Pregunta> restoPreguntas){
        //Numero random de 0 a 9
        int posicionPregunta = (int) (Math.random() * restoPreguntas.size());
        int idPregunta = restoPreguntas.get(posicionPregunta).getId();
        //Colocar pregunta en el textview
        pregunta.setText(restoPreguntas.get(posicionPregunta).getPregunta());
        return idPregunta;
    }

    public void jugarTextView(Button respuesta1Button, Button respuesta2Button, Button respuesta3Button, Button respuesta4Button){

        //Seleccina la pregunta
        int idPregunta = seleccionarPregunta(preguntaTextView, restoPreguntas);

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
        numeroPreguntas--;
    }

    public void tipoPregunta(View view, Button respuesta1Button, Button respuesta2Button, Button respuesta3Button, Button respuesta4Button){

        if(numeroPreguntas > 0) {
            //Genera un numero random entre 0 y 1
            int tipoPregunta = (int) (Math.random() * 2);
            if (tipoPregunta == 0) {
                jugarTextView(respuesta1Button, respuesta2Button, respuesta3Button, respuesta4Button);
            }
            else if(tipoPregunta == 1){
                Bundle result = new Bundle();
                numeroPreguntas--;
                result.putInt("numpreguntasText", numeroPreguntas);
                result.putInt("puntosPartidaText", puntosPartida);
                result.putSerializable("restoPreguntasText", restoPreguntas);
                getParentFragmentManager().setFragmentResult("variablesText", result);
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.radioPreguntasFragment);
                Log.i("NumpreguntasSale", String.valueOf(numeroPreguntas));
            }
            else{
                Bundle result = new Bundle();
                numeroPreguntas--;
                result.putInt("numeroPreguntas", numeroPreguntas);
                result.putInt("puntosPartida", puntosPartida);
                result.putSerializable("restoPreguntasImagenText", restoPreguntasImagen);
                result.putSerializable("restoPreguntas", restoPreguntas);
                getParentFragmentManager().setFragmentResult("variablesImagenText", result);
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.imagenesFragment);
            }
        }
        else{
            //Abre activity Resultado y le pasa puntosPartida
            Intent intent = new Intent(getActivity(), Resultado.class);
            intent.putExtra("puntosPartida", puntosPartida);
            startActivity(intent);
        }
    }
}