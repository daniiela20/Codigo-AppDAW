package com.example.alexa.appdaw;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FirstTemActivity extends AppCompatActivity {
    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tem_first);
        myDialog = new Dialog(this);
    }

    public void ShowPopup (View v){
        TextView textClose;
        myDialog.setContentView(R.layout.activity_cont_one);
        textClose = (TextView) myDialog.findViewById(R.id.text_close_unit1);

        textClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }

    public void ShowPopupII (View v){
        TextView textClose;
        myDialog.setContentView(R.layout.activity_cont_two);
        textClose = (TextView) myDialog.findViewById(R.id.text_close_unit2);

        textClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }

    public void ShowPopupIII (View v){
        TextView textClose;
        myDialog.setContentView(R.layout.activity_cont_three);
        textClose = (TextView) myDialog.findViewById(R.id.text_close_unit3);

        textClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }

    public void ShowPopupIV (View v){
        TextView textClose;
        myDialog.setContentView(R.layout.activity_cont_four);
        textClose = (TextView) myDialog.findViewById(R.id.text_close_unit4);

        textClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }

    public void ShowPopupV (View v){
        TextView textClose;
        myDialog.setContentView(R.layout.activity_cont_five);
        textClose = (TextView) myDialog.findViewById(R.id.text_close_unit5);

        textClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        myDialog.show();
    }
}



