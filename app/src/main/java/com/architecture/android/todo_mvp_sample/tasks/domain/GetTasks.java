package com.architecture.android.todo_mvp_sample.tasks.domain;

import android.support.annotation.NonNull;

import com.architecture.android.todo_mvp_sample.UseCase;
import com.architecture.android.todo_mvp_sample.data.Task;
import com.architecture.android.todo_mvp_sample.data.source.TaskDataSource;
import com.architecture.android.todo_mvp_sample.data.source.TaskRepository;

import java.util.List;

/**
 * Created by yangsimin on 2017/12/1.
 */

public class GetTasks extends UseCase<GetTasks.GetTasksRequest, GetTasks.GetTasksResponse> {

    private final TaskRepository mTaskRepository;

    public GetTasks(TaskRepository taskRepository){
        mTaskRepository = taskRepository;
    }

    @Override
    protected void executeUseCase(GetTasksRequest requestValues) {
        mTaskRepository.getTasks(new TaskDataSource.GetTasksCallback() {
            @Override
            public void onTasksLoad(List<Task> tasks) {
                getUseCaseCallback().onSuccess(new GetTasksResponse(tasks));
            }
        });
    }

    public static class GetTasksRequest implements UseCase.RequestValues{

    }
    public static class GetTasksResponse implements UseCase.ResponseValue{
        private final List<Task> mTasks;

        public GetTasksResponse(List<Task> tasks) {
            mTasks = tasks;
        }

        public List<Task> getTasks() {
            return mTasks;
        }
    }
}
