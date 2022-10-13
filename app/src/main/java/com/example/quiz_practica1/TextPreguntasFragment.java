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
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TextPreguntasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TextPreguntasFragment extends Fragment {
    int numpreguntas;
    int puntosPartida;

    TextView preguntaTextView;
    //AtomicInteger puntosPartida = new AtomicInteger();
    Jugar partida = new Jugar();
    final ArrayList<Pregunta> preguntas = partida.anadirPreguntasYRespuestas();
    ArrayList<Pregunta> restoPreguntas = (ArrayList<Pregunta>) preguntas.clone();
    ArrayList<Pregunta> respuestasIncorrectas = new ArrayList<>();
    Pregunta preguntaCorrecta = null;
    int numBotonCorrecto = 0;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TextPreguntasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TextPreguntasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TextPreguntasFragment newInstance(String param1, String param2) {
        TextPreguntasFragment fragment = new TextPreguntasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        getParentFragmentManager().setFragmentResultListener("variables", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {
                numpreguntas = bundle.getInt("numpreguntas");
                //Log.i("numpreguntasListText", String.valueOf(numpreguntas));
            }
        });
        getParentFragmentManager().setFragmentResultListener("variablesRadio", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {
                numpreguntas = bundle.getInt("numpreguntasRadio");
                puntosPartida = bundle.getInt("puntosPartidaRadio");
                //Obtiene restoPreguntas del bundle
                restoPreguntas = (ArrayList<Pregunta>) bundle.getSerializable("restoPreguntasRadio");

                Log.i("num1EntrEnPreguntasText", String.valueOf(numpreguntas));
                Log.i("num1EntrEnPuntosText", String.valueOf(puntosPartida));
            }
        });

        //COSAS QUE HACER
        /*Agregar realimentacion de fallo/acierto
        * Agregar Seleccion en radioButton(ahora salta automaticamente)*/

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

        //Recuperar el numero de preguntas que se han contestado
        //int numpreguntas = getArguments().getInt("numpreguntas");

        //Boton Atras
        /*Button atras = view.findViewById(R.id.AtrasButton1);
        atras.setOnClickListener( v ->  {
            navController.popBackStack();
        });*/

        //restoPreguntas = (ArrayList<Pregunta>) getIntent().getSerializableExtra("restoPreguntas");
        //puntosPartida = getIntent().getIntExtra("puntosPartida", 0);

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
        numpreguntas--;
    }

    public void tipoPregunta(View view, Button respuesta1Button, Button respuesta2Button, Button respuesta3Button, Button respuesta4Button){

        if(numpreguntas > 0) {
            //Genera un numero random entre 0 y 1
            int tipoPregunta = (int) (Math.random() * 2);
            if (tipoPregunta == 0) {
                jugarTextView(respuesta1Button, respuesta2Button, respuesta3Button, respuesta4Button);
            } else {
                Bundle result = new Bundle();
                numpreguntas--;
                result.putInt("numpreguntasText", numpreguntas);
                result.putInt("puntosPartidaText", puntosPartida);
                result.putSerializable("restoPreguntasText", restoPreguntas);
                getParentFragmentManager().setFragmentResult("variablesText", result);
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.radioPreguntasFragment);
            }
            Log.i("Num1SaleDepreguntasText", String.valueOf(numpreguntas));
            Log.i("Num1pSaleDepreguntaText", String.valueOf(puntosPartida));
        }
        else{
            //Abre activity Resultado y le pasa puntosPartida
            Intent intent = new Intent(getActivity(), Resultado.class);
            intent.putExtra("puntosPartida", puntosPartida);
            startActivity(intent);
        }
    }
}