package com.geektech.quizapp_gt_4_2.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.geektech.quizapp_gt_4_2.R;
import com.geektech.quizapp_gt_4_2.quiz.apater.QuizApater;

public class QuizActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private QuizApater apater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        apater = new QuizApater();
        initRecycler();

    }
    public void initRecycler(){
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(apater);
    }
}
