package com.geektech.quizapp_gt_4_2.ui.quiz.apater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.quizapp_gt_4_2.R;
import com.geektech.quizapp_gt_4_2.ui.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuizApater extends RecyclerView.Adapter<QuizViewHoler> {
    private List<Question> list = new ArrayList<>();

    private List<Question> question = new ArrayList<>();
    private QuizViewHoler.Listener listener;

    public QuizApater(QuizViewHoler.Listener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public QuizViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quiz, parent, false);
        return new QuizViewHoler(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHoler holder, int position) {
        holder.Question(question.get(position));
    }

    @Override
    public int getItemCount() {
        return question.size();
    }

    public void upData(List<Question> list) {
        this.question = list;
        notifyDataSetChanged();
    }

    public void setQuestions(List<Question> question) {
        this.list.clear();
        this.list.addAll(question);
        notifyDataSetChanged();
    }

}
