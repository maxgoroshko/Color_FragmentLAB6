package edu.temple.color_fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Resources res = this.getResources();
        final String [] gridlabels = res.getStringArray(R.array.colors);


        final Spinner spinner = findViewById(R.id.spinner);
        ColorAdapter adapter = new ColorAdapter(this,gridlabels);
        spinner.setAdapter(adapter);
        spinner.setSelection(0,false);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }
}
