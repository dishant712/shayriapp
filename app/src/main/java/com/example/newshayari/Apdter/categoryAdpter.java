package com.example.newshayari.Apdter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newshayari.Activity.ShayariCategory;
import com.example.newshayari.R;
import com.example.newshayari.config;

public class categoryAdpter extends BaseAdapter {

    ShayariCategory shayariCategory;
    public categoryAdpter(ShayariCategory shayariCategory) {
        this.shayariCategory = shayariCategory;
    }

    @Override
    public int getCount() {
        return config.shayari_name.length;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(shayariCategory).inflate(R.layout.extra_category_item,viewGroup,false);

        ImageView imageView = view.findViewById(R.id.category_img);
        TextView textView = view.findViewById(R.id.category_text);

            imageView.setImageResource(config.shayari_img[i]);
            textView.setText(config.shayari_name[i]);

        return view;
    }
}
