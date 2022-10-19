package com.example.quiz_practica1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InicioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InicioFragment extends Fragment {

    int numeroPreguntas = 9;

    public InicioFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(view);

        Button jugar = view.findViewById(R.id.jugarButton);

        jugar.setOnClickListener(v -> {
            int tipoPregunta = (int) (Math.random() * 3);

            if(tipoPregunta == 0){
                Bundle result = new Bundle();
                result.putInt("numeroPreguntas", numeroPreguntas);
                getParentFragmentManager().setFragmentResult("Main_a_Text", result);
                navController.navigate(R.id.textPreguntasFragment);
            }
            else if(tipoPregunta == 1){
                Bundle result = new Bundle();
                result.putInt("numeroPreguntas", numeroPreguntas);
                getParentFragmentManager().setFragmentResult("Main_a_Radio", result);
                navController.navigate(R.id.radioPreguntasFragment);
            }
            else{
                Bundle result = new Bundle();
                result.putInt("numeroPreguntas", numeroPreguntas);
                getParentFragmentManager().setFragmentResult("Main_a_Img", result);
                navController.navigate(R.id.imagenesFragment);
            }
        });
    }
}