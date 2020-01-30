package com.geektech.quizapp_gt_4_2.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.geektech.quizapp_gt_4_2.uitils.App;
import com.geektech.quizapp_gt_4_2.R;
import com.geektech.quizapp_gt_4_2.ux.data.romote.IQuizApiClient;
import com.geektech.quizapp_gt_4_2.ui.model.Question;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

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
                        item.setCheckable(true);
                        mViewPager.setCurrentItem(0, true);
                        break;
                    case R.id.menu2:
                        item.setCheckable(true);

                        mViewPager.setCurrentItem(1, true);
                        break;

                    case R.id.menu3:
                        if (item.setCheckable(true) != null) {

                        }
                        mViewPager.setCurrentItem(2, true);
                        break;
                }
                return true;
            }
        });
    }

}


