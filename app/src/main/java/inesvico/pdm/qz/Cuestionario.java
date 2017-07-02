package inesvico.pdm.qz;

import android.graphics.Bitmap;

/**
 * Created by Inés on 02/07/2017.
 */

public class Cuestionario {

    public String mPreguntas[] = {
      //Aquí van las preguntas
    };

    public String mRespuestas[][] = {
            //Aquí van las respuestas
            {},
            {},
    };

    public Bitmap mRespuestasImagen[][] = {

    };

    public String mRespuestaCorrecta[] = {
            //Aquí establecemos la respuesta correcta por pregunta
    };

    public Bitmap mRespuestaCorrectaImagen[] = {
            
    };

    public String getPreguntas (int a){
        String pregunta = mPreguntas[a];
        return pregunta;
    }
    public String getRespuesta1(int a){
        String respuesta = mRespuestas[a][0];
        return respuesta;
    }
    public String getRespuesta2(int a){
        String respuesta = mRespuestas[a][1];
        return respuesta;
    }
    public String getRespuesta3(int a){
        String respuesta = mRespuestas[a][2];
        return respuesta;
    }
    public String getRespuesta4(int a){
        String respuesta = mRespuestas[a][3];
        return respuesta;
    }
    public String getRespuestaCorrecta(int a){
        String respuesta = mRespuestaCorrecta[a];
        return respuesta;
    }
}
