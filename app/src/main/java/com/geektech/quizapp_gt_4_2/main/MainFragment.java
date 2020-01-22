package com.geektech.quizapp_gt_4_2.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.geektech.quizapp_gt_4_2.R;
import com.geektech.quizapp_gt_4_2.settings.Settings1ViewModel;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private Settings1ViewModel mSettingsViewModel;
    private Button btn1;
    private Button btn2;


    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        btn1 = view.findViewById(R.id.btn);
        btn2 = view.findViewById(R.id.btn2);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity())
                .get(MainViewModel.class);
        mSettingsViewModel = ViewModelProviders.of(getActivity())
                .get(Settings1ViewModel.class);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSettingsViewModel.plus();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        mViewModel.message.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
            }
        });

    }

}
