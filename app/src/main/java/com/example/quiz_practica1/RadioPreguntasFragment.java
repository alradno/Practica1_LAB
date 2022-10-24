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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class RadioPreguntasFragment extends Fragment {

    int numeroPreguntas;
    int puntosPartida;
    boolean correcto = false;

    TextView preguntaTextView;
    //AtomicInteger puntosPartida = new AtomicInteger();
    Jugar partida = new Jugar();
    final ArrayList<Pregunta> preguntas = partida.anadirPreguntasYRespuestas();
    ArrayList<Pregunta> restoPreguntas = (ArrayList<Pregunta>) preguntas.clone();
    ArrayList<Pregunta> restoPreguntasImagen = new ArrayList<>();
    ArrayList<Pregunta> respuestasIncorrectas = new ArrayList<>();
    Pregunta preguntaCorrecta = null;
    int numBotonCorrecto = 0;


    public RadioPreguntasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getParentFragmentManager().setFragmentResultListener("Main_a_Radio", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {
                numeroPreguntas = bundle.getInt("numeroPreguntas");
                Log.i("__Entra_deMain_aRadio", String.valueOf(numeroPreguntas));
            }
        });
        getParentFragmentManager().setFragmentResultListener("Text_a_Radio", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {
                numeroPreguntas = bundle.getInt("numeroPreguntas");
                puntosPartida = bundle.getInt("puntosPartida");
                restoPreguntas = (ArrayList<Pregunta>) bundle.getSerializable("restoPreguntas");
                Log.i("__Entra_deText_aRadio", String.valueOf(numeroPreguntas));
                //Log.i("Entra_deText_aRadioR", String.valueOf(restoPreguntasImagen.size()));

            }
        });
        getParentFragmentManager().setFragmentResultListener("Img_a_Radio", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {
                numeroPreguntas = bundle.getInt("numeroPreguntas");
                puntosPartida = bundle.getInt("puntosPartida");
                //Obtiene restoPreguntas del bundle
                restoPreguntas = (ArrayList<Pregunta>) bundle.getSerializable("restoPreguntas");
                Log.i("__Entra_deImg_aRadio", String.valueOf(numeroPreguntas));
                //Log.i("Entra_deImg_aRadioR", String.valueOf(restoPreguntasImagen.size()));

            }
        });
        getParentFragmentManager().setFragmentResultListener("Img2_a_Radio", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {
                numeroPreguntas = bundle.getInt("numeroPreguntas");
                puntosPartida = bundle.getInt("puntosPartida");
                //Obtiene restoPreguntas del bundle
                restoPreguntas = (ArrayList<Pregunta>) bundle.getSerializable("restoPreguntas");
                Log.i("__Entra_deImg2_aRadio", String.valueOf(numeroPreguntas));
                //Log.i("Entra_deImg_aRadioR", String.valueOf(restoPreguntasImagen.size()));

            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_radio_preguntas, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RadioButton radioButton1 = view.findViewById(R.id.respuestaText1);
        RadioButton radioButton2 = view.findViewById(R.id.respuestaText2);
        RadioButton radioButton3 = view.findViewById(R.id.respuestaText3);
        RadioButton radioButton4 = view.findViewById(R.id.respuestaText4);
        Button contestar = view.findViewById(R.id.buttonContestar);

        //Boton atrás que vuelva a la pantalla de inicio
        Button reiniciar = view.findViewById(R.id.reiniciarButton);
        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_radioPreguntasFragment_to_inicioFragment);
            }
        });

        //Texto donde se mostrará la pregunta
        preguntaTextView = view.findViewById(R.id.PreguntaRadio);

        jugarTextView(radioButton1, radioButton2, radioButton3, radioButton4);

        //Listener del boton contestar
        contestar.setOnClickListener(v -> {
            if (radioButton1.isChecked() || radioButton2.isChecked() || radioButton3.isChecked() || radioButton4.isChecked()) {
                if (numBotonCorrecto == 1 && radioButton1.isChecked()) {
                    puntosPartida+=3;
                    Toast.makeText(getContext(), "¡Correcto!", Toast.LENGTH_SHORT).show();
                    tipoPregunta(view, radioButton1, radioButton2, radioButton3, radioButton4);
                }
                else if (numBotonCorrecto == 2 && radioButton2.isChecked()) {
                    puntosPartida+=3;
                    Toast.makeText(getContext(), "¡Correcto!", Toast.LENGTH_SHORT).show();
                    tipoPregunta(view, radioButton1, radioButton2, radioButton3, radioButton4);
                }
                else if (numBotonCorrecto == 3 && radioButton3.isChecked()) {
                    puntosPartida+=3;
                    Toast.makeText(getContext(), "¡Correcto!", Toast.LENGTH_SHORT).show();
                    tipoPregunta(view, radioButton1, radioButton2, radioButton3, radioButton4);
                }
                else if (numBotonCorrecto == 4 && radioButton4.isChecked()) {
                    puntosPartida+=3;
                    Toast.makeText(getContext(), "¡Correcto!", Toast.LENGTH_SHORT).show();
                    tipoPregunta(view, radioButton1, radioButton2, radioButton3, radioButton4);
                }
                else{
                    puntosPartida-=2;
                    Toast.makeText(getContext(), "¡Has Fallado!", Toast.LENGTH_SHORT).show();
                    tipoPregunta(view, radioButton1, radioButton2, radioButton3, radioButton4);
                }
            }
            else{
                Toast.makeText(getContext(), "¡Debes seleccionar una respuesta!", Toast.LENGTH_SHORT).show();
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

    public void jugarTextView(RadioButton respuesta1Button, RadioButton respuesta2Button, RadioButton respuesta3Button, RadioButton respuesta4Button) {

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

    public void tipoPregunta(View view, RadioButton respuesta1Button, RadioButton respuesta2Button, RadioButton respuesta3Button, RadioButton respuesta4Button) {
        if(numeroPreguntas > 0) {
            //Genera un numero random entre 0 y 1
            int tipoPregunta = (int) (Math.random() * 4);


            if (tipoPregunta == 0) {
                jugarTextView(respuesta1Button, respuesta2Button, respuesta3Button, respuesta4Button);
            }
            else if(tipoPregunta == 1) {

                Log.i("__Sale_deRadio_aText", String.valueOf(numeroPreguntas));
                //Log.i("Sale_deRadio_aTextR", String.valueOf(restoPreguntasImagen.size()));
                Log.i("__PE_desde_Radio: ", "Text");

                Bundle result = new Bundle();
                numeroPreguntas--;
                result.putInt("numeroPreguntas", numeroPreguntas);
                result.putInt("puntosPartida", puntosPartida);
                result.putSerializable("restoPreguntas", restoPreguntas);
                result.putSerializable("restoPreguntasImagen", restoPreguntasImagen);
                getParentFragmentManager().setFragmentResult("Radio_a_Text", result);

                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.textPreguntasFragment);
            }
            else if(tipoPregunta == 2) {

                Log.i("__Sale_deRadio_aImg", String.valueOf(numeroPreguntas));
                //Log.i("Sale_deRadio_aImgR", String.valueOf(restoPreguntasImagen.size()));
                Log.i("__PE_desde_Radio: ", "Img");

                Bundle result = new Bundle();
                numeroPreguntas--;
                result.putInt("numeroPreguntas", numeroPreguntas);
                result.putInt("puntosPartida", puntosPartida);
                result.putSerializable("restoPreguntasImagen", restoPreguntasImagen);
                result.putSerializable("restoPreguntas", restoPreguntas);
                getParentFragmentManager().setFragmentResult("Radio_a_Img", result);

                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.imagenesFragment);
            }
            else{
                Log.i("__Sale_deRadio_aVid", String.valueOf(numeroPreguntas));
                //Log.i("Sale_deRadio_aVidR", String.valueOf(restoPreguntasImagen.size()));
                Log.i("__PE_desde_Radio: ", "Vid");

                Bundle result = new Bundle();
                numeroPreguntas--;
                result.putInt("numeroPreguntas", numeroPreguntas);
                result.putInt("puntosPartida", puntosPartida);
                result.putSerializable("restoPreguntasImagen", restoPreguntasImagen);
                result.putSerializable("restoPreguntas", restoPreguntas);
                getParentFragmentManager().setFragmentResult("Radio_a_Img2", result);

                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.imagenes2Fragment);
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