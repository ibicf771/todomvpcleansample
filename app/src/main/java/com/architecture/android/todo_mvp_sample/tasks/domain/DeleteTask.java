package com.architecture.android.todo_mvp_sample.tasks.domain;

import com.architecture.android.todo_mvp_sample.UseCase;
import com.architecture.android.todo_mvp_sample.data.source.TaskRepository;

/**
 * Created by yangsimin on 2017/12/1.
 */

public class DeleteTask extends UseCase {
    private final TaskRepository mTaskRepository;

    public DeleteTask(TaskRepository taskRepository){
        mTaskRepository = taskRepository;
    }
    @Override
    protected void executeUseCase(RequestValues requestValues) {

    }

    public class DeleteTaskRequest implements UseCase.RequestValues{

    }
    public class DeleteTaskResponse implements UseCase.ResponseValue{

    }
}
