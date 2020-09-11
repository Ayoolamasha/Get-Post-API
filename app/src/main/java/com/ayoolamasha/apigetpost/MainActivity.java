package com.ayoolamasha.apigetpost;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ayoolamasha.apigetpost.Activities.SubmissionActivity;
import com.ayoolamasha.apigetpost.Adapters.ViewPagerAdapter;
import com.ayoolamasha.apigetpost.Fragments.FragmentLeaders;
import com.ayoolamasha.apigetpost.Fragments.FragmentSkills;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TabItem tabItemsLeaders, tabItemSkills;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO: 9/10/2020 MAKE SURE YOU REMOVE ALL THE LOG AFTER ALL THE CODE IS DONE 
        Log.d(TAG, "onCreate: Main Activity Started...");
        viewsSetup();
        setUpViewPager();
        getCurrentTabNumber();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SubmissionActivity.class);
                startActivity(intent);
            }
        });



    }

    private void viewsSetup(){
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        submit = findViewById(R.id.submit);
        tabItemsLeaders = findViewById(R.id.tabLeader);
        tabItemSkills = findViewById(R.id.tabSkills);


        tabLayout.setTabTextColors(ColorStateList.valueOf(getResources().getColor(R.color.colorWhite)));


    }

    public void getCurrentTabNumber(){
        viewPager.getCurrentItem();
    }

    private void setUpViewPager(){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new FragmentLeaders());
        viewPagerAdapter.addFragment(new FragmentSkills());
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
    }
}