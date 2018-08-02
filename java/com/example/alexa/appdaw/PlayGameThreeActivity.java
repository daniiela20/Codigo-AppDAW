package com.example.alexa.appdaw;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlayGameThreeActivity extends AppCompatActivity {
    TextView txt_vidas;
    TextView txt_contador;
    TextView txt_puntos;
    TextView txt_correcto;
    TextView txt_incorrecto;
    ImageView imageView;
    EditText editText;
    Button btn_confirmar;

    String[] resp={"Rails", "Server", "Generate", "Rails"};
    String[] resp2={"rails", "server", "generate", "rails"};
    String[] imagen={"question_one", "question_two", "question_three", "question_one"};

    int intpunto=0;
    int intvidas=3;
    int numerogenerado=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game_three);

        txt_correcto = (TextView) findViewById(R.id.txt_correcto);
        txt_incorrecto = (TextView) findViewById(R.id.txt_incorrecto);

        txt_vidas = (TextView) findViewById(R.id.txt_vidas);
        txt_contador = (TextView) findViewById(R.id.txt_contador);
        txt_puntos = (TextView) findViewById(R.id.txt_puntos);
        imageView = (ImageView) findViewById(R.id.imageView);
        editText = (EditText) findViewById(R.id.editText);
        btn_confirmar = (Button) findViewById(R.id.btn_confirmar);

        establecer_imagen(numerogenerado);



            btn_confirmar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String textoconfirmar = editText.getText().toString().toLowerCase();
                    if (textoconfirmar.equals(resp[numerogenerado]) | textoconfirmar.equals(resp2[numerogenerado])) {

                        txt_correcto.setVisibility(View.VISIBLE);
                        intpunto = intpunto + 1;
                        txt_puntos.setText("Puntos: " + intpunto);
                        esperar1();

                    } else {
                        txt_incorrecto.setVisibility(View.VISIBLE);
                        intvidas = intvidas - 1;
                        txt_vidas.setText("Vidas: " + intvidas);
                        esperar2();

                    }
                    if (intvidas == 0) {
                        Toast.makeText(PlayGameThreeActivity.this, "Se terminaron las vidas", Toast.LENGTH_LONG).show();
                        Intent go_home = new Intent(getApplicationContext(), GameThreeHomeActivity.class);
                        startActivity(go_home);
                        finish();
                    }
                    else if(intpunto == 4){
                        Toast.makeText(PlayGameThreeActivity.this, "Felicidades!! YA GANASTE", Toast.LENGTH_LONG).show();
                        Intent go_home = new Intent(getApplicationContext(), GameThreeHomeActivity.class);
                        startActivity(go_home);
                        finish();
                    }
                }
            });

    }

    void esperar2(){
        new CountDownTimer(2000, 1) {
            @Override
            public void onTick(long millisUntilFinished) {
                btn_confirmar.setVisibility(View.GONE);

            }

            @Override
            public void onFinish() {
                btn_confirmar.setVisibility(View.VISIBLE);
                txt_incorrecto.setVisibility(View.INVISIBLE);
                editText.setText("");
                editText.setHint("Ingrese la respuesa correcta");

            }
        }.start();
    }

    void esperar1(){
        new CountDownTimer(3000, 1) {
            @Override
            public void onTick(long millisUntilFinished) {
                txt_contador.setText(""+(millisUntilFinished/1000 +1));
                btn_confirmar.setVisibility(View.GONE);

            }

            @Override
            public void onFinish() {
                btn_confirmar.setVisibility(View.VISIBLE);
                if (numerogenerado<3)
                    numerogenerado=numerogenerado+1;
                txt_contador.setText("");
                establecer_imagen(numerogenerado);
                txt_correcto.setVisibility(View.INVISIBLE);
                editText.setText("");
                editText.setHint("Ingrese la respuesa correcta");

            }
        }.start();
    }

    void establecer_imagen(int numero){
        try {
            int id = getResources().getIdentifier(imagen[numero], "drawable", getPackageName());
            imageView.setImageResource(id);
        }catch (Exception e){
            System.out.println("Error"+e.getMessage());
        }
    }

}
