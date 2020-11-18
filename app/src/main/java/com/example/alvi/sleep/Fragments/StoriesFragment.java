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
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alvi.sleep.Adapters.HorizontalRecyclerAdapter;
import com.example.alvi.sleep.Adapters.MusicsRecyclerAdapter;
import com.example.alvi.sleep.Classes.Musics;
import com.example.alvi.sleep.Classes.Optons;
import com.example.alvi.sleep.R;

import java.util.ArrayList;
import java.util.List;


public class StoriesFragment extends Fragment {

    private static final String COMMON_TAG = "CombinedLifeCycle";
    private static final String FRAGMENT_NAME = StoriesFragment.class.getSimpleName();

    private static final String TAG = "check";

    Activity activity;

    RecyclerView vRecyclerView,hRecyclerView;



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
        View view = inflater.inflate(R.layout.fragment_stories, container, false);

        ArrayList<Optons> arrayListOfOps = new ArrayList<>();
        Integer [] ImagesT = new Integer[]{R.drawable.o4,R.drawable.o1,R.drawable.o2,R.drawable.o3,R.drawable.o5};
        String [] name = new String[]{"All","My", "Anxious", "Sleep","Kids"};

        hRecyclerView = view.findViewById(R.id.hori_recycle);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);
        hRecyclerView.setLayoutManager(horizontalLayoutManager);

        for(int i=0;i<ImagesT.length;i++){
            Optons optons= new Optons();

            optons.setName(name[i]);
            optons.setImage(ImagesT[i]);

            arrayListOfOps.add(optons);
        }

        HorizontalRecyclerAdapter customAdapter1 = new HorizontalRecyclerAdapter(arrayListOfOps,activity);
        hRecyclerView.setAdapter(customAdapter1);
        horizontalLayoutManager.scrollToPositionWithOffset(0, 0);


        List<Musics> arrayListOfSoS = new ArrayList<>();
        String [] headers = new String[]{"Night Sleep","Sweet Sleep", "Moon Cloud","Night Island"};
        String [] bodies = new String[]{"45 MIN • SLEEP MUSIC","45 MIN • SLEEP MUSIC", "45 MIN • SLEEP MUSIC", "45 MIN • SLEEP MUSIC"};
        Integer [] Images = new Integer[]{R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four};

        vRecyclerView = view.findViewById(R.id.verti_recycl);
        vRecyclerView.setLayoutManager(new GridLayoutManager(activity, 2));


        for(int i=0;i<Images.length;i++){
            Musics musics= new Musics();


            musics.setHeader(headers[i]);
            musics.setBody(bodies[i]);
            musics.setImage(Images[i]);

            //LogPrint("Kiklo",numbers[i]+" "+headers[i]+" "+Images[i]+"\n");

            arrayListOfSoS.add(musics);
        }


        MusicsRecyclerAdapter customAdapter = new MusicsRecyclerAdapter(activity, arrayListOfSoS);
        vRecyclerView.setAdapter(customAdapter);



        return view;
    }




    @Override
    public void onResume() {
        super.onResume();

    }
}
