package com.architecture.android.todo_mvp_sample.data.source;

import com.architecture.android.todo_mvp_sample.data.Task;

import java.util.List;

/**
 * Created by yangsimin on 2017/11/29.
 */

public interface TaskDataSource {

    interface GetTasksCallback {

        void onTasksLoad(List<Task> tasks);

    }

    void addTask(Task task);

    void deleteTask(Task task);

    void getTasks(GetTasksCallback callback);
}
