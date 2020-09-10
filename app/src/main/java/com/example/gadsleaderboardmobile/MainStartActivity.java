package com.example.gadsleaderboardmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.gadsleaderboardmobile.Adapter.ViewPagerAdapter;
import com.example.gadsleaderboardmobile.Util.Helper;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import retrofit2.Retrofit;

public class MainStartActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Helper melone;
    private TabItem learningLeader, skillIqLeaders;

    private ViewPagerAdapter viewPagerAdapter;
    private Retrofit retrofit;
    private TextView submission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_start);
        melone = new Helper(this);

        toolbar = findViewById(R.id.toolbar_layout);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tablayout);
        learningLeader = findViewById(R.id.learning_leaders);
        skillIqLeaders = findViewById(R.id.skill_iq_leaders);

        viewPager = findViewById(R.id.pager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if(tab.getPosition() == 3){
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainStartActivity.this, R.color.colorPrimaryDark));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainStartActivity.this, R.color.colorPrimaryDark));
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainStartActivity.this, R.color.colorPrimaryDark));
                    }
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        submission = findViewById(R.id.goto_submission);
        submission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                melone.gotoSubmissionActivity();
            }
        });
    }
}