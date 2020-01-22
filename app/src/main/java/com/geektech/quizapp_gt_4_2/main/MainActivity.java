package com.geektech.quizapp_gt_4_2.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.geektech.quizapp_gt_4_2.R;
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
                        mViewPager.setCurrentItem(0, true);
                        break;
                    case R.id.menu2:
                        mViewPager.setCurrentItem(1, true);
                        break;

                    case R.id.menu3:
                        mViewPager.setCurrentItem(2, true);
                        break;
                }
                return true;
            }
        });
    }

}


