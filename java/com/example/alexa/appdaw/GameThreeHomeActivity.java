package com.example.alexa.appdaw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class GameThreeHomeActivity extends AppCompatActivity {
    Button btn_jugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_three_home);

        btn_jugar = (Button)findViewById(R.id.btn_jugar);

        btn_jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pag2 = new Intent(GameThreeHomeActivity.this,PlayGameThreeActivity.class);
                startActivity(pag2);
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intent home_gama_three = new Intent(getApplicationContext(), UnitThreeActivity.class);
        startActivity(home_gama_three);

        return super.onKeyDown(keyCode, event);
    }
}

