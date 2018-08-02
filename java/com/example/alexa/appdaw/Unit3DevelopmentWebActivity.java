package com.example.alexa.appdaw;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Unit3DevelopmentWebActivity extends AppCompatActivity implements ListUnitDevelopmentWebFragment.OnFragmentInteractionListener, DetailUnitDevelopmentWebFragment.OnFragmentInteractionListener, CommunicateFragment{

    ListUnitDevelopmentWebFragment listThemeFragment3;
    DetailUnitDevelopmentWebFragment detailThemeFragment3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit3_development_web);

        if (findViewById(R.id.contenedorFragment)!=null){
            UtilitiesUnits.PORTRAIT=true;
            if (savedInstanceState!=null){
                return;
            }
            listThemeFragment3 = new ListUnitDevelopmentWebFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment, listThemeFragment3).commit();
        }else {
            UtilitiesUnits.PORTRAIT=false;
        }
    }

    public void submitUnits(ThemesUnits theme){
        detailThemeFragment3 = (DetailUnitDevelopmentWebFragment)this.getSupportFragmentManager().findFragmentById(R.id.fra_detail);

        if (detailThemeFragment3!=null && findViewById(R.id.contenedorFragment)==null){
            detailThemeFragment3.assignInformation(theme);
        }else {
            detailThemeFragment3 = new DetailUnitDevelopmentWebFragment();
            Bundle bundleEnvio = new Bundle();
            bundleEnvio.putSerializable("object", theme);
            detailThemeFragment3.setArguments(bundleEnvio);

            getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment, detailThemeFragment3).addToBackStack(null).commit();
        }
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
