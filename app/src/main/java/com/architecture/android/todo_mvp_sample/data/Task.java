package com.architecture.android.todo_mvp_sample.data;

/**
 * Created by yangsimin on 2017/11/29.
 */

public class Task {
    private String mData;
    private static int NUM = 1;


    public Task(){
        mData = "item" + NUM++;
    }

    public String getData(){
        return mData;
    }
}
