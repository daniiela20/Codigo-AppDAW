package com.example.alexa.appdaw;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class Unit2ArchitectureInformationActivity extends AppCompatActivity implements ListUnitArchitectureInformationFragment.OnFragmentInteractionListener, DetailUnitArchitectureInformationFragment.OnFragmentInteractionListener, CommunicateFragment {

    ListUnitArchitectureInformationFragment listThemeFragment2;
    DetailUnitArchitectureInformationFragment detailThemeFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2_architecture_information);
        if (findViewById(R.id.contenedorFragment)!=null){
            UtilitiesUnits.PORTRAIT=true;
            if (savedInstanceState!=null){
                return;
            }
            listThemeFragment2 = new ListUnitArchitectureInformationFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment, listThemeFragment2).commit();
        }else {
            UtilitiesUnits.PORTRAIT=false;
        }
    }

    public void submitUnits(ThemesUnits theme){
        detailThemeFragment2 = (DetailUnitArchitectureInformationFragment) this.getSupportFragmentManager().findFragmentById(R.id.fra_detail);

        if (detailThemeFragment2!=null && findViewById(R.id.contenedorFragment)==null){
            detailThemeFragment2.assignInformation(theme);
        }else {
            detailThemeFragment2 = new DetailUnitArchitectureInformationFragment();
            Bundle bundleEnvio = new Bundle();
            bundleEnvio.putSerializable("object", theme);
            detailThemeFragment2.setArguments(bundleEnvio);

            getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment, detailThemeFragment2).addToBackStack(null).commit();
        }
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
