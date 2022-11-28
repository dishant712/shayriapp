package com.example.newshayari.Apdter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.newshayari.Activity.Shayari;
import com.example.newshayari.Activity.pencill;
import com.example.newshayari.R;
import com.example.newshayari.config;

public class gradientAdapter extends BaseAdapter {

        pencill pencill;
    public gradientAdapter(pencill pencill) {
        this.pencill=pencill;
    }



    @Override
    public int getCount() { return config.gradient.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(pencill).inflate(R.layout.extra_gradient_item,parent,false);
        LinearLayout textview = convertView.findViewById(R.id.grade_view);
        textview.setBackgroundResource(config.gradient[position]);

        return convertView;
    }
}
