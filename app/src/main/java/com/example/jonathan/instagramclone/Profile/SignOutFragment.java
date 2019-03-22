package com.example.jonathan.instagramclone.Profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jonathan.instagramclone.R;

public class SignOutFragment extends Fragment {

    private static final String TAG = "SignOutFragment";
    
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sign_out, container, false);

        return view;
    }

    @Nullable
    @Override
    public View getView() {
        return super.getView();
    }
}
