package com.geektech.quizapp_gt_4_2.ui.result;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.geektech.quizapp_gt_4_2.R;

public class ResultActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }
    public static void start(Context context, String difficulty, Integer correctAnswer, Integer result){
//        Intent intent = new Intent(context, )
    }

}
