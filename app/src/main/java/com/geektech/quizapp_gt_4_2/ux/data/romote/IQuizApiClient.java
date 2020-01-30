package com.geektech.quizapp_gt_4_2.ux.data.romote;

import androidx.lifecycle.MutableLiveData;

import com.geektech.quizapp_gt_4_2.ui.model.Category;
import com.geektech.quizapp_gt_4_2.ui.model.Global;
import com.geektech.quizapp_gt_4_2.ui.model.Question;
import com.geektech.quizapp_gt_4_2.ui.quiz.apater.ShowData;

import java.util.List;

import retrofit2.Callback;

public interface IQuizApiClient {
    MutableLiveData<Question> getQuestions(int amount, int category, String difficulty, QuestionsCallback callback);
    MutableLiveData<Category> getCategory(CategoryCallback callback);
    MutableLiveData<Global> getGlobal(GlobalCallback callback);

    public interface QuestionsCallback extends GenericCallBack<List<Question>> {

    }

    public interface CategoryCallback extends GenericCallBack<List<Category>>{

    }

    public interface GlobalCallback extends  GenericCallBack<List<Global>> {

    }
}
