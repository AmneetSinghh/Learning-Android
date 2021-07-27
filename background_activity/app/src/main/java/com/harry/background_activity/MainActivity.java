package com.harry.background_activity;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

// Background tasks in android studio.
public class MainActivity extends AppCompatActivity {
// Asynctask<params, progress , result>
public class BG extends AsyncTask<String,Void,String> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d("HarryBG","First task");
    }


    @Override
    protected String doInBackground(String... urls) {
        // we are just getting data from the website. this is that code.
        Log.d("HarryBG","third task");
        String result= "";
        URL url;
        HttpURLConnection conn;
        try {
            url= new URL(urls[0]);
            // just we conver urlconection to httpurl conectoin, then as we know get input stream reutnr ithe input stream, input reader ge the output, then read it.
            conn=(HttpsURLConnection)url.openConnection();
            InputStream in = conn.getInputStream();
            InputStreamReader reader= new InputStreamReader(in);
            int data= reader.read();
            // itereating in stream while stream not empty or not -1;
            while(data!=-1){
                char cur=(char)data;
                result+=cur;
                data= reader.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Something went wrong!";
        }

        return result;

    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d("HarryBG","second task-> "+s);
        // jo output doinbackround cho augi, oh aapa onpostexecute vich pass kr dunge, so a functoin jehda arugmet le rea that is the outoput from the doinbackground tha,

    }
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // If we want to do some anynchronous taskin background then in this app we'll learn how to do.


    public void click_lelo(View view)
    {
        Toast.makeText(this,"Mi hi hu tu kon ",Toast.LENGTH_LONG).show();
        BG mytask= new BG();
        mytask.execute("https://www.codewithharry.com/");
    }
}

