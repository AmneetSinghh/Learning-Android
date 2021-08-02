package com.harry.instagram.utils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/// related to swaping of the pages in  ViewPager;

// Class that stores fragments for robts;
public class SectionsPagerAdapter  extends FragmentPagerAdapter {
    private static final String TAG = "SectionsPagerAdapter";
    private final List<Fragment> fragment_list=new ArrayList<>();
    public SectionsPagerAdapter(@NonNull  FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragment_list.get(position);
    }

    @Override
    public int getCount() {

        return fragment_list.size();
    }

    public void addFragment(Fragment fragment)
    {
        fragment_list.add(fragment);
    }
}
