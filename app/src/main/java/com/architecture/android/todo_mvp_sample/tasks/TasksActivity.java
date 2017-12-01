package com.architecture.android.todo_mvp_sample.tasks;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.architecture.android.todo_mvp_sample.R;
import com.architecture.android.todo_mvp_sample.UseCaseHandler;
import com.architecture.android.todo_mvp_sample.data.source.TaskRepository;
import com.architecture.android.todo_mvp_sample.tasks.domain.AddTask;
import com.architecture.android.todo_mvp_sample.tasks.domain.DeleteTask;
import com.architecture.android.todo_mvp_sample.tasks.domain.GetTasks;

public class TasksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TasksFragment tasksFragment =
                (TasksFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (tasksFragment == null) {
            // Create the fragment
            tasksFragment = TasksFragment.newInstance();

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.contentFrame, tasksFragment);
            transaction.commit();
        }

//        new TasksPresenter(TaskRepository.getInstance(), tasksFragment);

        UseCaseHandler useCaseHandler = UseCaseHandler.getInstance();
        AddTask addTask = new AddTask(TaskRepository.getInstance());
        DeleteTask deleteTask = new DeleteTask(TaskRepository.getInstance());
        GetTasks getTasks = new GetTasks(TaskRepository.getInstance());
        new TasksPresenter(tasksFragment, useCaseHandler, addTask, deleteTask, getTasks);

    }
}
