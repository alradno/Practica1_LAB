package com.example.quiz_practica1;

import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class Jugar {


    public boolean seguirJugando(int numpreguntas){
        if(numpreguntas == 0){
            Log.i("Juego", "Terminado");
            return false;
        }else{
            Log.i("Preguntas Restantes", String.valueOf(numpreguntas));
            return true;
        }
    }

    public ArrayList<Pregunta> anadirPreguntasYRespuestas(){
        Pregunta pregunta;
        ArrayList<Pregunta> preguntas = new ArrayList<>();
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
        return preguntas;
    }

}
