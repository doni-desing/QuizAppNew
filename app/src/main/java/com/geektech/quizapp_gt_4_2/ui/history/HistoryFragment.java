package com.geektech.quizapp_gt_4_2.ui.history;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.quizapp_gt_4_2.R;
import com.geektech.quizapp_gt_4_2.ui.history.adapter.HisoryAdapter;

public class HistoryFragment extends Fragment {

    private HistoryViewModel mViewModel;
    private HisoryAdapter adapter = new HisoryAdapter();
    private RecyclerView recyclerView;

    public static HistoryFragment newInstance() {
        return new HistoryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.history_fragment, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_hisotry);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HistoryViewModel.class);

    }

}
