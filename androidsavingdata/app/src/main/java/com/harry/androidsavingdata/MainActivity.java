package com.harry.androidsavingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView first;
    EditText second;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         button= findViewById(R.id.button1);
         first= findViewById(R.id.first);
         second= findViewById(R.id.second);

         button.setOnClickListener(new View.OnClickListener() {


             @Override
             public void onClick(View view) {
                 // Shared preferences is interface,
                 String msg= second.getText().toString();// which we enter;
                 SharedPreferences sh= getSharedPreferences("demo",MODE_PRIVATE);// shared preferences is file, which name is demo
                 SharedPreferences.Editor editor= sh.edit();

                editor.putString("str",msg);// just key values di varga save kr dinga;
                editor.apply();// commit message;
                 first.setText(msg);

                 // click k baad msg dikhai dega;



             }
         });

         //  but app ko phir se khologe, then niche vali string dikhai degi;

         // get the values of the shared preferences back;
        SharedPreferences gets=getSharedPreferences("demo",MODE_PRIVATE);
        String vlues=gets.getString("str","Save a not and it will show up here!");
        first.setText(vlues);

        // how to get all values; of the shared preferences; all the keys and values;

    }
}