package com.harry.video;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoView e=findViewById(R.id.earth1);
        e.setVideoPath("android.resource://"+ getPackageName()+"/"+R.raw.earth);
        MediaController md= new MediaController(this);
        e.setMediaController(md);
        md.setAnchorView(e);// it means, a media controller kis video nu control kruga;

        e.start();

    }
}