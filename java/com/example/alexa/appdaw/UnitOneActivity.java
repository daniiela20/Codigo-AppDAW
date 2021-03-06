package com.example.alexa.appdaw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UnitOneActivity extends AppCompatActivity {
    private Button btn_menu_themes;
    private Button btn_menu_concepts;
    private Button btn_menu_exercises;
    private Button btn_menu_games;
    private Button btn_menu_videos;
    private Button btn_menu_quiz_one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_one);

        btn_menu_themes = (Button) findViewById(R.id.btn_menu_themes);
        btn_menu_themes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_themes = new Intent(getApplicationContext(), Unit1EngineeringWebActivity.class);
                startActivity(go_themes);
            }
        });

        btn_menu_concepts = (Button) findViewById(R.id.btn_menu_concepts);
        btn_menu_concepts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_concepts= new Intent(getApplicationContext(), UoneThemesActivity.class);
                startActivity(go_concepts);
            }
        });

        btn_menu_exercises = (Button) findViewById(R.id.btn_menu_exercises);
        btn_menu_exercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_exercises = new Intent(getApplicationContext(), UoneThemesActivity.class);
                startActivity(go_exercises);
            }
        });

        btn_menu_games = (Button) findViewById(R.id.btn_menu_games);
        btn_menu_games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_games = new Intent(getApplicationContext(), GameTwoActivity.class);
                startActivity(go_games);
            }
        });

        btn_menu_videos = (Button) findViewById(R.id.btn_menu_videos);
        btn_menu_videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_videos = new Intent(getApplicationContext(), UoneThemesActivity.class);
                startActivity(go_videos);
            }
        });

        btn_menu_quiz_one = (Button) findViewById(R.id.btn_menu_quiz_one);
        btn_menu_quiz_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Intent go_quiz = new Intent(getApplicationContext(), QuizOneActivity.class);
                    startActivity(go_quiz);
                    finish();
                }catch (Exception e){
                    Toast.makeText(UnitOneActivity.this, "Error " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intent home = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(home);

        return super.onKeyDown(keyCode, event);
    }
}
