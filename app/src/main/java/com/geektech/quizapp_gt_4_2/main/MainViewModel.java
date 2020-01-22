package com.geektech.quizapp_gt_4_2.main;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.geektech.quizapp_gt_4_2.R;

public class MainViewModel extends ViewModel {

    public MutableLiveData<String> message = new MutableLiveData<>();
    public MutableLiveData<Integer> button1 = new MutableLiveData<>();
    int count1 = 0;

    public void plus() {
        button1.setValue(count1++);
    }

    public MainViewModel() {
        Log.d("ololo", "View model create");
        message.setValue("Hello Observer");

    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
