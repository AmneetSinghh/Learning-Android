package com.harry.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Task Scheduler using Handler and Runnable;
//        final Handler handler=new Handler();
//        // This thing run after every k seconds, k is the number which you write below;
//
//
//        Runnable run = new Runnable() {
//            int c=0;
//            @Override
//            public void run() {
//                // code to execute;
//                Toast.makeText(MainActivity.this,"This si toast "+c,Toast.LENGTH_LONG).show();
//                ++c;
//                handler.postDelayed(this,5000);// we are doing, telling handler to run thsi method, after 1000 miliseconds.
//            }
//        };
//        handler.post(run);


        new CountDownTimer(10000,1000){
            @Override
            public void onTick(long l) {
                Log.d("first"," Mi chutiya nahi hu");
            }

            @Override
            public void onFinish() {
                Log.d("second"," khatam tata bye bye");

            }
        }.start();


    }
}
