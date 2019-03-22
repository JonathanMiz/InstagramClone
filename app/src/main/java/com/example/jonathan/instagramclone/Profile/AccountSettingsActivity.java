package com.example.jonathan.instagramclone.Profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.jonathan.instagramclone.R;
import com.example.jonathan.instagramclone.Utils.BottomNavigationViewHelper;
import com.example.jonathan.instagramclone.Utils.SectionsStatePagerAdapter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;
import java.util.List;

public class AccountSettingsActivity extends AppCompatActivity {

    private static final String TAG = "AccountSettingsActivity";
    private static final int ACTIVITY_NUM = 4;
    private ViewPager mViewPager;
    private RelativeLayout mRelativeLayout;
    private SectionsStatePagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_account_settings);

        mViewPager = findViewById(R.id.viewPager);
        mRelativeLayout = findViewById(R.id.relLayout1);

        setupSettingsList();

        // setup the backarrow for navigating back to ProfileActivity

        ImageView backArrowImage = findViewById(R.id.backArrow);
        backArrowImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        setupFragments();

        //setupBottomNavigationView();
    }

    private void setupFragments()
    {
        mPagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        mPagerAdapter.addFragment(new EditProfileFragment(), getString(R.string.edit_profile_fragment));
        mPagerAdapter.addFragment(new SignOutFragment(), getString(R.string.sign_out_fragment));
    }

    void setViewPager(int fragmentNumber)
    {
        mRelativeLayout.setVisibility(View.GONE);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setCurrentItem(fragmentNumber);
    }

    private void setupSettingsList()
    {
        ListView accountSettingsList = findViewById(R.id.listViewAccountSettings);

        List<String> items = new ArrayList<>();
        items.add(getString(R.string.edit_profile_fragment));
        items.add(getString(R.string.sign_out_fragment));

        ArrayAdapter adapter = new ArrayAdapter(AccountSettingsActivity.this, android.R.layout.simple_list_item_1, items);
        accountSettingsList.setAdapter(adapter);

        accountSettingsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                setViewPager(position);
            }
        });
    }

    private void setupBottomNavigationView() {

        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView.");
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(AccountSettingsActivity.this, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        menu.getItem(ACTIVITY_NUM).setChecked(true);
    }
}
