package com.geektech.quizapp_gt_4_2.ui.quiz.apater;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;

    public QuizViewHoler(@NonNull View itemView, QuizViewHoler viewHoler) {
        super(itemView);
        quistions = itemView.findViewById(R.id.quistions);
        textDifficulty = itemView.findViewById(R.id.text_difficult);
        btn_1 = itemView.findViewById(R.id.btn_1);
        btn_2 = itemView.findViewById(R.id.btn_2);
        btn_3 = itemView.findViewById(R.id.btn_3);
        btn_4 = itemView.findViewById(R.id.btn_4);
    }

    void Question(Question question) {
        quistions.setText(question.getQuestion());
      btn_1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              btn_1.setBackgroundColor(R.drawable.btn_back);

          }
      });
    }
}
