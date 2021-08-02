package com.harry.instagram.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.harry.instagram.R;
import com.harry.instagram.utils.BottomNavigationViewHelper;
import com.harry.instagram.utils.SectionsPagerAdapter;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Context mcontext=MainActivity.this;
    private static final int ACTIVITY_NUM=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: starting ");
        SetUpBottomNagivationView();
        SetUpViewPager();
    }




    /*
    Responsible for adding the 3 tabs: Camera, Home, Messages;
    */

    public void SetUpViewPager() {
        SectionsPagerAdapter adapter= new SectionsPagerAdapter(getSupportFragmentManager());// new adapter;
        adapter.addFragment(new CameraFragment());
        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new MessagesFragment());

        // so what we click on the tabs layout, that will show on the viewpager.
        ViewPager viewpager=(ViewPager)findViewById(R.id.container);// Viewpager id central;
        viewpager.setAdapter(adapter);
        TabLayout tablayout= (TabLayout)findViewById(R.id.tabs);
        tablayout.setupWithViewPager(viewpager);

        tablayout.getTabAt(0).setIcon(R.drawable.ic_camera);
        tablayout.getTabAt(1).setIcon(R.drawable.ic_insta);
        tablayout.getTabAt(2).setIcon(R.drawable.ic_arrow);

    }




    // BOttom navigation view setup
    public void SetUpBottomNagivationView() {
        Log.d(TAG, "SetUpBottomNagivationView:  setting up bottom nagiation view");
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupNavigationView(bottomNavigationView);
        // just simple navigation;
        BottomNavigationViewHelper.enabledNavigation(mcontext,bottomNavigationView);

        // means, highlighted when we click that menu item.
        Menu menu=bottomNavigationView.getMenu();
        MenuItem menuitem=menu.getItem(ACTIVITY_NUM);
        menuitem.setChecked(true);
    }




}