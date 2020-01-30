package com.geektech.quizapp_gt_4_2.ui.quiz.apater;

import androidx.lifecycle.MutableLiveData;

import com.geektech.quizapp_gt_4_2.ui.model.Question;
import com.geektech.quizapp_gt_4_2.ux.data.romote.IQuizApiClient;

import java.util.List;

public interface ShowData {
    MutableLiveData<Question> getQuestions(QuestionsCallback callback);

    interface QuestionsCallback {
        void onSuccess(List<Question> questions);

        void onFailure(Exception e);
    }
}