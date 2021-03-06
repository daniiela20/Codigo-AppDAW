package com.example.alexa.appdaw;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DetailUnitArchitectureInformationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DetailUnitArchitectureInformationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailUnitArchitectureInformationFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    TextView texDescription;
    ImageView imaDetail;
    TextView texTitle;
    TextView texDescriptionTwo;
    TextView texDescripionThree;
    ImageView imaFirst;
    ImageView imaSecond;
    ImageView imaThird;

    public DetailUnitArchitectureInformationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailUnitArchitectureInformationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailUnitArchitectureInformationFragment newInstance(String param1, String param2) {
        DetailUnitArchitectureInformationFragment fragment = new DetailUnitArchitectureInformationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_detail_unit_architecture_information, container, false);

        texDescription = (TextView) view.findViewById(R.id.tex_description_theme);
        imaDetail = (ImageView) view.findViewById(R.id.ima_detail_theme);
        texTitle = (TextView) view.findViewById(R.id.tex_title_theme);
        texDescriptionTwo = (TextView)view.findViewById(R.id.tex_description_two);
        texDescripionThree = (TextView) view.findViewById(R.id.tex_description_three);
        imaFirst = (ImageView) view.findViewById(R.id.ima_firts_theme);
        imaSecond = (ImageView) view.findViewById(R.id.ima_second_theme);
        imaThird = (ImageView) view.findViewById(R.id.ima_third_theme);

        Bundle objectThemes= getArguments();
        ThemesUnits myTheme = null;
        if (objectThemes != null){
            myTheme = (ThemesUnits) objectThemes.getSerializable("object");

            assignInformation(myTheme);

        }
        return view;
    }

    public void assignInformation(ThemesUnits myTheme){
        imaDetail.setImageResource(myTheme.getImageDetail());
        texDescription.setText(myTheme.getDescriptionTheme());
        texDescriptionTwo.setText(myTheme.getDescriptionThemeTwo());
        texDescripionThree.setText(myTheme.getDescripionThemeThree());
        texTitle.setText(myTheme.getTileTheme());
        imaFirst.setImageResource(myTheme.getImageFirst());
        imaSecond.setImageResource(myTheme.getImageSecond());
        imaThird.setImageResource(myTheme.getImageThird());
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
