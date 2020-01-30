package com.geektech.quizapp_gt_4_2.ui.quiz.apater;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.quizapp_gt_4_2.R;
import com.geektech.quizapp_gt_4_2.ui.model.Category;
import com.geektech.quizapp_gt_4_2.ui.model.Question;
import com.geektech.quizapp_gt_4_2.ui.quiz.QuizViewModel;

import java.util.List;

class QuizViewHoler extends RecyclerView.ViewHolder {

    private TextView quistions;
    private List<Question> list;
    private TextView textDifficulty;

    public QuizViewHoler(@NonNull View itemView, QuizViewHoler viewHoler) {
        super(itemView);
        quistions = itemView.findViewById(R.id.quistions);
        textDifficulty = itemView.findViewById(R.id.text_difficult);
    }

    void Question(Question question){
        quistions.setText(question.getQuestion());

    }

}
