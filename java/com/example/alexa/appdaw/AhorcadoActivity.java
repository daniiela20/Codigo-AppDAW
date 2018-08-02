package com.example.alexa.appdaw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;

public class AhorcadoActivity extends AppCompatActivity {

    String arreglo_Imagenes[]={"ahorcado0","ahorcado1","ahorcado2","ahorcado3","ahorcado4","ahorcado5",
            "ahorcado6","ahorcado7","ahorcado8","ahorcadowin"};
    String arreglo_palabra[]={"HTML","CSS","BOOTSTRAP","JAVASCRIPT","AJAX"};
    String arreglo_pistas[]={"Es un lenguaje de etiquetas para nevegadores Web",
            "Se define la apariencia, formato colores de una página Web",
            "Libreria para apariencia de Web",
            "Lenguaje deprogramación popular",
            "Convergencia de varias tecnologías"};
    private ImageView imgAhorcado;
    private TextView txtPalabraBuscar;
    private TextView txtPista;
    private Button btnMostrar;
    private Button btnBuscar;
    private Button btnOut;
    private EditText edLetra;
    private String palabraGenerada;
    String mascara="";
    private int cont=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahorcado);

        imgAhorcado = (ImageView)findViewById(R.id.imgAhorcado);
        txtPalabraBuscar = (TextView)findViewById(R.id.txt_palabra);
        txtPista = (TextView)findViewById(R.id.txt_pista);
        btnMostrar = (Button)findViewById(R.id.button);
        btnBuscar =  (Button)findViewById(R.id.button2);
        edLetra = (EditText)findViewById(R.id.editText1);
        btnOut = (Button)findViewById(R.id.btnOut);

        btnMostrar.setEnabled(false);
        cargarPalabra();

        /*btnOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_about = new Intent(getApplicationContext(), UnitOneActivity.class);
                startActivity(go_about);
            }
        });*/



        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarPalabra();
                btnOut.setVisibility(View.INVISIBLE);
                btnMostrar.setVisibility(View.INVISIBLE);
            }
        });


        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                char letra=edLetra.getText().toString().toUpperCase().charAt(0);

                boolean encontrada= false;
                for (int i=0;i<palabraGenerada.length();i++){

                    if(palabraGenerada.charAt(i)==letra){
                        char[] tempCharArray = mascara.toCharArray();
                        tempCharArray[i] = letra; // Donde 'x' es la posición que buscas.
                        mascara = String.valueOf(tempCharArray);
                        edLetra.setText("");
                        //edLetra.setHint("Escribe una letra para buscarla");
                        Toast.makeText(AhorcadoActivity.this, "Letra Correcta", Toast.LENGTH_SHORT).show();
                        encontrada = true;



                    }else{

                        //

                        //Toast
                        edLetra.setText("");
                        //edLetra.setHint("Escribe una letra para buscarla");


                        //Cambiar imagen hacer un contador
                    }
                }
                if (encontrada == false){cont++;
                    Toast.makeText(AhorcadoActivity.this, "Letra Incorrecta", Toast.LENGTH_SHORT).show();
                    cambio_imagen(cont);
                    if(cont==7){
                        //btnOut.setVisibility(View.VISIBLE);
                        btnMostrar.setVisibility(View.VISIBLE);
                        Toast.makeText(AhorcadoActivity.this, "Termino de Oportunidades", Toast.LENGTH_SHORT).show();
                        btnMostrar.setEnabled(true);

                    }

                }

                int comple = mascara.indexOf('*');
                if(comple == -1){
                    Toast.makeText(AhorcadoActivity.this, "Felicidades", Toast.LENGTH_SHORT).show();
                    btnMostrar.setEnabled(true);
                    cambio_imagen(9);

                    //btnOut.setVisibility(View.VISIBLE);
                    btnMostrar.setVisibility(View.VISIBLE);
                }

                txtPalabraBuscar.setText(mascara);

            }
        });

    }


    public void cargarPalabra(){
        cambio_imagen(0);
        Random aleatorio = new Random(System.currentTimeMillis());
        // Producir nuevo int aleatorio entre 0 y 99
        int intAletorio = aleatorio.nextInt(4) ;
        palabraGenerada = arreglo_palabra[intAletorio];

        int tamanio = arreglo_palabra[intAletorio].length();
        mascara="";
        cont=0;
        for (int i=1;i<=tamanio;i++){
            mascara=mascara+"*";
        }
        txtPalabraBuscar.setText(mascara);
        txtPista.setText(arreglo_pistas[intAletorio]);
        // Toast.makeText(MainActivity.this, "Se ha generado el numero" + intAletorio, Toast.LENGTH_LONG).show();


    }
    void cambio_imagen(int numero){
        int id = getResources().getIdentifier(arreglo_Imagenes[numero],"drawable",getPackageName());
        imgAhorcado.setImageResource(id);

    }
}
