package com.example.todouser.tasks;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.todouser.database.AppDatabase;
import com.example.todouser.database.Repository;
import com.example.todouser.database.TaskEntry;

import java.util.List;

public class TaskActivityViewModel extends AndroidViewModel {

    Repository repository;

   private  LiveData<List<TaskEntry>> tasks;



    public TaskActivityViewModel(Application application){
        super(application);
        AppDatabase database = AppDatabase.getInstance(application);
        repository = new Repository(database);
        tasks = repository.getTasks();
    }

    public LiveData<List<TaskEntry>> getTasks(){
        return tasks;
    }
    public  LiveData<List<TaskEntry>> getTaskByPriority(){
        return tasks;
    }

    public void deleteTask(TaskEntry task){
        repository.deleteTask(task);
    }


    public LiveData<Integer> getCount() {
        return repository.getCount();
    }


}
