package com.architecture.android.todo_mvp_sample.tasks.domain;

import com.architecture.android.todo_mvp_sample.UseCase;
import com.architecture.android.todo_mvp_sample.data.source.TaskRepository;

/**
 * Created by yangsimin on 2017/12/1.
 */

public class AddTask extends UseCase<AddTask.AddTaskRequest, AddTask.AddTaskReponse> {

    private final TaskRepository mTaskRepository;

    public AddTask(TaskRepository taskRepository){
        mTaskRepository = taskRepository;
    }
    @Override
    protected void executeUseCase(AddTaskRequest requestValues) {

    }

    public class AddTaskRequest implements UseCase.RequestValues{

    }

    public class AddTaskReponse implements UseCase.ResponseValue{

    }
}
