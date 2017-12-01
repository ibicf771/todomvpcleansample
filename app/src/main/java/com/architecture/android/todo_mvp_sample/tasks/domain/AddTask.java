package com.architecture.android.todo_mvp_sample.tasks.domain;

import com.architecture.android.todo_mvp_sample.UseCase;
import com.architecture.android.todo_mvp_sample.data.Task;
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
        mTaskRepository.addTask(requestValues.getTask());
        getUseCaseCallback().onSuccess(new AddTaskReponse());
    }

    public static class AddTaskRequest implements UseCase.RequestValues{

        private Task mTask;
        public AddTaskRequest(Task task){
            mTask = task;
        }
        public Task getTask(){
            return mTask;
        }
    }

    public static class AddTaskReponse implements UseCase.ResponseValue{

    }
}
