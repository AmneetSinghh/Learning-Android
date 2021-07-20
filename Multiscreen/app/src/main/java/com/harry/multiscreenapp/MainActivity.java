package com.harry.multiscreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String MSG= "com.harry.multiscreen.MSG.ORDER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void place_order(View view)
    {
        // Intent  is object, ik app k ik component se dusre component se communication k liye intent use krte, hai intent is hindi means irada.
        // Intent is Intention in englishl
        Intent intent = new Intent(this,OrderActivity.class);
        EditText t1= findViewById(R.id.t1);
        EditText t2= findViewById(R.id.t2);
        EditText t3= findViewById(R.id.t3);// pass text from one acitivity to another,
        String msg=t1.getText().toString()+" "+t2.getText().toString()+" "+t3.getText().toString();
        intent.putExtra(MSG,msg);// this is the key value pair, that menas, key is MSG and message is msg;
        startActivity(intent);

    }
}