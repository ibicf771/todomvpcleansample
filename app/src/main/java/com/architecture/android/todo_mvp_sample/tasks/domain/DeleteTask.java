package com.architecture.android.todo_mvp_sample.tasks.domain;

import com.architecture.android.todo_mvp_sample.UseCase;
import com.architecture.android.todo_mvp_sample.data.Task;
import com.architecture.android.todo_mvp_sample.data.source.TaskRepository;

/**
 * Created by yangsimin on 2017/12/1.
 */

public class DeleteTask extends UseCase<DeleteTask.DeleteTaskRequest, DeleteTask.DeleteTaskResponse> {
    private final TaskRepository mTaskRepository;

    public DeleteTask(TaskRepository taskRepository){
        mTaskRepository = taskRepository;
    }

    @Override
    protected void executeUseCase(DeleteTaskRequest requestValues) {
        mTaskRepository.deleteTask(requestValues.getTask());
        getUseCaseCallback().onSuccess(new DeleteTaskResponse());
    }

    public static class DeleteTaskRequest implements UseCase.RequestValues{
        private Task mTask;
        public DeleteTaskRequest(Task task){
            mTask = task;
        }
        public Task getTask(){
            return mTask;
        }

    }
    public static class DeleteTaskResponse implements UseCase.ResponseValue{

    }
}
