package com.harry.instagram.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.harry.instagram.Likes.LikesActivity;
import com.harry.instagram.Home.MainActivity;
import com.harry.instagram.Profile.ProfileActivity;
import com.harry.instagram.R;
import com.harry.instagram.Search.SearchActivity;
import com.harry.instagram.Share.ShareActivity;

public class BottomNavigationViewHelper {
    private static final String TAG = "BottomNavigationViewHel";
    public static void setupNavigationView(BottomNavigationView view)
    {
        Log.d(TAG, "setupNavigationView: setting up bottomnagivationview helper!");
        // you can do anything if in this,
    }

    public static void enabledNavigation(final Context context, BottomNavigationView view)
    {

        view.setOnNavigationItemSelectedListener(item -> {
// moving on another by clicking;
            switch(item.getItemId())
            {
                case R.id.ic_house:
                    Intent intent1= new Intent(context, MainActivity.class);
                    context.startActivity(intent1);
                    break;
                case R.id.ic_search:
                    Intent intent2= new Intent(context, SearchActivity.class);
                    context.startActivity(intent2);
                    break;
                case R.id.ic_circle:
                    Intent intent3= new Intent(context, ShareActivity.class);
                    context.startActivity(intent3);
                    break;
                case R.id.ic_alert:
                    Intent intent4= new Intent(context, LikesActivity.class);
                    context.startActivity(intent4);
                    break;
                case R.id.ic_android:
                    Intent intent5= new Intent(context, ProfileActivity.class);
                    context.startActivity(intent5);
                    break;

            }
            return false;
        });
    }
}
