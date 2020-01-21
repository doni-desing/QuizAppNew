package com.geektech.quizapp_gt_4_2.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.geektech.quizapp_gt_4_2.R;
import com.geektech.quizapp_gt_4_2.settings.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mViewModel;
    private BottomNavigationView bottomNavigationView;

    private ViewPager mViewPager;
    private MainPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewModel = ViewModelProviders.of(this)
                .get(MainViewModel.class);
        bottomNavigationView = findViewById(R.id.navigation_bottom);

        mViewPager = findViewById(R.id.main_view_pager);
        mAdapter = new MainPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        bottomClick();
    }

    public void bottomClick() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu1:
                        mViewPager.setCurrentItem(1, true);
                        break;
                    case R.id.menu2:
                        mViewPager.setCurrentItem(2, true);
                        break;
                }
                return true;
            }
        });
    }

}


