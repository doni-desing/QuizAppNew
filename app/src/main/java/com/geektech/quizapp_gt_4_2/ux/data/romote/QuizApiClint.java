package com.geektech.quizapp_gt_4_2.ux.data.romote;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.geektech.quizapp_gt_4_2.ui.model.Category;
import com.geektech.quizapp_gt_4_2.ui.model.EDifficulty;
import com.geektech.quizapp_gt_4_2.ui.model.Global;
import com.geektech.quizapp_gt_4_2.ui.model.Question;
import com.geektech.quizapp_gt_4_2.ux.core.CoreCallBack;

import retrofit2.Call;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class QuizApiClint implements IQuizApiClient {

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://opentdb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private QuizApi client = retrofit.create(QuizApi.class);
    private QuizCategory clientCategory = retrofit.create(QuizCategory.class);
    private QuizGlobal clientGlobal = retrofit.create(QuizGlobal.class);


    //region get questions
    @Override
    public MutableLiveData<Question> getQuestions(int amount, int category, String difficulty, final QuestionsCallback callback) {
        final Call<QuizQuestionsResponse> call = client.getQuestions(
                amount,
                category,
                difficulty
        );

        call.enqueue(new CoreCallBack<QuizQuestionsResponse>() {
            @Override
            public void onSuccess(QuizQuestionsResponse result) {
                callback.onSuccess(result.getResults());
                Log.d("ololol", "onSuccess: " + call.request().url());
            }

            @Override
            public void onFailure(Exception e) {
                callback.onFailure(e);
            }
        });

        return null;
    }

    @Override
    public MutableLiveData<Category> getCategory(final CategoryCallback callback) {
        final Call<QuizCategoryResponse> call = clientCategory.getCategory();
        call.enqueue(new CoreCallBack<QuizCategoryResponse>() {
            @Override
            public void onSuccess(QuizCategoryResponse result) {
                callback.onSuccess(result.getTriviaCategories());
                Log.d("ololol", "onSuccess Category " + call.request().url());

            }

            @Override
            public void onFailure(Exception e) {

            }
        });
        return null;
    }

    @Override
    public MutableLiveData<Global> getGlobal(GlobalCallback callback) {
//        clientGlobal.getGlobal()
        return null;
    }

    private interface QuizApi {
        @GET("api.php")
        Call<QuizQuestionsResponse> getQuestions(
                @Query("amount") int amount,
                @Query("category") int category,
                @Query("difficulty") String difficulty
        );
    }

    private interface QuizCategory {
        @GET("api_category.php")
        Call<QuizCategoryResponse> getCategory();
    }

    private interface QuizGlobal {
        @GET("api_count_global.php")
        Call<GlobalResponse> getGlobal();
    }
}
