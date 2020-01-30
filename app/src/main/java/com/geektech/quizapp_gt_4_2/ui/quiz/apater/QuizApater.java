package com.geektech.quizapp_gt_4_2.ui.quiz.apater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.quizapp_gt_4_2.R;
import com.geektech.quizapp_gt_4_2.ui.model.Category;
import com.geektech.quizapp_gt_4_2.ui.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuizApater extends RecyclerView.Adapter<QuizViewHoler> {
    private List<Question> list;
    int pos;

    private List<Question> question = new ArrayList<>();
    private QuizViewHoler viewHoler;

    @NonNull
    @Override
    public QuizViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quiz, parent, false);
        return new QuizViewHoler(view, viewHoler);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHoler holder, int position) {
        pos = position;
        holder.Question( question.get(position));
    }

    @Override
    public int getItemCount() {
        return question.size();
    }


    public List<Question> getCateg(){
        return list;
    }

    public void upData(List<Question> list){
        this.question = list;
        notifyDataSetChanged();
    }

}
