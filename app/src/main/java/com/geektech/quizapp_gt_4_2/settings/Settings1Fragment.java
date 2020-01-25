package com.geektech.quizapp_gt_4_2.settings;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geektech.quizapp_gt_4_2.R;
import com.geektech.quizapp_gt_4_2.main.MainViewModel;

public class Settings1Fragment extends Fragment {

    private Settings1ViewModel mViewModel;
    private MainViewModel mViewModel1;
    private TextView textView;

    public static Settings1Fragment newInstance() {
        return new Settings1Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.settings1_fragment, container, false);
        textView = view.findViewById(R.id.text_result);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity()).get(Settings1ViewModel.class);
        mViewModel1 = ViewModelProviders.of(this).get(MainViewModel.class);

        mViewModel.button1.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setText(integer.toString());
            }
        });
        mViewModel.button1.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setText(integer.toString());

            }
        });
    }

}
