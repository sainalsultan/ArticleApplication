package com.example.articleapps;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    TextView btSkip,btNext;
    Button btGetStarted;
    AdapterIntroViewPager mAdapter;
    Integer imgIntro[]={
      R.drawable.article1,
      R.drawable.article1
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        viewPager       = findViewById(R.id.viewpager);
        tabLayout       = findViewById(R.id.tablayout);
        btSkip          = findViewById(R.id.btSkip);
        btNext          = findViewById(R.id.btNext);
        btGetStarted    = findViewById(R.id.btGetStarted);

        btGetStarted.setVisibility(View.GONE);
        final List<Integer> arrayList = new ArrayList<>();
        arrayList.add(imgIntro[0]);
        arrayList.add(imgIntro[1]);
        arrayList.add(imgIntro[1]);

        mAdapter    = new AdapterIntroViewPager(this,arrayList);
        viewPager.setAdapter(mAdapter);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition()==arrayList.size()-1){
                    loadLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        btSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(arrayList.size());
            }
        });

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position    =0;
                position        = viewPager.getCurrentItem();
                if (position<arrayList.size()){
                    position++;
                    viewPager.setCurrentItem(position);
                }

                if (position==arrayList.size()-1){
                    loadLastScreen();
                }
            }
        });

        btGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void loadLastScreen() {
        btSkip.setVisibility(View.INVISIBLE);
        btNext.setVisibility(View.INVISIBLE);
        tabLayout.setVisibility(View.INVISIBLE);
        btGetStarted.setVisibility(View.VISIBLE);
    }
}
