package com.architecture.android.todo_mvp_sample.tasks;

import com.architecture.android.todo_mvp_sample.UseCase;
import com.architecture.android.todo_mvp_sample.UseCaseHandler;
import com.architecture.android.todo_mvp_sample.data.Task;
import com.architecture.android.todo_mvp_sample.data.source.TaskDataSource;
import com.architecture.android.todo_mvp_sample.data.source.TaskRepository;
import com.architecture.android.todo_mvp_sample.tasks.domain.AddTask;
import com.architecture.android.todo_mvp_sample.tasks.domain.DeleteTask;
import com.architecture.android.todo_mvp_sample.tasks.domain.GetTasks;

import java.util.List;

/**
 * Created by yangsimin on 2017/11/29.
 */

public class TasksPresenter implements TasksContract.Presenter, TaskRepository.GetTasksCallback{
    private TaskDataSource mTaskDataSource;
    private TasksContract.View mView;
    private AddTask mAddTask;
    private DeleteTask mDeleteTask;
    private GetTasks mGetTasks;
    private UseCaseHandler mUseCaseHandler;

//    public TasksPresenter(TaskDataSource taskDataSource, TasksContract.View view){
//        mTaskDataSource = taskDataSource;
//        mView = view;
//        view.setPresenter(this);
//    }

    public TasksPresenter(TasksContract.View view,
                          UseCaseHandler useCaseHandler,
                          AddTask addTask,
                          DeleteTask deleteTask,
                          GetTasks getTasks){
        mView = view;
        mUseCaseHandler = useCaseHandler;
        mAddTask = addTask;
        mDeleteTask = deleteTask;
        mGetTasks = getTasks;
        view.setPresenter(this);
    }


    @Override
    public void start() {
//        mTaskDataSource.getTasks(this);
        loadTasks();
    }


    @Override
    public void addItem() {
        Task task = new Task();
//        mTaskDataSource.addTask(task);
//        mTaskDataSource.getTasks(this);

        mUseCaseHandler.execute(mAddTask, new AddTask.AddTaskRequest(task), new UseCase.UseCaseCallback<AddTask.AddTaskReponse>() {
            @Override
            public void onSuccess(AddTask.AddTaskReponse response) {
                loadTasks();
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public void deleteItem(Task task) {
//        mTaskDataSource.deleteTask(task);
//        mTaskDataSource.getTasks(this);

        mUseCaseHandler.execute(mDeleteTask, new DeleteTask.DeleteTaskRequest(task), new UseCase.UseCaseCallback<DeleteTask.DeleteTaskResponse>() {
            @Override
            public void onSuccess(DeleteTask.DeleteTaskResponse response) {
                loadTasks();
            }

            @Override
            public void onError() {

            }
        });
    }

    private void loadTasks(){
        mUseCaseHandler.execute(mGetTasks, new GetTasks.GetTasksRequest(), new UseCase.UseCaseCallback<GetTasks.GetTasksResponse>() {
            @Override
            public void onSuccess(GetTasks.GetTasksResponse response) {

                mView.showTasks(response.getTasks());
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public void onTasksLoad(List<Task> tasks) {
        mView.showTasks(tasks);
    }
}
