package com.example.newshayari.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newshayari.Apdter.BackgraoundAdpter;
import com.example.newshayari.Apdter.EmojiAdapter;
import com.example.newshayari.Apdter.FontAdapter;
import com.example.newshayari.Apdter.gradientAdapter;
import com.example.newshayari.Apdter.gradientAdapterthirdpage;
import com.example.newshayari.R;
import com.example.newshayari.config;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class pencill extends AppCompatActivity {

            TextView edit;
            LinearLayout linear;
            String text;
            SeekBar seekBar;
            ImageView reload,expand,download;
            Button backround,textcolour,share1,emoji,font,text_size;
            GridView gridView,emojiview,grade;
            GridView fontview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencil);

        text=getIntent().getStringExtra("shayari");
        edit=findViewById(R.id.edit_text);
        edit.setText(text);

        download = findViewById(R.id.download);
        backround = findViewById(R.id.backround);
        textcolour = findViewById(R.id.textcolour);
        share1 = findViewById(R.id.share1);
        emoji = findViewById(R.id.emoji);
        font = findViewById(R.id.font);
        text_size = findViewById(R.id.text_size);
        expand = findViewById(R.id.expand);
        reload =findViewById(R.id.reload);



           backround.setOnClickListener(v -> {
               BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(pencill.this);
               bottomSheetDialog.setCancelable(false);

               View view = LayoutInflater.from(pencill.this).inflate(R.layout.backgraound_layout,null);

               gridView = view.findViewById(R.id.gridview);

               BackgraoundAdpter backgraoundAdpter = new BackgraoundAdpter(this);
               gridView.setAdapter(backgraoundAdpter);

               bottomSheetDialog.setContentView(view);
               bottomSheetDialog.show();

               gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                   @Override
                   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                       edit.setBackgroundColor(getResources().getColor(config.colors[position]));
                       bottomSheetDialog.dismiss();
                   }
               });

           });

        textcolour.setOnClickListener(v -> {

            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(pencill.this);
            bottomSheetDialog.setCancelable(false);

            View view = LayoutInflater.from(pencill.this).inflate(R.layout.backgraound_layout,null);

            gridView = view.findViewById(R.id.gridview);

            BackgraoundAdpter backgraoundAdpter = new BackgraoundAdpter(this);
            gridView.setAdapter(backgraoundAdpter);

            bottomSheetDialog.setContentView(view);
            bottomSheetDialog.show();

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    edit.setTextColor(getResources().getColor(config.colors[position]));
                    bottomSheetDialog.dismiss();
                }
            });
        });

        share1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap icon = getBitmapFromView(edit);

                System.out.println("bitmap==>"+icon);

                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("image/jpeg");

                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

                int num = new  Random().nextInt(2000);

                File f = new File(config.file.getAbsolutePath()+ "/Shyari"+num+".jpg");
                try
                {
                    f.createNewFile();
                    FileOutputStream fo = new FileOutputStream(f);
                    fo.write(bytes.toByteArray());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

//                share.putExtra(Intent.EXTRA_STREAM, Uri.parse(f.getAbsolutePath()));
                try {
                    share.putExtra(Intent.EXTRA_STREAM, Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), f.getAbsolutePath(), "img", "Identified image")));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                startActivity(Intent.createChooser(share, "Share Image"));
            }
        });

        emoji.setOnClickListener(v -> {

            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(pencill.this);
            bottomSheetDialog.setCancelable(false);

            View view = LayoutInflater.from(pencill.this).inflate(R.layout.emoji_layout,null);

            emojiview = view.findViewById(R.id.emojiview);

            EmojiAdapter emojiAdapter = new EmojiAdapter(this);
            emojiview.setAdapter(emojiAdapter);

            bottomSheetDialog.setContentView(view);
            bottomSheetDialog.show();

            emojiview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    edit.setText(getResources().getText(config.emoji.length));
                    edit.setText(config.emoji[position]+"\n"+text+"\n"+config.emoji[position]);
                    bottomSheetDialog.dismiss();
                }
            });
        });

        font.setOnClickListener(v -> {

            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(pencill.this);
            bottomSheetDialog.setCancelable(false);

            View view = LayoutInflater.from(pencill.this).inflate(R.layout.font_layout,null);

            fontview = view.findViewById(R.id.fontview);

            FontAdapter fontAdapter = new FontAdapter(this);
            fontview.setAdapter(fontAdapter);
            fontview.setNumColumns(config.font.length);

            bottomSheetDialog.setContentView(view);
            bottomSheetDialog.show();

            fontview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Typeface typeface = Typeface.createFromAsset(getAssets(),config.font[position]);
                    edit.setTypeface(typeface);
                    bottomSheetDialog.dismiss();
                }
            });

        });

        text_size.setOnClickListener(v -> {

            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(pencill.this);

            View view = LayoutInflater.from(pencill.this).inflate(R.layout.textsize_layout,null);

           seekBar = view.findViewById(R.id.seekBar);
           seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
               @Override
               public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                   edit.setTextSize(seekBar.getProgress());
               }

               @Override
               public void onStartTrackingTouch(SeekBar seekBar) {

               }

               @Override
               public void onStopTrackingTouch(SeekBar seekBar) {

               }

           });

            bottomSheetDialog.setContentView(view);
            bottomSheetDialog.show();


        });

        expand.setOnClickListener(v -> {

            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(pencill.this);
            bottomSheetDialog.setCancelable(false);

            View view = LayoutInflater.from(pencill.this).inflate(R.layout.gradient,null);

            grade = view.findViewById(R.id.gridview);

            gradientAdapter gradientAdapter = new gradientAdapter(this);
            grade.setAdapter(gradientAdapter);

            bottomSheetDialog.setContentView(view);
            bottomSheetDialog.show();

            grade.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    edit.setBackgroundResource(config.gradient[position]);
                    bottomSheetDialog.dismiss();
                }
            });
        });

        reload.setOnClickListener(v -> {
            int min=0;
            int max=config.gradient.length;
            int random = new Random().nextInt(max-min)+min;
                edit.setBackgroundResource(config.gradient[random]);
        });

        download.setOnClickListener(v -> {

            Bitmap icon = getBitmapFromView(edit);

            System.out.println("bitmap==>"+icon);

            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

            int num = new  Random().nextInt(2000);

            File f = new File(config.file.getAbsolutePath()+ "/Shyari"+num+".jpg");
            try
            {
                f.createNewFile();
                FileOutputStream fo = new FileOutputStream(f);
                fo.write(bytes.toByteArray());
                Toast.makeText(this,"File Downloded",Toast.LENGTH_SHORT).show();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        });

    }

    public static Bitmap getBitmapFromView(View view)
    {
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable =view.getBackground();
        if (bgDrawable!=null)
            bgDrawable.draw(canvas);
        else
            canvas.drawColor(Color.WHITE);
        view.draw(canvas);
        return returnedBitmap;
    }
}