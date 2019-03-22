package com.example.jonathan.instagramclone.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/*
 * Class for storing fragments for tabs
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private static final String TAG = "SectionsPagerAdapter";
    private final List<Fragment> mFragmenntList = new ArrayList<>();


    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);


    }

    @Override
    public Fragment getItem(int i) {
        return mFragmenntList.get(i);
    }

    @Override
    public int getCount() {
        return mFragmenntList.size();
    }

    public void addFragment(Fragment fragment)
    {
        mFragmenntList.add(fragment);
    }
}
