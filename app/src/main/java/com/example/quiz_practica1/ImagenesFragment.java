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
    private ArrayList<Pregunta> preguntas = new ArrayList<>();
    private int numpreguntas;
    private int puntosPartida;
    private ArrayList<Pregunta> restoPreguntasImagen = new ArrayList<>();
    private ArrayList<Pregunta> restoPreguntas = new ArrayList<>();
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

        getParentFragmentManager().setFragmentResultListener("variables", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {
                numpreguntas = bundle.getInt("numpreguntas");
            }
        });
        getParentFragmentManager().setFragmentResultListener("variablesImagenText", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {
                numpreguntas = bundle.getInt("numeroPreguntas");
                puntosPartida = bundle.getInt("puntosPartida");
                restoPreguntasImagen = (ArrayList<Pregunta>) bundle.getSerializable("restoPreguntasImagen");
                restoPreguntas = (ArrayList<Pregunta>) bundle.getSerializable("restoPreguntas");

            }
        });
        getParentFragmentManager().setFragmentResultListener("variablesImagenRadio", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {
                numpreguntas = bundle.getInt("numeroPreguntas");
                puntosPartida = bundle.getInt("puntosPartida");
                //Obtiene restoPreguntas del bundle
                restoPreguntasImagen = (ArrayList<Pregunta>) bundle.getSerializable("restoPreguntasImagen");
                restoPreguntas = (ArrayList<Pregunta>) bundle.getSerializable("restoPreguntas");

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

        preguntas = anadirPreguntas();
        restoPreguntasImagen = (ArrayList<Pregunta>) preguntas.clone();

        jugar();

        respuestaImagen1.setOnClickListener(v -> {
            if (numBotonCorrecto == 1) {
                puntosPartida+=3;
                Toast.makeText(getContext(), "¡Correcto!", Toast.LENGTH_SHORT).show();
                tipoPregunta(view, respuestaImagen1, respuestaImagen2, respuestaImagen3, respuestaImagen4);
            }
            else{
                puntosPartida-=2;
                Toast.makeText(getContext(), "¡Has Fallado!", Toast.LENGTH_SHORT).show();
                tipoPregunta(view, respuestaImagen1, respuestaImagen2, respuestaImagen3, respuestaImagen4);
            }
            Log.i("Boton1", "Boton1 pulsado");


        });
        //Boton pulsado2
        respuestaImagen2.setOnClickListener(v -> {
            if (numBotonCorrecto == 2) {
                puntosPartida+=3;
                Toast.makeText(getContext(), "¡Correcto!", Toast.LENGTH_SHORT).show();
                tipoPregunta(view, respuestaImagen1, respuestaImagen2, respuestaImagen3, respuestaImagen4);
            }
            else{
                puntosPartida-=2;
                Toast.makeText(getContext(), "¡Has Fallado!", Toast.LENGTH_SHORT).show();
                tipoPregunta(view, respuestaImagen1, respuestaImagen2, respuestaImagen3, respuestaImagen4);
            }
            Log.i("Boton2", "Boton2 pulsado");

        });
        //Boton pulsado3
        respuestaImagen3.setOnClickListener(v -> {
            if (numBotonCorrecto == 3) {
                puntosPartida+=3;
                Toast.makeText(getContext(), "¡Correcto!", Toast.LENGTH_SHORT).show();
                tipoPregunta(view, respuestaImagen1, respuestaImagen2, respuestaImagen3, respuestaImagen4);
            }
            else{
                puntosPartida-=2;
                Toast.makeText(getContext(), "¡Has Fallado!", Toast.LENGTH_SHORT).show();
                tipoPregunta(view, respuestaImagen1, respuestaImagen2, respuestaImagen3, respuestaImagen4);
            }
            Log.i("Boton3", "Boton3 pulsado");


        });
        //Boton pulsado4
        respuestaImagen4.setOnClickListener(v -> {
            if (numBotonCorrecto == 4) {
                puntosPartida+=3;
                Toast.makeText(getContext(), "¡Correcto!", Toast.LENGTH_SHORT).show();
                tipoPregunta(view, respuestaImagen1, respuestaImagen2, respuestaImagen3, respuestaImagen4);
            }
            else{
                puntosPartida-=2;
                Toast.makeText(getContext(), "¡Has Fallado!", Toast.LENGTH_SHORT).show();
                tipoPregunta(view, respuestaImagen1, respuestaImagen2, respuestaImagen3, respuestaImagen4);
            }
            Log.i("Boton4", "Boton4 pulsado");

        });

    }

    public void jugar(){

        int numero = (int) (Math.random() * preguntas.size());

        switch(numero){

            case 0:
                idImagen = getResources().getIdentifier("sagrada_familia", "drawable", getActivity().getPackageName());
                imageView.setImageResource(idImagen);
                preguntaElegida = preguntas.get(0);
                preguntaImagen.setText(preguntaElegida.getPregunta());
                numBotonCorrecto = elegirBotonCorrecto(preguntaElegida);
                elegirBotonesIncorrectos(numBotonCorrecto, preguntaElegida);
                restoPreguntasImagen.remove(0);
                break;
            case 1:
                idImagen = getResources().getIdentifier("torre_eiffel", "drawable", getActivity().getPackageName());
                imageView.setImageResource(idImagen);
                preguntaElegida = preguntas.get(1);
                preguntaImagen.setText(preguntaElegida.getPregunta());
                numBotonCorrecto = elegirBotonCorrecto(preguntaElegida);
                elegirBotonesIncorrectos(numBotonCorrecto, preguntaElegida);
                restoPreguntasImagen.remove(1);
                break;
            case 2:
                idImagen = getResources().getIdentifier("coliseo", "drawable", getActivity().getPackageName());
                imageView.setImageResource(idImagen);
                preguntaElegida = preguntas.get(2);
                preguntaImagen.setText(preguntaElegida.getPregunta());
                numBotonCorrecto = elegirBotonCorrecto(preguntaElegida);
                elegirBotonesIncorrectos(numBotonCorrecto, preguntaElegida);
                restoPreguntasImagen.remove(2);
                break;
            case 3:
                idImagen = getResources().getIdentifier("gran_muralla_china", "drawable", getActivity().getPackageName());
                imageView.setImageResource(idImagen);
                preguntaElegida = preguntas.get(3);
                preguntaImagen.setText(preguntaElegida.getPregunta());
                numBotonCorrecto = elegirBotonCorrecto(preguntaElegida);
                elegirBotonesIncorrectos(numBotonCorrecto, preguntaElegida);
                restoPreguntasImagen.remove(3);
                break;
            case 4:
                idImagen = getResources().getIdentifier("machu_picchu", "drawable", getActivity().getPackageName());
                imageView.setImageResource(idImagen);
                preguntaElegida = preguntas.get(4);
                preguntaImagen.setText(preguntaElegida.getPregunta());
                numBotonCorrecto = elegirBotonCorrecto(preguntaElegida);
                elegirBotonesIncorrectos(numBotonCorrecto, preguntaElegida);
                restoPreguntasImagen.remove(4);
                break;
            case 5:
                idImagen = getResources().getIdentifier("taj_mahal", "drawable", getActivity().getPackageName());
                imageView.setImageResource(idImagen);
                preguntaElegida = preguntas.get(5);
                preguntaImagen.setText(preguntaElegida.getPregunta());
                numBotonCorrecto = elegirBotonCorrecto(preguntaElegida);
                elegirBotonesIncorrectos(numBotonCorrecto, preguntaElegida);
                restoPreguntasImagen.remove(5);
                break;
            case 6:
                idImagen = getResources().getIdentifier("cristo_redentor", "drawable", getActivity().getPackageName());
                imageView.setImageResource(idImagen);
                preguntaElegida = preguntas.get(6);
                preguntaImagen.setText(preguntaElegida.getPregunta());
                numBotonCorrecto = elegirBotonCorrecto(preguntaElegida);
                elegirBotonesIncorrectos(numBotonCorrecto, preguntaElegida);
                restoPreguntasImagen.remove(6);
                break;
            case 7:
                idImagen = getResources().getIdentifier("petra", "drawable", getActivity().getPackageName());
                imageView.setImageResource(idImagen);
                preguntaElegida = preguntas.get(7);
                preguntaImagen.setText(preguntaElegida.getPregunta());
                numBotonCorrecto = elegirBotonCorrecto(preguntaElegida);
                elegirBotonesIncorrectos(numBotonCorrecto, preguntaElegida);
                restoPreguntasImagen.remove(7);
                break;
            case 8:
                idImagen = getResources().getIdentifier("chichen_itza", "drawable", getActivity().getPackageName());
                imageView.setImageResource(idImagen);
                preguntaElegida = preguntas.get(8);
                preguntaImagen.setText(preguntaElegida.getPregunta());
                numBotonCorrecto = elegirBotonCorrecto(preguntaElegida);
                elegirBotonesIncorrectos(numBotonCorrecto, preguntaElegida);
                restoPreguntasImagen.remove(8);
                break;
            case 9:
                idImagen = getResources().getIdentifier("coloso_de_rodas", "drawable", getActivity().getPackageName());
                imageView.setImageResource(idImagen);
                preguntaElegida = preguntas.get(9);
                preguntaImagen.setText(preguntaElegida.getPregunta());
                numBotonCorrecto = elegirBotonCorrecto(preguntaElegida);
                elegirBotonesIncorrectos(numBotonCorrecto, preguntaElegida);
                restoPreguntasImagen.remove(9);
                break;
            case 10:
                idImagen = getResources().getIdentifier("piramides_de_keops", "drawable", getActivity().getPackageName());
                imageView.setImageResource(idImagen);
                preguntaElegida = preguntas.get(10);preguntaImagen.setText(preguntaElegida.getPregunta());
                numBotonCorrecto = elegirBotonCorrecto(preguntaElegida);
                elegirBotonesIncorrectos(numBotonCorrecto, preguntaElegida);
                restoPreguntasImagen.remove(10);

                break;
            case 11:
                idImagen = getResources().getIdentifier("mausoleo_de_halicarnaso", "drawable", getActivity().getPackageName());
                imageView.setImageResource(idImagen);
                preguntaElegida = preguntas.get(11);
                preguntaImagen.setText(preguntaElegida.getPregunta());
                numBotonCorrecto = elegirBotonCorrecto(preguntaElegida);
                elegirBotonesIncorrectos(numBotonCorrecto, preguntaElegida);
                restoPreguntasImagen.remove(11);
                break;
            case 12:
                idImagen = getResources().getIdentifier("templo_de_artemisa", "drawable", getActivity().getPackageName());
                imageView.setImageResource(idImagen);
                preguntaElegida = preguntas.get(12);
                preguntaImagen.setText(preguntaElegida.getPregunta());
                numBotonCorrecto = elegirBotonCorrecto(preguntaElegida);
                elegirBotonesIncorrectos(numBotonCorrecto, preguntaElegida);
                restoPreguntasImagen.remove(12);
                break;
        }
        numpreguntas--;
    }

    public int elegirBotonCorrecto(Pregunta preguntaElegida) {

        int numBotonCorrecto = (int) (Math.random() * 4);

        if (numBotonCorrecto == 0) {
            respuestaImagen1.setText(preguntaElegida.getRespuesta());
        } else if (numBotonCorrecto == 1) {
            respuestaImagen2.setText(preguntaElegida.getRespuesta());
        } else if (numBotonCorrecto == 2) {
            respuestaImagen3.setText(preguntaElegida.getRespuesta());
        } else {
            respuestaImagen4.setText(preguntaElegida.getRespuesta());
        }
        return numBotonCorrecto;
    }

    public void elegirBotonesIncorrectos(int numBotonCorrecto, Pregunta preguntaElegida){

        Collections.shuffle(restoPreguntasImagen);
        if(numBotonCorrecto == 0){
            respuestaImagen2.setText(restoPreguntasImagen.get(0).getRespuesta());
            respuestaImagen3.setText(restoPreguntasImagen.get(1).getRespuesta());
            respuestaImagen4.setText(restoPreguntasImagen.get(2).getRespuesta());
        }
        else if(numBotonCorrecto == 1){
            respuestaImagen1.setText(restoPreguntasImagen.get(0).getRespuesta());
            respuestaImagen3.setText(restoPreguntasImagen.get(1).getRespuesta());
            respuestaImagen4.setText(restoPreguntasImagen.get(2).getRespuesta());
        }
        else if(numBotonCorrecto == 2){
            respuestaImagen1.setText(restoPreguntasImagen.get(0).getRespuesta());
            respuestaImagen2.setText(restoPreguntasImagen.get(1).getRespuesta());
            respuestaImagen4.setText(restoPreguntasImagen.get(2).getRespuesta());
        }
        else{
            respuestaImagen1.setText(restoPreguntasImagen.get(0).getRespuesta());
            respuestaImagen2.setText(restoPreguntasImagen.get(1).getRespuesta());
            respuestaImagen3.setText(restoPreguntasImagen.get(2).getRespuesta());
        }
    }

    public ArrayList<Pregunta> anadirPreguntas () {
        Pregunta pregunta = new Pregunta("¿Como se llama?", "Sagrada Familia", 0);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Como se llama?", "Torre Eiffel", 1);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Como se llama?", "Coliseo", 2);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Como se llama?", "Gran Muralla China", 3);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Como se llama?", "Machu Picchu", 4);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Como se llama?", "Taj Mahal", 5);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Como se llama?", "Cristo Redentor", 6);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Como se llama?", "Petra", 7);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Como se llama?", "Chichen Itza", 8);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Como se llama?", "Coloso de Rodas", 9);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Como se llama?", "Pirámide de Keops", 10);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Como se llama?", "Mausoleo de Halicarnaso", 11);
        preguntas.add(pregunta);
        pregunta = new Pregunta("¿Como se llama?", "Templo de Artemisa", 12);
        preguntas.add(pregunta);
        return preguntas;
    }
    public void tipoPregunta(View view, Button respuesta1Button, Button respuesta2Button, Button respuesta3Button, Button respuesta4Button){

        if(numpreguntas > 0) {
            //Genera un numero random entre 0 y 1
            int tipoPregunta = (int) (Math.random() * 3);
            if (tipoPregunta == 0) {
                jugar();
            }
            else if(tipoPregunta == 1){
                Bundle result = new Bundle();
                numpreguntas--;
                result.putInt("numpreguntasText", numpreguntas);
                result.putInt("puntosPartidaText", puntosPartida);
                result.putSerializable("restoPreguntasText", restoPreguntas);
                getParentFragmentManager().setFragmentResult("variablesImagenText", result);
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.radioPreguntasFragment);
            }
            else{
                Bundle result = new Bundle();
                numpreguntas--;
                result.putInt("numeroPreguntas", numpreguntas);
                result.putInt("puntosPartida", puntosPartida);
                result.putSerializable("restoPreguntasImagen", restoPreguntasImagen);
                result.putSerializable("restoPreguntas", restoPreguntas);
                getParentFragmentManager().setFragmentResult("variablesImagenRadio", result);
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