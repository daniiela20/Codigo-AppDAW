package com.example.alexa.appdaw;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnFacebook;
    private Button btnAbout;
    private Button btnTwitter;
    private Button btnPage;
    ImageView imageTemary;
    ImageView imageUnit1;
    ImageView imageUnit2;
    ImageView imageUnit3;
    ImageView imageUnit4;
    ImageView imageUnit5;
    ImageView imageLibrary;
    ImageView imageNotice;
    ImageView imagePodcast;

    //Menu and items variables
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.closes);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Inicio");

        btnAbout = (Button) findViewById(R.id.btn_about);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_about = new Intent(getApplicationContext(), AboutUsActivity.class);
                startActivity(go_about);
            }
        });


        imageTemary = (ImageView) findViewById(R.id.image_temary);
        imageTemary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_tem = new Intent(getApplicationContext(), FirstTemActivity.class);
                startActivity(go_tem);
            }
        });

        imageUnit1 = (ImageView) findViewById(R.id.image_unit1);
        imageUnit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent go_unit1 = new Intent(getApplicationContext(), UnitOneActivity.class);
                    startActivity(go_unit1);
                }catch (Exception e){
                    Toast.makeText(HomeActivity.this, "Error ..." + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        imageUnit2 = (ImageView) findViewById(R.id.image_unit2);
        imageUnit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_unit2 = new Intent(getApplicationContext(), UnitTwoActivity.class);
                startActivity(go_unit2);
            }
        });

        imageUnit3 = (ImageView) findViewById(R.id.image_unit3);
        imageUnit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_unit3 = new Intent(getApplicationContext(), UnitThreeActivity.class);
                startActivity(go_unit3);
            }
        });

        imageUnit4 = (ImageView) findViewById(R.id.image_unit4);
        imageUnit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_unit4 = new Intent(getApplicationContext(), UnitFourActivity.class);
                startActivity(go_unit4);
            }
        });

        imageUnit5 = (ImageView) findViewById(R.id.image_unit5);
        imageUnit5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_unit5 = new Intent(getApplicationContext(), UnitFiveActivity.class);
                startActivity(go_unit5);
            }
        });

        imageLibrary = (ImageView) findViewById(R.id.image_library);
        imageLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_library = new Intent(getApplicationContext(), LibraryActivity.class);
                startActivity(go_library);
            }
        });

        imagePodcast = (ImageView) findViewById(R.id.image_podcast);
        imagePodcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_podcast = new Intent(getApplicationContext(), PodcastActivity.class);
                startActivity(go_podcast);
            }
        });
        imageNotice = (ImageView) findViewById(R.id.image_notice);
        imageNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_notice = new Intent(getApplicationContext(), Noticias.class);
                startActivity(go_notice);
            }
        });

        btnFacebook = (Button) findViewById(R.id.btn_facebook);
        btnFacebook.setOnClickListener(this);

        btnTwitter = (Button)findViewById(R.id.btn_twitter);
        btnTwitter.setOnClickListener(this);

        btnPage = (Button)findViewById(R.id.btn_page);
        btnPage.setOnClickListener(this);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public  void  onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_facebook:
                Uri btnFacebook = Uri.parse("https://www.facebook.com/UTNGDOLORESHIDALGO-222209577812067/?ref=hl");
                Intent intent = new Intent(Intent.ACTION_VIEW, btnFacebook);
                startActivity(intent);
                break;
            case R.id.btn_twitter:
                Uri btnTwitter = Uri.parse("https://twitter.com/UTNGDolores");
                Intent intent1 = new Intent(Intent.ACTION_VIEW, btnTwitter);
                startActivity(intent1);
                break;
            case R.id.btn_page:
                Uri uri = Uri.parse("http://www.utng.edu.mx/");
                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent2);
                break;
        }

    }
}
