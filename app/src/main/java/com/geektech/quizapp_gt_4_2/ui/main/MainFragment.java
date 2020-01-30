package com.geektech.quizapp_gt_4_2.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.geektech.quizapp_gt_4_2.R;
import com.geektech.quizapp_gt_4_2.ui.quiz.QuizActivity;
import com.geektech.quizapp_gt_4_2.ui.settings.Settings1ViewModel;

import org.angmarch.views.NiceSpinner;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private SeekBar seekBar;
    private NiceSpinner niceSpinnerCotegory;
    private TextView buttonStart;
    private TextView textAmoung;
    private NiceSpinner niceSpinnerDiffculty;



    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        niceSpinnerCotegory = view.findViewById(R.id.main_category_spinner);
        seekBar = view.findViewById(R.id.main_amount_seek_bar);
        textAmoung = view.findViewById(R.id.text_amoung);
        niceSpinnerDiffculty = view.findViewById(R.id.main_difficulty_spinner);
        buttonStart = view.findViewById(R.id.button_start);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity())
                .get(MainViewModel.class);
        seekBar();
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), QuizActivity.class);
                intent.putExtra("textAmoung", seekBar.getProgress());
                intent.putExtra("niceDifficulty", niceSpinnerDiffculty.getSelectedIndex());
                intent.putExtra("niceCategory", niceSpinnerCotegory.getSelectedIndex());
                startActivity(intent);
            }
        });
    }

    private void seekBar(){
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textAmoung.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}
