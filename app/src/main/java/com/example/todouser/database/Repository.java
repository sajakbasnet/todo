package com.example.todouser.database;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repository {

TaskDao dao;

    public Repository(AppDatabase appDatabase){
       // dao = appDatabase.taskDao();
        dao=appDatabase.taskDao();
    }

    public LiveData<List<TaskEntry>> getTasks(){
       return dao.loadAllTasks();
    }


    public LiveData<TaskEntry> getTaskById(int taskId){
        return dao.loadTAskById(taskId);
    }

    public  LiveData<List<TaskEntry>> getTaskByPriority (){
        return dao.loadTaskByPriority();
    }
    public  LiveData<List<TaskEntry>> getTaskByPriority2 (){
        return dao.loadTaskByPriority2();
    }
    public  LiveData<List<TaskEntry>> getTaskByPriority3 (){
        return dao.loadTaskByPriority3();
    }



    public void updateTask(final TaskEntry task){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.update(task);
            }
        });
    }

    public void deleteTask(final TaskEntry task){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
               dao.deleteTask(task);
            }
        });
    }

    public  void  insertTask(final TaskEntry task){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.insertTask(task);
            }
        });
    }
    public LiveData<Integer> getCount() {
        return dao.getCount();
    }

}
