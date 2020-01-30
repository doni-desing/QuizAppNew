package com.geektech.quizapp_gt_4_2.uitils;

import android.app.Application;

import com.geektech.quizapp_gt_4_2.ux.data.romote.IQuizApiClient;
import com.geektech.quizapp_gt_4_2.ux.data.romote.QuizApiClint;

public class App extends Application {

    public static IQuizApiClient quizApiClient;

    @Override
    public void onCreate() {
        super.onCreate();
        quizApiClient = new QuizApiClint();
    }

}
