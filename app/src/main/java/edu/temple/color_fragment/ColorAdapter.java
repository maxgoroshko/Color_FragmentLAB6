package edu.temple.color_fragment;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class ColorAdapter extends BaseAdapter {

    Context context;

    String[] colors,colorsShow;

    public ColorAdapter(Context context, String[] colors, String[] colorsShow) {
        this.context = context;
        this.colors = colors;
        this.colorsShow = colorsShow;
    }
    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int position) {
        return colors[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;

        if (convertView instanceof View){
            textView = (TextView) convertView;
        } else {
            textView = new TextView(context);
        }
        textView.setTextSize(37);
        textView.setText(colorsShow[position]);
        return textView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView textView;

        if (convertView instanceof View){
            textView = (TextView) convertView;
        } else {
            textView = new TextView(context);
        }

        textView.setBackgroundColor(Color.WHITE);
        textView.setTextSize(37);
        textView.setText(colorsShow[position]);

        try {
            textView.setBackgroundColor(Color.parseColor(colors[position]));
        }
        catch(Exception e){}
        return textView;
    }
}
