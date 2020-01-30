package com.geektech.quizapp_gt_4_2.ui.quiz;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.geektech.quizapp_gt_4_2.ui.model.Category;
import com.geektech.quizapp_gt_4_2.ui.model.Question;
import com.geektech.quizapp_gt_4_2.uitils.App;
import com.geektech.quizapp_gt_4_2.ux.data.romote.IQuizApiClient;

import java.util.List;
import java.util.Objects;

import retrofit2.Callback;

public class QuizViewModel extends ViewModel {

    MutableLiveData<List<Question>> questions = new MutableLiveData<>();

    MutableLiveData<Integer> currentPosition = new MutableLiveData<>();

    public void getQuestions(final int amount, int category, String difficulty) {
        App.quizApiClient.getQuestions(amount, category, difficulty, new IQuizApiClient.QuestionsCallback() {
            @Override
            public void onSuccess(List<Question> question) {
                currentPosition.setValue(0);
                Log.d("ololo", "onChanged: " + question);
                questions.setValue(question);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

    public void getPosition() {
        Integer currentPositions = currentPosition.getValue();
        if (currentPositions != null) {
                currentPosition.setValue(currentPositions + 1);
        }

    }
}