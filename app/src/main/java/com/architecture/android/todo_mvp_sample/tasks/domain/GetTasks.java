package com.architecture.android.todo_mvp_sample.tasks.domain;

import com.architecture.android.todo_mvp_sample.UseCase;
import com.architecture.android.todo_mvp_sample.data.source.TaskRepository;

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

    }

    public class GetTasksRequest implements UseCase.RequestValues{

    }
    public class GetTasksResponse implements UseCase.ResponseValue{

    }
}
