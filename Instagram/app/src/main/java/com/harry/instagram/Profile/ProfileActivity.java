package com.harry.instagram.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.MaterialToolbar;
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
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: started");
        SetUpBottomNagivationView();
        SetUpToolbar();
    }


    private void SetUpToolbar()
    {
        Toolbar toolbar=(Toolbar) findViewById(R.id.ProfileToolbar);
        setSupportActionBar(toolbar);// just a type of toolbar;
        ImageView profilemenu= (ImageView) findViewById(R.id.ProfileMenu);
        profilemenu.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: navigating to account settings: ");
                Intent intent= new Intent(mcontext,AccountSettingsActivity.class);
                startActivity(intent);
            }
        });



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


