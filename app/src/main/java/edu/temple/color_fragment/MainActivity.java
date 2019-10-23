package edu.temple.color_fragment;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements PalleteActivity.SelectedColor {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        PalleteActivity colorSPinner = PalleteActivity.newInstance(getResources().getStringArray(R.array.colors),getResources().getStringArray(R.array.colorsShow));

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.spinnerFragment, colorSPinner)
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
