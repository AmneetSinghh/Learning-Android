package com.harry.musicaudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer player;
    AudioManager audiomanager;
    public void play(View view)
    {
        player.start();
    }
    public void pause(View view)
    {
        player.pause();
    }
    public void stop(View view)
    {
        player.stop();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player = MediaPlayer.create(this,R.raw.audio);

        // set the volume;

        audiomanager= (AudioManager)  getSystemService(Context.AUDIO_SERVICE);
        int maxvol = audiomanager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curvol = audiomanager.getStreamVolume(AudioManager.STREAM_MUSIC);


        SeekBar vol= findViewById(R.id.seekBar);// this means we grab it;
        vol.setMax(maxvol);
        vol.setProgress(curvol);

        vol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
             audiomanager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        /// now change with time music aage going change the second seekbar;

        SeekBar vol_prog= findViewById(R.id.barchange);
        vol_prog.setMax(player.getDuration());
        // music de nal nal seekabr v aage vadi jau timer function nal;


        // seekbar khud chale vo humne timer se kiya;

        new Timer().scheduleAtFixedRate(new TimerTask(){

            @Override
            public void run() {
            vol_prog.setProgress(player.getCurrentPosition());
            }
        },0,900);



        // seeekbar ko jaaha leke jaigi gana vaha se baaje vo humne changelistener se kiyal
        vol_prog.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                player.seekTo(progress);// seekto means, gaane ko jaha p lana chaate hai vaha p aa jaiga;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });






    }
}