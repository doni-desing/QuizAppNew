package com.geektech.quizapp_gt_4_2.ui.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.geektech.quizapp_gt_4_2.R;
import com.geektech.quizapp_gt_4_2.ui.model.Category;
import com.geektech.quizapp_gt_4_2.ui.quiz.apater.QuizApater;
import com.geektech.quizapp_gt_4_2.ui.quiz.apater.QuizViewHoler;
import com.geektech.quizapp_gt_4_2.ui.result.ResultActivity;
import com.geektech.quizapp_gt_4_2.utils.App;
import com.geektech.quizapp_gt_4_2.ux.data.remote.IQuizApiClient;

import java.util.List;

import javax.xml.transform.Result;

public class QuizActivity extends AppCompatActivity implements QuizViewHoler.Listener {
// region create Element
    private RecyclerView recyclerView;
    private QuizViewModel quizViewModel;
    private TextView textCategory;
    private TextView textAmoung;
    private QuizApater adapter;
    private Button img;
    private Button button;
    private ProgressBar progressBar;
    private int category;
    private int amount;
    private String difficulty;
//   endregion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        img = findViewById(R.id.img_back);
        category = getIntent().getIntExtra("niceCategory", 0) - 1;
        amount = getIntent().getIntExtra("textAmoung", 0);
        difficulty = getIntent().getStringExtra("niceDifficulty");
        textCategory = findViewById(R.id.text_difficult);
        button = findViewById(R.id.btn_skip);
        textAmoung = findViewById(R.id.tv_amoung);
        progressBar = findViewById(R.id.progress_bar);
        recyclerView = findViewById(R.id.recycler_view);
        onClickImage();

        quizViewModel = ViewModelProviders.of(this).get(QuizViewModel.class);

        quizViewModel.currentPosition.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                recyclerView.smoothScrollToPosition(integer);
                progressBar.setMax(amount);
                progressBar.setProgress(integer);
                textAmoung.setText(integer.toString() + "/" + amount);
                if (integer > amount) {
                    startActivity(new Intent(getApplicationContext(), ResultActivity.class));
                }
            }
        });

        quizViewModel.getQuestions(amount, category + 9, difficulty);
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
        adapter = new QuizApater(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setOnTouchListener((v, event) -> true);
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
        quizViewModel.questions.observe(this, question -> {
            adapter.setQuestions(question);
            adapter.upData(question);
        });
    }

    public void onClick(View view) {
        quizViewModel.onSkip();
    }

    public void onClickImage() {
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizViewModel.getMinus();
            }
        });
    }

    @Override
    public void onAnswerClick(int position, int selectedAnswerPosition) {
        quizViewModel.onAnswerClick(position, selectedAnswerPosition);
        quizViewModel.finishQuiz.observe(this, integer -> startActivity(new Intent(getApplicationContext(), ResultActivity.class)));
    }
}
