package com.harry.instagram.Profile;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.harry.instagram.R;
import com.harry.instagram.utils.SectionsStatePagerAdapter;

import java.util.ArrayList;

public class AccountSettingsActivity  extends AppCompatActivity {
    private static final String TAG = "AccountSettingsActivity";
    private SectionsStatePagerAdapter pageAdapter;
    private ViewPager mviewPager;
    private RelativeLayout mRelativeLayout;
    private Context mContext;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountsettings);
        mContext=AccountSettingsActivity.this;
        mviewPager=(ViewPager) findViewById(R.id.container);
        mRelativeLayout = (RelativeLayout)findViewById(R.id.rellayout1);// this will returns current connected layout id/

        Log.d(TAG, "onCreate: started");
        SetUpSettingList();
        SetUpFragments();// edit profile and sigout;
        /// set up backarrow for navigating back to profileactivity
        ImageView backarrow= (ImageView) findViewById(R.id.backarrow);
        backarrow.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Log.d(TAG, "on click:  navigating back to proifle activity! ");
                finish();
            }
        });
    }



    private void SetUpFragments()
    {
        pageAdapter= new SectionsStatePagerAdapter(getSupportFragmentManager());
        pageAdapter.addFragment(new EditProfileFragment(),getString(R.string.edit_profile));
        pageAdapter.addFragment(new SignOutProfileFragment(),getString(R.string.sign_out));
    }

    private void setViewPager(int fragmentNumber)
    {
        // when this will open all the niche vala part bottom navigation and all will invisible;
        mRelativeLayout.setVisibility(View.GONE);
        Log.d(TAG, "setViewPager: navigating to fragmenet # : "+fragmentNumber);
        mviewPager.setAdapter(pageAdapter);
        mviewPager.setCurrentItem(fragmentNumber);

    }



    private void SetUpSettingList()
    {
        Log.d(TAG, "SetUpSettingList: initilizing array setting list  : ");
        ListView listivew=(ListView) findViewById(R.id.lvAccountSettings);
        ArrayList<String> options= new ArrayList<>();
        options.add(getString(R.string.edit_profile));
        options.add(getString(R.string.sign_out));
        ArrayAdapter adapter = new ArrayAdapter(mContext, android.R.layout.simple_list_item_1,options);
        listivew.setAdapter(adapter);
        listivew.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemClick: navigating to fragent : "+position);
                setViewPager(position);
            }
        });



    }



}
