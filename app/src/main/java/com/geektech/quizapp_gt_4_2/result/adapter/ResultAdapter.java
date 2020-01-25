package com.geektech.quizapp_gt_4_2.result.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ResultViewHolder> {


    @NonNull
    @Override
    public ResultAdapter.ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ResultAdapter.ResultViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ResultViewHolder extends RecyclerView.ViewHolder {
        public ResultViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
