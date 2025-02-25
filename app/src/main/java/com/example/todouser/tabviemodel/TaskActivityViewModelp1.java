package com.example.todouser.tabviemodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.todouser.database.AppDatabase;
import com.example.todouser.database.Repository;
import com.example.todouser.database.TaskEntry;

import java.util.List;

public class TaskActivityViewModelp1 extends AndroidViewModel {

    Repository repository;

   private  LiveData<List<TaskEntry>> tasks;



    public TaskActivityViewModelp1(Application application){
        super(application);
        AppDatabase database = AppDatabase.getInstance(application);
        repository = new Repository(database);
        tasks = repository.getTaskByPriority();
    }


    public  LiveData<List<TaskEntry>> getTaskByPriority(){
        return tasks;
    }

    public void deleteTask(TaskEntry task){
        repository.deleteTask(task);
    }


}
