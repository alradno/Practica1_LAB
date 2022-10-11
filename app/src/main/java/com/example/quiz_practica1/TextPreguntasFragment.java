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
 * Use the {@link TextPreguntasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TextPreguntasFragment extends Fragment {

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
        final NavController navController = Navigation.findNavController(view);
        //Boton Atras
        Button atras = view.findViewById(R.id.AtrasButton1);
        atras.setOnClickListener( v ->  {
            navController.popBackStack();
        });
        Button respuesta1 = view.findViewById(R.id.r1FragmentButton);
        Button respuesta2 = view.findViewById(R.id.r2FragmentButton);
        Button respuesta3 = view.findViewById(R.id.r3FragmentButton);
        Button respuesta4 = view.findViewById(R.id.r4FragmentButton);
        respuesta1.setOnClickListener( v ->  {
            //navController.navigate(R.id.action_textPreguntasFragment_to_textPreguntasFragment2);
        });
    }
}