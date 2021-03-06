package com.example.alexa.appdaw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UnitFiveActivity extends AppCompatActivity {
    private Button btn_menu_themes;
    private Button btn_menu_concepts;
    private Button btn_menu_exercises;
    private Button btn_menu_games;
    private Button btn_menu_videos;
    private Button btn_menu_quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_five);

        btn_menu_themes = (Button) findViewById(R.id.btn_menu_themes);
        btn_menu_themes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_themes = new Intent(getApplicationContext(), UoneThemesActivity.class);
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
                Intent go_games = new Intent(getApplicationContext(), UoneThemesActivity.class);
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

        btn_menu_quiz = (Button) findViewById(R.id.btn_menu_quiz);
        btn_menu_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_quiz = new Intent(getApplicationContext(), UoneThemesActivity.class);
                startActivity(go_quiz);
            }
        });
    }
}
