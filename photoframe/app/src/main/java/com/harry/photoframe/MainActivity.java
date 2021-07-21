package com.harry.photoframe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//    ImageButton prev_button,next_button;
    String data[]={"Harry","never give up","Harry Singh"," Phocus"," Cf problems"};
    ImageView pic;
    TextView name;
    int cur=1;

    public void prev_click(View view)
    {
        String idx="pic"+cur;// this is a string, so we have to take id of it.
        int x=this.getResources().getIdentifier(idx,"id",getPackageName());// we take the id of the pic;
        pic=findViewById(x);
        pic.setAlpha(0f);

        if(cur==1)cur=5;else --cur;
        String idy="pic"+ cur;
        int y=this.getResources().getIdentifier(idy,"id",getPackageName());// we take the id of the pic;
        pic=findViewById(y);
        pic.setAlpha(1f);
        name=findViewById(R.id.name);
        name.setText(data[cur-1]);
    }
    public void next_click(View view)
    {
     String idx="pic"+cur;// this is a string, so we have to take id of it.
     int x=this.getResources().getIdentifier(idx,"id",getPackageName());// we take the id of the pic;
     pic=findViewById(x);
     pic.setAlpha(0f);
        if(cur==5)cur=1;else ++cur;

        String idy="pic"+ cur;
        int y=this.getResources().getIdentifier(idy,"id",getPackageName());// we take the id of the pic;
        pic=findViewById(y);
        pic.setAlpha(1f);
        name=findViewById(R.id.name);
        name.setText(data[cur-1]);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}