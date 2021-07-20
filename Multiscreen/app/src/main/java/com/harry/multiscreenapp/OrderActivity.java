package com.harry.multiscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent intent = getIntent();
        String msg=intent.getStringExtra(MainActivity.MSG);// mainactivity ki class mi se MSg vali string le lega
        TextView t=findViewById(R.id.order_text);
        t.setText(msg);


    }
}