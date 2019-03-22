package com.example.jonathan.instagramclone.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.example.jonathan.instagramclone.Home.HomeActivity;
import com.example.jonathan.instagramclone.Likes.LikesActivity;
import com.example.jonathan.instagramclone.Profile.ProfileActivity;
import com.example.jonathan.instagramclone.R;
import com.example.jonathan.instagramclone.Search.SearchActivity;
import com.example.jonathan.instagramclone.Share.ShareActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavigationViewHelper {
    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx)
    {
        Log.d(TAG, "setupBottomNavigationView: Setting up BottomNavigationView");

        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx bottomNav)
    {
        bottomNav.setOnNavigationItemSelectedListener((new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.ic_house:
                    {
                        context.startActivity(new Intent(context, HomeActivity.class));
                    }
                    break;
                    case R.id.ic_search:
                    {
                        context.startActivity(new Intent(context, SearchActivity.class));
                    }
                    break;
                    case R.id.ic_circle:
                    {
                        context.startActivity(new Intent(context, ShareActivity.class));
                    }
                    break;
                    case R.id.ic_alert:
                    {
                        context.startActivity(new Intent(context, LikesActivity.class));
                    }
                    break;
                    case R.id.ic_android:
                    {
                        context.startActivity(new Intent(context, ProfileActivity.class));
                    }
                    break;

                }
                return false;
            }
        }));
    }
}
