package edu.temple.color_fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;


public class PalleteActivity extends Fragment {


    private static final String ARG_PARAM1 = "colors";
    private String[] color;

    public PalleteActivity(){}

    private OnFragmentInteractionListener fragmentParent;


    public static PalleteActivity newInstance(String[] color) {
        PalleteActivity fragment = new PalleteActivity();
        Bundle args = new Bundle();
        args.putStringArray(ARG_PARAM1, color);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            color = getArguments().getStringArray(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pallete, container, false);
        ColorAdapter colorAdapter = new ColorAdapter(getActivity(), color);
        Spinner spinner = view.findViewById(R.id.spinner2);
        spinner.setAdapter(colorAdapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String colorName = ((TextView)view).getText().toString();
                fragmentParent.onFragmentInteraction(colorName);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            fragmentParent = (OnFragmentInteractionListener) context;
        }
    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String colorName);
    }
}
