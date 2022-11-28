package com.example.newshayari.Apdter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newshayari.Activity.ShayriList;
import com.example.newshayari.R;


public class ListAdpter extends BaseAdapter {

    ShayriList shayriList;
    int img;
    String[] temp;
    public ListAdpter(ShayriList shayriList,int img,String[] temp) {

        this.shayriList = shayriList;
        this.img=img;
        this.temp=temp;
    }

    @Override
    public int getCount() {
        return temp.length;
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

        view = LayoutInflater.from(shayriList).inflate(R.layout.extra_shayrilist_item,viewGroup,false);

        ImageView imageView = view.findViewById(R.id.shayrilist_img);
        imageView.setImageResource(img);
        TextView textView=view.findViewById(R.id.shayrilist_text);
        textView.setText(temp[i]);
        return view;
    }
}
