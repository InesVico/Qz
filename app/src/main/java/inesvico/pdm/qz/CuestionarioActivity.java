package inesvico.pdm.qz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class CuestionarioActivity extends AppCompatActivity {

    private Button respuesta1, respuesta2, respuesta3, respuesta4;
    private TextView numPregunta, pregunta;

    private Cuestionario mCuestionario = new Cuestionario();
    private String mRespuesta;
    private int mScore = 0;
    private int mPreguntasHechas = 0;
    private int mNumPreguntas = mCuestionario.mPreguntas.length;

    private Random r;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregunta);

        respuesta1 = (Button) findViewById(R.id.Respuesta1);
        respuesta2 = (Button) findViewById(R.id.Respuesta2);
        respuesta3 = (Button) findViewById(R.id.Respuesta3);
        respuesta4 = (Button) findViewById(R.id.Respuesta4);
        numPregunta = (TextView) findViewById(R.id.numPregunta);
        pregunta = (TextView) findViewById(R.id.Pregunta);

        numPregunta.setText("PREGUNTA"+mPreguntasHechas+"/"+mNumPreguntas);
        nuevaPregunta(r.nextInt(mNumPreguntas));

        respuesta1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(respuesta1.getText() == mRespuesta){
                    mScore++;
                    mNumPreguntas++;
                    nuevaPregunta(r.nextInt(mNumPreguntas));
                }

            }
        });
        respuesta2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

            }
        });
        respuesta3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

            }
        });
        respuesta4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

            }
        });
    }

    private void nuevaPregunta(int num) {
        pregunta.setText(mCuestionario.getPreguntas(num));
        respuesta1.setText(mCuestionario.getRespuesta1(num));
        respuesta2.setText(mCuestionario.getRespuesta2(num));
        respuesta3.setText(mCuestionario.getRespuesta3(num));
        respuesta4.setText(mCuestionario.getRespuesta4(num));

        mRespuesta = mCuestionario.getRespuestaCorrecta(num);
    }}
