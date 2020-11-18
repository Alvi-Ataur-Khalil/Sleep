/*
 * *
 *  * Created by Alvi Khalil on 4/5/19 4:49 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 4/5/19 4:49 PM
 *
 */

package com.example.alvi.sleep.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alvi.sleep.R;


public class UserFragment extends Fragment {

    private static final String COMMON_TAG = "CombinedLifeCycle";
    private static final String FRAGMENT_NAME = UserFragment.class.getSimpleName();

    private static final String TAG = "check";

    Activity activity;



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (Activity) context;
        Log.i(TAG, FRAGMENT_NAME +" onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, FRAGMENT_NAME +" onCreate");
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, FRAGMENT_NAME +" onCreateView");
        View view = inflater.inflate(R.layout.fragment_user, container, false);


//        ImageView imageViewMenu= view.findViewById(R.id.any);

        return view;
    }




    @Override
    public void onResume() {
        super.onResume();

    }
}
