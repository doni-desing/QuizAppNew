package com.geektech.quizapp_gt_4_2.utils;

import android.app.Application;

import com.geektech.quizapp_gt_4_2.ux.data.IHistoryStorage;
import com.geektech.quizapp_gt_4_2.ux.data.remote.IQuizApiClient;
import com.geektech.quizapp_gt_4_2.ux.data.remote.QuizApiClint;

public class App extends Application {

    public static IQuizApiClient quizApiClient;
    public static IHistoryStorage historyStorage;

    @Override
    public void onCreate() {
        super.onCreate();
        quizApiClient = new QuizApiClint();
//        historyStorage = new IHistoryStorage();
    }
    /* Получать вопросы с помощью QuizRepository, в нем же реализовать перемешивание вариантов ответов (отображать также эти варианты ответов)
- Реализовать логику всех функций в QuizViewModel (см. TODO в учебном проекте)
- После skip-a или выбора ответа нельзя повторно ответить на вопрос
- На завершение quiz-a собирать модельку QuizResult и отправлять в HistoryStorage (можно и через QuizRepository, и через HistoryStorage)*/

}
