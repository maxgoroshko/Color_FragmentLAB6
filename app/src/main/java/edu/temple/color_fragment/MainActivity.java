package edu.temple.color_fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements PalleteActivity.SelectedColor {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        PalleteActivity colorSPinner = PalleteActivity.newInstance(getResources().getStringArray(R.array.colors));

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.spinnerFragment, colorSPinner)
                .commit();

    }

        public void onSelectedColor(String color)
        {
            CanvasActivity canvasFragment1 = CanvasActivity.newInstance(color);

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.canvasFragment, canvasFragment1)
                    .commit();

    }
}
