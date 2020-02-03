package com.geektech.quizapp_gt_4_2.ux.data.romote;

public interface GenericCallBack<T>{
        void onSuccess(T result);

        void onFailure(Exception e);

}

