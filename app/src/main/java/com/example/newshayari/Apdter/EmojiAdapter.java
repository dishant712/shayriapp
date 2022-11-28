package com.example.newshayari.Apdter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.newshayari.Activity.pencill;
import com.example.newshayari.R;
import com.example.newshayari.config;

public class EmojiAdapter extends BaseAdapter {

    pencill pencill;

    public EmojiAdapter(pencill pencill) {
        this.pencill=pencill;
    }

    @Override
    public int getCount() {
        return config.emoji.length;
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

        convertView = LayoutInflater.from(pencill).inflate(R.layout.extra_emoji_item,parent,false);
        TextView textview = convertView.findViewById(R.id.view);
        textview.setText(config.emoji[position]);
        return convertView;
    }
}
