package com.geektech.quizapp_gt_4_2.ui.quiz;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.geektech.quizapp_gt_4_2.R;
import com.geektech.quizapp_gt_4_2.ui.model.Category;
import com.geektech.quizapp_gt_4_2.ui.model.Question;
import com.geektech.quizapp_gt_4_2.ui.quiz.apater.QuizApater;
import com.geektech.quizapp_gt_4_2.uitils.App;
import com.geektech.quizapp_gt_4_2.ux.data.romote.IQuizApiClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Response;

public class QuizActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private QuizViewModel quizViewModel;
    private TextView textCategory;
    private QuizApater apater;
    private Button button;
    private ProgressBar progressBar;

    private int category;
    private int amount;
    private String difficulty;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        category = getIntent().getIntExtra("niceCategory", 0)-1;
        amount = getIntent().getIntExtra("textAmoung", 0);
        difficulty = getIntent().getStringExtra("niceDifficulty");
        textCategory = findViewById(R.id.text_difficult);
        button = findViewById(R.id.btn_skip);
        progressBar = findViewById(R.id.progress_bar);
        recyclerView = findViewById(R.id.recycler_view);

        quizViewModel = ViewModelProviders.of(this).get(QuizViewModel.class);

        quizViewModel.currentPosition.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                recyclerView.smoothScrollToPosition(integer);
                progressBar.setMax(amount);
                progressBar.setProgress(integer);
            }
        });

        quizViewModel.getQuestions(amount, category+7, difficulty);
        showData();
        categories();
        initRecycler();
    }

    @SuppressLint("ClickableViewAccessibility")
    public void initRecycler() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        apater = new QuizApater();
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(apater);
        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }

    public void categories() {
        App.quizApiClient.getCategory(new IQuizApiClient.CategoryCallback() {
            @Override
            public void onSuccess(List<Category> questions) {

                textCategory.setText(questions.get(category).getName());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

    private void showData() {
        quizViewModel.questions.observe(this, new Observer<List<Question>>() {
            @Override
            public void onChanged(List<Question> question) {
                apater.upData(question);
            }
        });
    }

    public void onClick(View view) {
        quizViewModel.getPosition();
    }
}
