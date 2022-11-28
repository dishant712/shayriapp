package com.example.newshayari.Apdter;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.newshayari.Activity.pencill;
import com.example.newshayari.R;
import com.example.newshayari.config;

public class FontAdapter extends BaseAdapter {

        pencill pencill;

    public FontAdapter(pencill pencill) {
        this.pencill=pencill;
    }

    @Override
    public int getCount() {
        return config.font.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertview, ViewGroup viewGroup) {

        convertview = LayoutInflater.from(pencill).inflate(R.layout.extra_font_item,viewGroup,false);
        TextView font1 = convertview.findViewById(R.id.font1);
        Typeface typeface = Typeface.createFromAsset(pencill.getAssets(),config.font[i]);
        font1.setTypeface(typeface);

        return convertview;
    }
}
