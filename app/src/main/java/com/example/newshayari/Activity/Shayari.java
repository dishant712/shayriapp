package com.example.newshayari.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newshayari.Apdter.gradientAdapter;
import com.example.newshayari.Apdter.gradientAdapterthirdpage;
import com.example.newshayari.R;
import com.example.newshayari.config;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Random;

public class Shayari extends AppCompatActivity {

        ImageView pencil,pre,next,copy,share,reload,expand;
        TextView textView,title;
        String[] arr;
        int shayripos;
        GridView grade;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shayari);

        pencil = findViewById(R.id.pencil1);
        textView = findViewById(R.id.text);
        title = findViewById(R.id.title);
        pre = findViewById(R.id.previous_btn);
        next = findViewById(R.id.next_btn);
        copy = findViewById(R.id.copy);
        share = findViewById(R.id.share);
        reload = findViewById(R.id.reload);
        expand =findViewById(R.id.expand);


        pencil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Shayari.this, pencill.class);
                textView.setText(arr[shayripos]);
                intent.putExtra("shayari",textView.getText().toString());
                startActivity(intent);
            }
        });

        shayripos = getIntent().getIntExtra("pos",0);
        arr =  getIntent().getStringArrayExtra("arr");


        textView.setText(arr[shayripos]);
        title.setText((shayripos+1)+"/"+arr.length);


        reload.setOnClickListener(v -> {
            int min=0;
            int max= config.gradient.length;
            int random = new Random().nextInt(max-min)+min;
            textView.setBackgroundResource(config.gradient[random]);
        });

        expand.setOnClickListener(v -> {

            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Shayari.this);
            bottomSheetDialog.setCancelable(false);

            View view = LayoutInflater.from(Shayari.this).inflate(R.layout.gradient,null);

            grade = view.findViewById(R.id.gridview);

            gradientAdapterthirdpage gradientAdapterthirdpage = new gradientAdapterthirdpage(Shayari.this);
            grade.setAdapter(gradientAdapterthirdpage);

            bottomSheetDialog.setContentView(view);
            bottomSheetDialog.show();

            grade.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    textView.setBackgroundResource(config.gradient[position]);
                    bottomSheetDialog.dismiss();
                }
            });
        });

        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                       if(shayripos>0){
                           shayripos--;
                           textView.setText(arr[shayripos]);
                           title.setText((shayripos+1)+"/"+arr.length);
                       }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             if (shayripos< arr.length-1){
                 shayripos++;
                 textView.setText(arr[shayripos]);
                 title.setText((shayripos+1)+"/"+arr.length);
             }
            }
        });

            copy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                    ClipData clip = ClipData.newPlainText("label", arr[shayripos]);
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(Shayari.this, "copied", Toast.LENGTH_SHORT).show();
                }
            });

            share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    String shareSubText = "WhatsApp - The Great Chat App";
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubText);
                    startActivity(Intent.createChooser(shareIntent, "Share"));
                }
            });

        }
    }
