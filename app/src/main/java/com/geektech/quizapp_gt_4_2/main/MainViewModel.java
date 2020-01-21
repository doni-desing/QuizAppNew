package com.geektech.quizapp_gt_4_2.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public MutableLiveData<String> message = new MutableLiveData<>();
    public MutableLiveData text = new MutableLiveData<>();
    int count1 = 0;

    public MainViewModel() {
        Log.d("ololo", "View model create");

        message.setValue("Hello Observer");
        text.setValue(count1++);

    }


    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
