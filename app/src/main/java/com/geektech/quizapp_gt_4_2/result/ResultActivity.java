package com.geektech.quizapp_gt_4_2.result;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.geektech.quizapp_gt_4_2.R;
import com.geektech.quizapp_gt_4_2.result.adapter.ResultAdapter;

public class ResultActivity extends AppCompatActivity {

    private ResultAdapter resultAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        init();
        resultAdapter = new ResultAdapter();
    }
    public void init(){
        RecyclerView recyclerView = findViewById(R.id.recycler_view_in_result);
        recyclerView.setAdapter(resultAdapter);
    }
}
