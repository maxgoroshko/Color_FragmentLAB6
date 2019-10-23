package edu.temple.color_fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class CanvasActivity extends Fragment {


    private static final String ARG_PARAM1 = "colors";



    private String color;


    public CanvasActivity() {
        // Required empty public constructor
    }

    public static CanvasActivity newInstance(String color) {
        CanvasActivity fragment = new CanvasActivity();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, color);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            color = getArguments().getString(ARG_PARAM1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout view = (LinearLayout) inflater.inflate(R.layout.fragment_canvas, container, false);
        try {
            view.setBackgroundColor(Color.parseColor(color));
        } catch (Exception e){
            view.setBackgroundColor(Color.WHITE);
        }
        return view;
    }
}