package com.example.jonathan.instagramclone.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SectionsStatePagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragmentList;
    private HashMap<Fragment, Integer> mFragments = new HashMap<>();
    private HashMap<String, Integer> mFragmentsNumbers = new HashMap<>();
    private HashMap<Integer, String> mFragmentsNames = new HashMap<>();


    public SectionsStatePagerAdapter(FragmentManager fm) {
        super(fm);

        mFragmentList = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment, String fragmentName)
    {
        mFragmentList.add(fragment);
        mFragments.put(fragment, mFragmentList.size() - 1);
        mFragmentsNumbers.put(fragmentName, mFragmentList.size() - 1);
        mFragmentsNames.put(mFragmentList.size() - 1, fragmentName);
    }

    public Integer getFragmentNumber(String fragmentName)
    {
        if(mFragmentsNumbers.containsKey(fragmentName))
            return mFragmentsNumbers.get(fragmentName);
        return null;
    }

    public Integer getFragmentNumber(Fragment fragment)
    {
        if(mFragments.containsKey(fragment))
            return mFragments.get(fragment);
        return null;
    }


    public String getFragmentName(Integer fragmentNumber)
    {
        if(mFragmentsNames.containsKey(fragmentNumber))
            return mFragmentsNames.get(fragmentNumber);
        return  null;
    }


}
