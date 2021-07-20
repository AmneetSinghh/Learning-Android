package com.harry.tictactoe;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;




public class MainActivity extends AppCompatActivity {
    // Player Representation;
    // 0 - x
    // 1 - O;

    int active_player=0;// this is zero
    int game_state[]={2,2,2,2,2,2,2,2,2};
    boolean game_active= true;// currently game is running on;
    // 2 means empty;
    int win_pos[][]={
            {0,1,2},
            {3,4,5},
            {6,7,8},
            {0,3,6},
            {1,4,7},
            {2,5,8},
            {0,4,8},
            {2,4,6}
    };
    
    public void player_tap(View view)
    {
        ImageView img= (ImageView)view;// typecast view into image view;
        // if we get the image, we can get the any property of the image;
       int tapped_image= Integer.parseInt((String) img.getTag());// 0 or 1 or 2;
        if(game_active==false)
        {
            game_reset();
        }
        if(game_state[tapped_image]==2)
        {
            game_state[tapped_image]=active_player;
            img.setTranslationY(-1000f);// just animation image.
            if(active_player==0)
            {
                active_player=1;
                img.setImageResource(R.drawable.x);
                TextView status=findViewById(R.id.status);
                status.setText("O's turn - Tap to play");

            }
            else
            {
                active_player=0;
                img.setImageResource(R.drawable.o);
                TextView status=findViewById(R.id.status);
                status.setText("X's turn - Tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }

        // check if any player has won or not;
        for(int[] a: win_pos )// returns array
        {
           if(game_state[a[0]]==game_state[a[1]] && game_state[a[1]]==game_state[a[2]] && game_state[a[0]]!=2)
            {
                String winner;
               if(game_state[a[0]]==0)
               {
                   // x won
                   winner="X has won!";
               }
               else
               {
                   // o won
                   winner="O has won!";
               }
                TextView status=findViewById(R.id.status);
                status.setText(winner);
                game_active=false;
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms
                        game_reset();
                    }
                }, 1000);

            }
        }




        int check=0;
        for(int i=0;i<game_state.length;i++)
        {
            if(game_state[i]==2)check=1;
        }
        if(check==0)
        {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 5s = 5000ms
                    game_reset();
                }
            }, 1000);
        }

    }

    public void game_reset()
    {
     game_active=true;
     active_player=0;
     for(int i=0;i<game_state.length;i++)game_state[i]=2;
     // all images, = null
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);// this means null;
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);// this means null;
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);// this means null;
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);// this means null;
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);// this means null;
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);// this means null;
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);// this means null;
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);// this means null;
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);// this means null;
        TextView status=findViewById(R.id.status);
        status.setText("Tap to play");



    }




    @Override


    protected void onCreate(Bundle savedInstanceState) {// accor to activity life cycle, oncreate method, render xml with layout, or screen se render krne k liye,
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

