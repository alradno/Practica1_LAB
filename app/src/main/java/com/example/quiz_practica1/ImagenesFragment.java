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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class ImagenesFragment extends Fragment {

    private ImageView imageView;
    private int numeroPreguntas;
    Jugar partida = new Jugar();
    private ArrayList<Pregunta> preguntas = partida.anadirPreguntas2();
    private int puntosPartida;
    private ArrayList<Pregunta> restoPreguntasImagen =  (ArrayList<Pregunta>) preguntas.clone();
    private ArrayList<Pregunta> restoPreguntas;
    private int idImagen;
    private Pregunta preguntaElegida;
    private TextView preguntaImagen;
    private int numBotonCorrecto;

    Button respuestaImagen1;
    Button respuestaImagen2;
    Button respuestaImagen3;
    Button respuestaImagen4;


    public ImagenesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getParentFragmentManager().setFragmentResultListener("Main_a_Img", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {
                numeroPreguntas = bundle.getInt("numeroPreguntas");
                Log.i("__Entra_deMain_aImg", String.valueOf(numeroPreguntas));
            }
        });
        getParentFragmentManager().setFragmentResultListener("Text_a_Img", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {
                numeroPreguntas = bundle.getInt("numeroPreguntas");
                puntosPartida = bundle.getInt("puntosPartida");
                if((ArrayList<Pregunta>) bundle.getSerializable("restoPreguntasImagen") != null){
                    restoPreguntasImagen = (ArrayList<Pregunta>) bundle.getSerializable("restoPreguntasImagen");
                }
                if((ArrayList<Pregunta>) bundle.getSerializable("restoPreguntas") != null){
                    restoPreguntas = (ArrayList<Pregunta>) bundle.getSerializable("restoPreguntas");
                }
                Log.i("__Entra_deText_aImg", String.valueOf(numeroPreguntas));
                //Log.i("Entra_deText_aImgR", String.valueOf(restoPreguntasImagen.size()));
            }
        });
        getParentFragmentManager().setFragmentResultListener("Radio_a_Img", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {
                numeroPreguntas = bundle.getInt("numeroPreguntas");
                puntosPartida = bundle.getInt("puntosPartida");
                //Obtiene restoPreguntas del bundle
                if((ArrayList<Pregunta>) bundle.getSerializable("restoPreguntasImagen") != null){
                    restoPreguntas = (ArrayList<Pregunta>) bundle.getSerializable("restoPreguntas");
                }
                if((ArrayList<Pregunta>) bundle.getSerializable("restoPreguntas") != null){
                    restoPreguntas = (ArrayList<Pregunta>) bundle.getSerializable("restoPreguntas");
                }
                Log.i("__Entra_deRadio_aImg", String.valueOf(numeroPreguntas));
                //Log.i("__Entra_deRadio_aImgR", String.valueOf(restoPreguntasImagen.size()));

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_imagenes, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        imageView = view.findViewById(R.id.imageView);
        preguntaImagen = view.findViewById(R.id.preguntaImagen);

        respuestaImagen1 = view.findViewById(R.id.respuestaImagen1);
        respuestaImagen2 = view.findViewById(R.id.respuestaImagen2);
        respuestaImagen3 = view.findViewById(R.id.respuestaImagen3);
        respuestaImagen4 = view.findViewById(R.id.respuestaImagen4);


        jugar2();

        respuestaImagen1.setOnClickListener(v -> {
            if (numBotonCorrecto == 1) {
                puntosPartida+=3;
                Toast.makeText(getContext(), "¡Correcto!", Toast.LENGTH_SHORT).show();
            }
            else{
                puntosPartida-=2;
                Toast.makeText(getContext(), "¡Has Fallado!", Toast.LENGTH_SHORT).show();
            }
            Log.i("Boton1", "Boton1 pulsado");
            tipoPregunta(view);


        });
        //Boton pulsado2
        respuestaImagen2.setOnClickListener(v -> {
            if (numBotonCorrecto == 2) {
                puntosPartida+=3;
                Toast.makeText(getContext(), "¡Correcto!", Toast.LENGTH_SHORT).show();
            }
            else{
                puntosPartida-=2;
                Toast.makeText(getContext(), "¡Has Fallado!", Toast.LENGTH_SHORT).show();
            }
            Log.i("Boton2", "Boton2 pulsado");
            tipoPregunta(view);

        });
        //Boton pulsado3
        respuestaImagen3.setOnClickListener(v -> {
            if (numBotonCorrecto == 3) {
                puntosPartida+=3;
                Toast.makeText(getContext(), "¡Correcto!", Toast.LENGTH_SHORT).show();
                tipoPregunta(view);
            }
            else{
                puntosPartida-=2;
                Toast.makeText(getContext(), "¡Has Fallado!", Toast.LENGTH_SHORT).show();
                tipoPregunta(view);
            }
            Log.i("Boton3", "Boton3 pulsado");
            tipoPregunta(view);


        });
        //Boton pulsado4
        respuestaImagen4.setOnClickListener(v -> {
            if (numBotonCorrecto == 4) {
                puntosPartida+=3;
                Toast.makeText(getContext(), "¡Correcto!", Toast.LENGTH_SHORT).show();
            }
            else{
                puntosPartida-=2;
                Toast.makeText(getContext(), "¡Has Fallado!", Toast.LENGTH_SHORT).show();
            }
            Log.i("Boton4", "Boton4 pulsado");
            tipoPregunta(view);

        });

    }

    public void jugar2(){
        //Numero aleatorio de 0 a restoPreguntasImagen.size()-1
        int numAleatorio = (int) (Math.random() * preguntas.size());
        //Elige una pregunta
        Pregunta preguntaElegida = preguntas.get(numAleatorio);
        System.out.println("Pregunta elegida: " + preguntaElegida.getRespuesta());
        //Coloca el texto de la pregunta en el TextView
        preguntaImagen.setText(preguntaElegida.getPregunta());
        //Elige un boton correcto y coloca la respuesta correcta en el boton
        elegirBotonCorrecto(preguntaElegida);
        System.out.println("Boton correcto: " + numBotonCorrecto);
        //Extrae los nombres de las imagenes y los guarda en un array
        ArrayList<String> nombreImagenes = partida.nombreImagenes(preguntas);
        //Coloca la imagen en el ImageView
        int idImagen = getResources().getIdentifier(nombreImagenes.get(numAleatorio), "drawable", getActivity().getPackageName());
        System.out.println("Imagen elegida: " + nombreImagenes.get(numAleatorio));
        imageView.setImageResource(idImagen);
        //Elige los botones incorrectos
        elegirBotonesIncorrectos(numBotonCorrecto, preguntaElegida);
        numeroPreguntas--;
    }

    public void elegirBotonCorrecto(Pregunta preguntaElegida) {

        int posicionBotonCorrecto = (int) (Math.random() * 4);
        switch (posicionBotonCorrecto) {
            case 0:
                respuestaImagen1.setText(preguntaElegida.getRespuesta());
                numBotonCorrecto = 1;
                Log.i("Boton Correcto", "Boton 1");
                break;
            case 1:
                respuestaImagen2.setText(preguntaElegida.getRespuesta());
                numBotonCorrecto = 2;
                Log.i("Boton Correcto", "Boton 2");
                break;
            case 2:
                respuestaImagen3.setText(preguntaElegida.getRespuesta());
                numBotonCorrecto = 3;
                Log.i("Boton Correcto", "Boton 3");
                break;
            case 3:
                respuestaImagen4.setText(preguntaElegida.getRespuesta());
                numBotonCorrecto = 4;
                Log.i("Boton Correcto", "Boton 4");
                break;
        }
    }

    public void elegirBotonesIncorrectos(int numBotonCorrecto, Pregunta preguntaElegida){

        ArrayList<Pregunta> respuestasIncorrectas = (ArrayList<Pregunta>) preguntas.clone();
        respuestasIncorrectas.remove(preguntaElegida);

        //Barajar el array
        Collections.shuffle(respuestasIncorrectas);

        if(numBotonCorrecto == 1){
            respuestaImagen2.setText(respuestasIncorrectas.get(0).getRespuesta());
            respuestaImagen3.setText(respuestasIncorrectas.get(1).getRespuesta());
            respuestaImagen4.setText(respuestasIncorrectas.get(2).getRespuesta());
        }
        else if(numBotonCorrecto == 2){
            respuestaImagen1.setText(respuestasIncorrectas.get(0).getRespuesta());
            respuestaImagen3.setText(respuestasIncorrectas.get(1).getRespuesta());
            respuestaImagen4.setText(respuestasIncorrectas.get(2).getRespuesta());
        }
        else if(numBotonCorrecto == 3){
            respuestaImagen1.setText(respuestasIncorrectas.get(0).getRespuesta());
            respuestaImagen2.setText(respuestasIncorrectas.get(1).getRespuesta());
            respuestaImagen4.setText(respuestasIncorrectas.get(2).getRespuesta());
        }
        else{
            respuestaImagen1.setText(respuestasIncorrectas.get(0).getRespuesta());
            respuestaImagen2.setText(respuestasIncorrectas.get(1).getRespuesta());
            respuestaImagen3.setText(respuestasIncorrectas.get(2).getRespuesta());
        }
    }

    public void tipoPregunta(View view){

        if(numeroPreguntas > 0) {
            //Genera un numero random entre 0 y 1
            int tipoPregunta = (int) (Math.random() * 3);
            if (tipoPregunta == 0) {
                jugar2();
            }
            else if(tipoPregunta == 1){

                Log.i("__Sale_deImg_aText", String.valueOf(numeroPreguntas));
                //Log.i("Sale_deImg_aTextR", String.valueOf(restoPreguntasImagen.size()));
                Log.i("__PE_desde_Img: ", "Text");

                Bundle result = new Bundle();
                numeroPreguntas--;
                result.putInt("numeroPreguntas", numeroPreguntas);
                result.putInt("puntosPartida", puntosPartida);
                result.putSerializable("restoPreguntas", restoPreguntas);
                result.putSerializable("restoPreguntasImagen", restoPreguntasImagen);
                getParentFragmentManager().setFragmentResult("Img_a_Text", result);

                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.textPreguntasFragment);
            }
            else{

                Log.i("__Sale_deImg_aRadio", String.valueOf(numeroPreguntas));
                //Log.i("Sale_deImg_aRadioR", String.valueOf(restoPreguntasImagen.size()));
                Log.i("__PE_desde_Img: ", "Radio");

                Bundle result = new Bundle();
                numeroPreguntas--;
                result.putInt("numeroPreguntas", numeroPreguntas);
                result.putInt("puntosPartida", puntosPartida);
                result.putSerializable("restoPreguntasImagen", restoPreguntasImagen);
                result.putSerializable("restoPreguntas", restoPreguntas);
                getParentFragmentManager().setFragmentResult("Img_a_Radio", result);

                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.radioPreguntasFragment);
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