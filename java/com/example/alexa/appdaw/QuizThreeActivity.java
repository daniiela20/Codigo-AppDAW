package com.example.alexa.appdaw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizThreeActivity extends AppCompatActivity {
    private QuestionLibraryThree mQuestionLibrary = new QuestionLibraryThree();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button quit;


    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;
    private int arregloPreg[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_three);

        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        quit = (Button)findViewById(R.id.quit);
        arregloPreg=new int[5];

        quit.setEnabled(false);

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ScoreThreeActivity.class);
                startActivity(intent);
                savePoints();
            }
        });


        updateQuestion();

        //Start of Button Listener for Button1
        mButtonChoice1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice1.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(QuizThreeActivity.this, "Correcta", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(QuizThreeActivity.this, "Incorrecta", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button1

        //Start of Button Listener for Button2
        mButtonChoice2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice2.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(QuizThreeActivity.this, "Correcta", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(QuizThreeActivity.this, "Incorrecta", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button2


        //Start of Button Listener for Button3
        mButtonChoice3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here

                if (mButtonChoice3.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optiona
                    Toast.makeText(QuizThreeActivity.this, "Correcta", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(QuizThreeActivity.this, "Incorrecta", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button3





    }



    private void updateQuestion()
    {
        try {

            generaArregloNum();
            mQuestionView.setText(mQuestionLibrary.getQuestion(arregloPreg[mQuestionNumber]));
            mButtonChoice1.setText(mQuestionLibrary.getChoice1(arregloPreg[mQuestionNumber]));
            mButtonChoice2.setText(mQuestionLibrary.getChoice2(arregloPreg[mQuestionNumber]));
            mButtonChoice3.setText(mQuestionLibrary.getChoice3(arregloPreg[mQuestionNumber]));

            mAnswer = mQuestionLibrary.getCorrectAnswer(arregloPreg[mQuestionNumber]);
            mQuestionNumber++;

            if(mQuestionNumber>5){
                Toast.makeText(QuizThreeActivity.this, "SE HA FINALIZADO EL QUIZ", Toast.LENGTH_LONG).show();
                mButtonChoice1.setEnabled(false);
                mButtonChoice2.setEnabled(false);
                mButtonChoice3.setEnabled(false);
                quit.setEnabled(true);
            }


        }catch (Exception e){
            mButtonChoice1.setEnabled(false);
            mButtonChoice2.setEnabled(false);
            mButtonChoice3.setEnabled(false);
            quit.setEnabled(true);
            Toast.makeText(QuizThreeActivity.this, "Se ha finalizado el quiz", Toast.LENGTH_LONG).show();

        }
    }

    private void savePoints() {
        mScoreView.setText("" + mScore);
        //Para poder lanzar otra activity se utiliza la clase Intent
        Intent intent = new Intent(QuizThreeActivity.this,
                ScoreThreeActivity.class);
        //Creamos la información en un Bundle
        Bundle b = new Bundle();
        b.putString("Puntos", mScoreView.getText().toString());

        //Se añade la información al Intent
        intent.putExtras(b);
        startActivity(intent); // Se inicia la otra Activity
        finish();
    }


    private void updateScore(int point) {
        mScoreView.setText("" + mScore);

    }

    private void generaArregloNum(){
        for(int i=0;i<arregloPreg.length;i++){
            // Producir nuevo int aleatorio entre 0 y 99
            int intAletorio=(int)(Math.random()*9)+1;
            for (int j=0;j<i;j++){
                if (arregloPreg[j]==intAletorio)
                    intAletorio=(int)(Math.random()*9)+1;
            }
            arregloPreg[i]=intAletorio;
            System.out.println(arregloPreg[i]);

        }

    }

}
