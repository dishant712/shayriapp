package com.example.newshayari.Apdter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.newshayari.Activity.Shayari;

public class ShayariAdpter extends BaseAdapter {

    Shayari shayari;
    String[] arr;
    int i;
    public ShayariAdpter(Shayari shayari, String[] arr, int i) {

        this.shayari=shayari;
        this.arr = arr;
        this.i = i;
    }

    @Override
    public int getCount() {
        return 0;
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
        return view;
    }

}
