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
    private static final String ARG_PARAM2 = "colorsShow";
    private String[] color, colorsShow;


    public PalleteActivity(){}

    private SelectedColor fragmentParent;


    public static PalleteActivity newInstance(String[] color,String[] colorsShow) {
        PalleteActivity fragment = new PalleteActivity();
        Bundle args = new Bundle();
        args.putStringArray(ARG_PARAM1, color);
        args.putStringArray(ARG_PARAM2, colorsShow);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            color = getArguments().getStringArray(ARG_PARAM1);
            colorsShow = getArguments().getStringArray(ARG_PARAM2);
        }
        else {
            throw new NullPointerException();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pallete, container, false);
        ColorAdapter colorAdapter = new ColorAdapter(getActivity(), color, colorsShow);
        Spinner spinner = view.findViewById(R.id.spinner2);
        spinner.setAdapter(colorAdapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String colorName = color[position];
                fragmentParent.onSelectedColor(colorName);
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
        if (context instanceof SelectedColor) {
            fragmentParent = (SelectedColor) context;
        }
    }



    public interface SelectedColor {
        // TODO: Update argument type and name
        void onSelectedColor(String colorName);
    }
}
