package com.example.quiz_practica1;

import java.util.ArrayList;

public class Pregunta {
    private String pregunta;
    private String respuesta;
    int id;

    public Pregunta(String pregunta, String respuesta, int id) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getId() {
        return id;
    }
}
