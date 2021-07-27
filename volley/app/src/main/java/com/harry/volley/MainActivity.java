package com.harry.volley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestQueue requestQueue;
        requestQueue= Volley.newRequestQueue(this);
// JsonObject request simple ik query hove, JsonObject request-> jdo curly braces Laagi hoi, array hove returns vch;

        String url = "https://randomuser.me/api/";

        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET,
                url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray list= response.getJSONArray("results");
                    for(int i=0;i<list.length();i++)
                    {
                        Log.d("Map",list.toString(4));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }



        },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Map", String.valueOf(error));
            }
        });

        requestQueue.add(jsonObjectRequest);
    }
}