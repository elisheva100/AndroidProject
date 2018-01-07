package com.example.owner.takeandgo.controller;

/**
 * Created by Owner on 02/01/2018.
 */

import android.view.View;
import android.widget.ImageView;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

import com.example.owner.takeandgo.R;

public class CustomAdapter extends BaseAdapter {
    Context context;
    int colors[];
    String[] colorNames;
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, int[] colors, String[] colorNames) {
        this.context = applicationContext;
        this.colors = colors;
        this.colorNames = colorNames;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.custom_spinner_items, null);
        ImageView icon = (ImageView) view.findViewById(R.id.imageView);
        TextView names = (TextView) view.findViewById(R.id.textView);
        icon.setImageResource(colors[i]);
        names.setText(colorNames[i]);
        return view;
    }
}

