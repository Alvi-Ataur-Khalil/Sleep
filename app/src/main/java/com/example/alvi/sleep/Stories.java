package com.example.alvi.sleep;

import android.app.Activity;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alvi.sleep.Adapters.MainViewPagerAdapter;
import com.example.alvi.sleep.Fragments.HomeFragment;
import com.example.alvi.sleep.Fragments.MeditationFragment;
import com.example.alvi.sleep.Fragments.MusicFragment;
import com.example.alvi.sleep.Fragments.StoriesFragment;
import com.example.alvi.sleep.Fragments.UserFragment;
import com.example.alvi.sleep.Interfaces.FragmentChangeListener;

import java.util.ArrayList;
import java.util.List;

public class Stories extends AppCompatActivity implements FragmentChangeListener{


    ImageView ivHome, ivSleep, ivMeditate, ivMusic, ivUser;
    TextView dt1,dt2,dt3,dt4,dt5;

    ConstraintLayout mainView;

    Activity activity;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    ViewPager viewPager;

    private static final String TAG = "STORIES";

    private static final String HOME ="HOME";
    private static final String SLEEP ="SLEEP";
    private static final String MEDITATION ="MEDITATION";
    private static final String MUSIC ="MUSIC";
    private static final String USER ="USER";

    HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);

        ivHome = findViewById(R.id.home_bg);
        ivSleep = findViewById(R.id.sleep_bg);
        ivMeditate = findViewById(R.id.meditate_bg);
        ivMusic = findViewById(R.id.music_bg);
        ivUser = findViewById(R.id.user_bg);

        dt1 = findViewById(R.id.t1);
        dt2 = findViewById(R.id.t2);
        dt3 = findViewById(R.id.t3);
        dt4 = findViewById(R.id.t4);
        dt5 = findViewById(R.id.t5);

        mainView = findViewById(R.id.maincons);

        List<Fragment> fragments = getFragments();
        fragmentManager = getSupportFragmentManager();



        viewPager = findViewById(R.id.pager);

        final MainViewPagerAdapter adapter = new MainViewPagerAdapter(fragmentManager,fragments);
        viewPager.setAdapter(adapter);

        viewPager.setOffscreenPageLimit(8);

        viewPager.setCurrentItem(0,false);

        selected(HOME);

        ivHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0,false);
                selected(HOME);

            }
        });

        ivSleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1,false);
                selected(SLEEP);
            }
        });

        ivMeditate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2,false);
                selected(MEDITATION);
            }
        });

        ivMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(3,false);
                selected(MUSIC);
            }
        });

        ivUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(4,false);
                selected(USER);
            }
        });
    }

    private List<Fragment> getFragments() {
        List<Fragment> fragmentList = new ArrayList<>();

        homeFragment = new HomeFragment();
        StoriesFragment storiesFragment = new StoriesFragment();
        MeditationFragment meditationFragment = new MeditationFragment();
        MusicFragment musicFragment = new MusicFragment();
        UserFragment userFragment = new UserFragment();


        fragmentList.add(homeFragment);
        fragmentList.add(storiesFragment);
        fragmentList.add(meditationFragment);
        fragmentList.add(musicFragment);
        fragmentList.add(userFragment);

        return fragmentList;
    }

    private void addFragment(Fragment fragment) {

        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        Log.d(TAG,"add 1st: "+fragmentManager.getBackStackEntryCount());
    }

    @Override
    public void replaceFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        Log.d(TAG,"replace: "+fragmentManager.getBackStackEntryCount());
    }

    private void selected(String name) {

        dt1.setSelected(false);
        dt2.setSelected(false);
        dt3.setSelected(false);
        dt4.setSelected(false);
        dt5.setSelected(false);

//        ivHome.setColorFilter(ContextCompat.getColor(Stories.this, R.color.homeDim), android.graphics.PorterDuff.Mode.MULTIPLY);
//        ivSleep.setColorFilter(ContextCompat.getColor(Stories.this, R.color.homeDim), android.graphics.PorterDuff.Mode.MULTIPLY);
//        ivMeditate.setColorFilter(ContextCompat.getColor(Stories.this, R.color.homeDim), android.graphics.PorterDuff.Mode.MULTIPLY);
//        ivMusic.setColorFilter(ContextCompat.getColor(Stories.this, R.color.homeDim), android.graphics.PorterDuff.Mode.MULTIPLY);
//        ivUser.setColorFilter(ContextCompat.getColor(Stories.this, R.color.homeDim), android.graphics.PorterDuff.Mode.MULTIPLY);


        ivHome.setSelected(false);
        ivSleep.setSelected(false);
        ivMeditate.setSelected(false);
        ivMusic.setSelected(false);
        ivUser.setSelected(false);


        if(name.equals(HOME)){
            dt1.setSelected(true);
            ivHome.setSelected(true);

        }
        else if(name.equals(SLEEP)){
            dt2.setSelected(true);
            ivSleep.setSelected(true);

        }
        else if(name.equals(MEDITATION)){
            dt3.setSelected(true);
            ivMeditate.setSelected(true);

        }
        else if(name.equals(MUSIC)){
            dt4.setSelected(true);
            ivMusic.setSelected(true);

        }
        else if(name.equals(USER)){
            dt5.setSelected(true);
            ivUser.setSelected(true);

        }
    }


}
