package com.example.alexa.appdaw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreTwoActivity extends AppCompatActivity {
    private TextView lblConten;
    private Button btnRegresarTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_two);
        //Relacionar con XML
        lblConten = (TextView)findViewById(R.id.lblConten);
        //Se recupera la información del intent
        Bundle bundle = this.getIntent().getExtras();
        //Se muestra el dato en la etiqueta
        lblConten.setText("  ¡¡Felicidades!! Haz Obtenido        " + bundle.getString("Puntos")+ " Aciertos de 5");

        btnRegresarTwo = (Button) findViewById(R.id.btnRegresarTwo);
        btnRegresarTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back_unit_two = new Intent(getApplicationContext(), UnitTwoActivity.class);
                startActivity(back_unit_two);
                finish();
            }
        });

    }
    public void regresar(View v){
        finish();
    }
}
