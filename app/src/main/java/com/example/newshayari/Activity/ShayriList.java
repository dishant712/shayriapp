package com.example.newshayari.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.newshayari.Apdter.ListAdpter;
import com.example.newshayari.Apdter.categoryAdpter;
import com.example.newshayari.R;
import com.example.newshayari.config;

public class ShayriList extends AppCompatActivity {

    ListView listView;
    ActionBar actionBar;
    String[] temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shayri_list);

        int pos= getIntent().getIntExtra("pos",0);
        TextView textView = findViewById(R.id.text);

//        textView.setText("position"+pos+"\tcategory_name"+ config.shayari_name[pos]);
        actionBar=getSupportActionBar();
        actionBar.setTitle(config.shayari_name[pos]);

        listView=findViewById(R.id.list1);
        if(pos==0)
        {
            temp=config.bestwishrsh;
        }
        if(pos==1)
        {
            temp=config.husband;
        }
        if(pos==2)
        {
            temp=config.child;
        }
        if(pos==3)
        {
            temp=config.god;
        }
        if(pos==4)
        {
                temp=config.motivation;
        }
        if (pos==5){
            temp=config.kanjoos;
        }
        if (pos==6){
            temp=config.marriid;
        }
        if (pos==7){
            temp=config.politics;
        }
        if (pos==8){
            temp=config.love;
        }
        if (pos==9){
            temp=config.sad;
        }
        if (pos==10){
            temp=config.bearbar;
        }
        if (pos==11){
            temp=config.bewfa;
        }
        if (pos==12){
            temp=config.birthday;
        }
        if (pos==13){
            temp=config.holiimg;
        }

        ListAdpter ca = new ListAdpter(this,config.shayari_img[pos],temp);
        listView.setAdapter(ca);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent =  new Intent(ShayriList.this,Shayari.class);
                    intent.putExtra("pos",i);
                    intent.putExtra("arr",temp);
                    startActivity(intent);
            }
        });
    }
}