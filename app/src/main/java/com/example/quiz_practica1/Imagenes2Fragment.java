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

public class Imagenes2Fragment extends Fragment {

    ImageView imagenRespuesta1;
    ImageView imagenRespuesta2;
    ImageView imagenRespuesta3;
    ImageView imagenRespuesta4;
    Button reiniciar;
    TextView pregunta;

    Jugar partida = new Jugar();

    private ArrayList<Pregunta> preguntas = partida.anadirPreguntas2();
    private ArrayList<Pregunta> restoPreguntas;
    private ArrayList<Pregunta> restoPreguntasImagen;
    ArrayList<String> nombreImagenes = partida.nombreImagenes(preguntas);
    private int numeroPreguntas;
    private int puntosPartida;
    private int numImagenCorrecta;
    private int numBotonCorrecto;


    public Imagenes2Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getParentFragmentManager().setFragmentResultListener("Main_a_Img2", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {
                numeroPreguntas = bundle.getInt("numeroPreguntas");
                Log.i("__Entra_deMain_aImg", String.valueOf(numeroPreguntas));
            }
        });
        getParentFragmentManager().setFragmentResultListener("Text_a_Img2", this, new FragmentResultListener() {
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
        getParentFragmentManager().setFragmentResultListener("Radio_a_Img2", this, new FragmentResultListener() {
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
        getParentFragmentManager().setFragmentResultListener("Img_a_Img2", this, new FragmentResultListener() {
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
        return inflater.inflate(R.layout.fragment_imagenes2, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imagenRespuesta1 = view.findViewById(R.id.imagenRespuesta1);
        imagenRespuesta2 = view.findViewById(R.id.imagenRespuesta2);
        imagenRespuesta3 = view.findViewById(R.id.imagenRespuesta3);
        imagenRespuesta4 = view.findViewById(R.id.imagenRespuesta4);
        reiniciar = view.findViewById(R.id.reiniciarButton4);
        pregunta = view.findViewById(R.id.preguntaImagenes2);

        jugar2();

        //Boton atrás que vuelva a la pantalla de inicio
        Button reiniciar = view.findViewById(R.id.reiniciarButton4);
        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_imagenes2Fragment_to_inicioFragment);
            }
        });

        //Listener de las imagenes
        imagenRespuesta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
            }
        });
        imagenRespuesta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
            }
        });
        imagenRespuesta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numBotonCorrecto == 3) {
                    puntosPartida+=3;
                    Toast.makeText(getContext(), "¡Correcto!", Toast.LENGTH_SHORT).show();
                }
                else{
                    puntosPartida-=2;
                    Toast.makeText(getContext(), "¡Has Fallado!", Toast.LENGTH_SHORT).show();
                }
                Log.i("Boton3", "Boton3 pulsado");
                tipoPregunta(view);
            }
        });
        imagenRespuesta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
            }
        });

    }

    public void jugar2(){
        //Numero aleatorio de 0 a restoPreguntasImagen.size()-1
        int numAleatorio = (int) (Math.random() * preguntas.size()-1);
        //Elige una pregunta
        Pregunta preguntaElegida = preguntas.get(numAleatorio);
        System.out.println("Pregunta elegida: " + preguntaElegida.getRespuesta());
        //Coloca el texto de la pregunta en el TextView
        pregunta.setText(preguntaElegida.getRespuesta());
        //Elige un boton correcto y coloca la respuesta correcta en el boton
        System.out.println("Boton correcto: " + numImagenCorrecta);
        //Extrae los nombres de las imagenes y los guarda en un array
        //Coloca la imagen en el ImageView
        int idImagen = getResources().getIdentifier(nombreImagenes.get(numAleatorio), "drawable", getActivity().getPackageName());
        //nombreImagenes.remove(numAleatorio);
        //preguntas.remove(numAleatorio);
        System.out.println("Imagen elegida: " + nombreImagenes.get(numAleatorio));
        elegirBotonCorrecto(idImagen);
        //Elige los botones incorrectos
        elegirBotonesIncorrectos(numBotonCorrecto);
        numeroPreguntas--;
    }

    public void elegirBotonCorrecto(int idImagen) {

        int posicionImagenCorrecto = (int) (Math.random() * 4);

        switch (posicionImagenCorrecto) {
            case 0:
                imagenRespuesta1.setImageResource(idImagen);
                numBotonCorrecto = 1;
                Log.i("Boton Correcto", "Boton 1");
                break;
            case 1:
                imagenRespuesta2.setImageResource(idImagen);
                numBotonCorrecto = 2;
                Log.i("Boton Correcto", "Boton 2");
                break;
            case 2:
                imagenRespuesta3.setImageResource(idImagen);
                numBotonCorrecto = 3;
                Log.i("Boton Correcto", "Boton 3");
                break;
            case 3:
                imagenRespuesta4.setImageResource(idImagen);
                numBotonCorrecto = 4;
                Log.i("Boton Correcto", "Boton 4");
                break;
        }
    }

    public void elegirBotonesIncorrectos(int numBotonCorrecto){

        //Barajar el array
        Collections.shuffle(nombreImagenes);
        int idImagen;

        if(numBotonCorrecto == 1){
            idImagen = getResources().getIdentifier(nombreImagenes.get(0), "drawable", getActivity().getPackageName());
            imagenRespuesta2.setImageResource(idImagen);

            idImagen = getResources().getIdentifier(nombreImagenes.get(1), "drawable", getActivity().getPackageName());
            imagenRespuesta3.setImageResource(idImagen);

            idImagen = getResources().getIdentifier(nombreImagenes.get(2), "drawable", getActivity().getPackageName());
            imagenRespuesta4.setImageResource(idImagen);
        }
        else if(numBotonCorrecto == 2){
            idImagen = getResources().getIdentifier(nombreImagenes.get(0), "drawable", getActivity().getPackageName());
            imagenRespuesta1.setImageResource(idImagen);

            idImagen = getResources().getIdentifier(nombreImagenes.get(1), "drawable", getActivity().getPackageName());
            imagenRespuesta3.setImageResource(idImagen);

            idImagen = getResources().getIdentifier(nombreImagenes.get(2), "drawable", getActivity().getPackageName());
            imagenRespuesta4.setImageResource(idImagen);
        }
        else if(numBotonCorrecto == 3){
            idImagen = getResources().getIdentifier(nombreImagenes.get(0), "drawable", getActivity().getPackageName());
            imagenRespuesta1.setImageResource(idImagen);

            idImagen = getResources().getIdentifier(nombreImagenes.get(1), "drawable", getActivity().getPackageName());
            imagenRespuesta2.setImageResource(idImagen);

            idImagen = getResources().getIdentifier(nombreImagenes.get(2), "drawable", getActivity().getPackageName());
            imagenRespuesta4.setImageResource(idImagen);
        }
        else if(numBotonCorrecto == 4){
            idImagen = getResources().getIdentifier(nombreImagenes.get(0), "drawable", getActivity().getPackageName());
            imagenRespuesta1.setImageResource(idImagen);

            idImagen = getResources().getIdentifier(nombreImagenes.get(1), "drawable", getActivity().getPackageName());
            imagenRespuesta2.setImageResource(idImagen);

            idImagen = getResources().getIdentifier(nombreImagenes.get(2), "drawable", getActivity().getPackageName());
            imagenRespuesta3.setImageResource(idImagen);
        }
    }

    public void tipoPregunta(View view){

        if(numeroPreguntas > 0) {
            //Genera un numero random entre 0 y 3
            int tipoPregunta = (int) (Math.random() * 4);

            if (tipoPregunta == 0) {
                jugar2();
            }
            else if(tipoPregunta == 1){

                Bundle result = new Bundle();
                numeroPreguntas--;
                result.putInt("numeroPreguntas", numeroPreguntas);
                result.putInt("puntosPartida", puntosPartida);
                result.putSerializable("restoPreguntas", restoPreguntas);
                result.putSerializable("restoPreguntasImagen", restoPreguntasImagen);
                getParentFragmentManager().setFragmentResult("Img2_a_Text", result);

                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.textPreguntasFragment);
            }
            else if (tipoPregunta == 2){

                Bundle result = new Bundle();
                numeroPreguntas--;
                result.putInt("numeroPreguntas", numeroPreguntas);
                result.putInt("puntosPartida", puntosPartida);
                result.putSerializable("restoPreguntasImagen", restoPreguntasImagen);
                result.putSerializable("restoPreguntas", restoPreguntas);
                getParentFragmentManager().setFragmentResult("Img2_a_Radio", result);

                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.radioPreguntasFragment);
            }
            else if (tipoPregunta == 3){

                Bundle result = new Bundle();
                numeroPreguntas--;
                result.putInt("numeroPreguntas", numeroPreguntas);
                result.putInt("puntosPartida", puntosPartida);
                result.putSerializable("restoPreguntasImagen", restoPreguntasImagen);
                result.putSerializable("restoPreguntas", restoPreguntas);
                getParentFragmentManager().setFragmentResult("Img2_a_Img", result);

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