package com.geektech.quizapp_gt_4_2.ux.data.romote;

import com.geektech.quizapp_gt_4_2.ui.model.Question;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuizQuestionsResponse {

    @SerializedName("response_code")
    private int responseCode;

    private List<Question> results;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<Question> getResults() {
        return results;
    }

    public void setResults(List<Question> results) {
        this.results = results;
    }
}
