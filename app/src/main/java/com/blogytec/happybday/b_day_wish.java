package com.blogytec.happybday;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;



public class b_day_wish extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_day_wish);

       String NameReceived;

        Intent i = getIntent();
        NameReceived = i.getStringExtra("text_label");


        TextView FinalName = (TextView) findViewById(R.id.FinalName);

        FinalName.setText(NameReceived.toString());

    }
}
