package com.example.alexa.appdaw;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class Unit1EngineeringWebActivity extends AppCompatActivity implements ListUnitEngineeringWebFragment.OnFragmentInteractionListener, DetailUnitEngineeringWebFragment.OnFragmentInteractionListener, CommunicateFragment {

    ListUnitEngineeringWebFragment listThemeFragment;
    DetailUnitEngineeringWebFragment detailThemeFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit1_engineering_web);
        if (findViewById(R.id.contenedorFragment)!=null){
            UtilitiesUnits.PORTRAIT=true;
            if (savedInstanceState!=null){
                return;
            }
            listThemeFragment = new ListUnitEngineeringWebFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment, listThemeFragment).commit();
        }else {
            UtilitiesUnits.PORTRAIT=false;
        }
    }

    public void submitUnits(ThemesUnits theme){
        detailThemeFragment = (DetailUnitEngineeringWebFragment) this.getSupportFragmentManager().findFragmentById(R.id.fra_detail);

        if (detailThemeFragment!=null && findViewById(R.id.contenedorFragment)==null){
            detailThemeFragment.assignInformation(theme);
        }else {
            detailThemeFragment = new DetailUnitEngineeringWebFragment();
            Bundle bundleEnvio = new Bundle();
            bundleEnvio.putSerializable("object", theme);
            detailThemeFragment.setArguments(bundleEnvio);

            getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment, detailThemeFragment).addToBackStack(null).commit();
        }
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
