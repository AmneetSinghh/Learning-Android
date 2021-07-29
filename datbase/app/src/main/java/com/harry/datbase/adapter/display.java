package com.harry.datbase.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.harry.datbase.R;

public class display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Intent intent = getIntent();
        String name=intent.getStringExtra("first");
        String phone=intent.getStringExtra("second");


        TextView first=findViewById(R.id.first);
        first.setText(name);
        TextView second=findViewById(R.id.second);
        second.setText(phone);

    }
}


