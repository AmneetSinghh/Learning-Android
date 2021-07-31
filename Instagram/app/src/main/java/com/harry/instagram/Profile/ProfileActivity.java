package com.harry.instagram.Profile;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.harry.instagram.R;
import com.harry.instagram.utils.BottomNavigationViewHelper;

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "ProfileActivity";
    private Context mcontext=ProfileActivity.this;
    private static final int ACTIVITY_NUM=4;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");
        SetUpBottomNagivationView();

    }


    // BOttom navigation view setup
    public void SetUpBottomNagivationView() {
        Log.d(TAG, "SetUpBottomNagivationView:  setting up bottom nagiation view");
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupNavigationView(bottomNavigationView);
        BottomNavigationViewHelper.enabledNavigation(mcontext,bottomNavigationView);
        Menu menu=bottomNavigationView.getMenu();
        MenuItem menuitem=menu.getItem(ACTIVITY_NUM);
        menuitem.setChecked(true);

    }
}
