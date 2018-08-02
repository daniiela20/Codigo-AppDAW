package com.example.alexa.appdaw;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LibraryActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnBookRuby;
    private Button btnBookEcommerce;
    private Button btnBookAppJava;
    private Button btnBookAppWeb;
    private Button btnBookJavaDesing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        btnBookRuby = (Button) findViewById(R.id.btn_book_ruby);
        btnBookRuby.setOnClickListener(this);

        btnBookEcommerce = (Button) findViewById(R.id.btn_book_ecommerce);
        btnBookEcommerce.setOnClickListener(this);

        btnBookAppJava = (Button) findViewById(R.id.btn_book_app_java);
        btnBookAppJava.setOnClickListener(this);

        btnBookAppWeb = (Button) findViewById(R.id.btn_book_app_web);
        btnBookAppWeb.setOnClickListener(this);

        btnBookJavaDesing = (Button) findViewById(R.id.btn_book_java_desing);
        btnBookJavaDesing.setOnClickListener(this);
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_book_ruby:
                Uri urlRuby = Uri.parse("http://pdf.th7.cn/down/files/1602/Head%20First%20Ruby.pdf");
                Intent intentRuby = new Intent(Intent.ACTION_VIEW, urlRuby);
                startActivity(intentRuby);
                break;
            case R.id.btn_book_ecommerce:
                Uri urlEcommerce = Uri.parse("http://serpymedigital.com.ar/wp-content/uploads/2015/10/fundamentos-comercio-electronico.pdf");
                Intent intentEcommerce = new Intent(Intent.ACTION_VIEW, urlEcommerce);
                startActivity(intentEcommerce);
                break;
            case R.id.btn_book_app_java:
                Uri urlJava = Uri.parse("https://www.ittux.edu.mx/sites/default/files/Desarrollo.de_.Aplicaciones.con_.Java_.pdf");
                Intent intentJava = new Intent(Intent.ACTION_VIEW, urlJava);
                startActivity(intentJava);
                break;
            case R.id.btn_book_app_web:
                Uri urlWeb = Uri.parse("http://libros.metabiblioteca.org/bitstream/001/591/1/004%20Desarrollo%20de%20aplicaciones%20web.pdf");
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, urlWeb);
                startActivity(intentWeb);
                break;
            case R.id.btn_book_java_desing:
                Uri urlDesing = Uri.parse("http://enos.itcollege.ee/~jpoial/java/naited/Java-Design-Patterns.pdf");
                Intent intentDesing = new Intent(Intent.ACTION_VIEW, urlDesing);
                startActivity(intentDesing);
                break;


        }
    }


}