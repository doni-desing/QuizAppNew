package com.geektech.quizapp_gt_4_2.settings;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Settings1ViewModel extends ViewModel {
    MutableLiveData<Integer> button1 = new MutableLiveData<>();
    MutableLiveData<Integer> button2 = new MutableLiveData<>();
    private int count1 = 0;

    public void plus() {
        button1.postValue(count1++);
    }
    public void minus() {
        button1.postValue(count1--);
    }}
