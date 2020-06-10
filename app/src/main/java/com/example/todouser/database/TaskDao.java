package com.example.todouser.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("select * from task order by priority ASC")
    LiveData<List<TaskEntry>> loadAllTasks();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTask(TaskEntry task);

    @Update
    void update(TaskEntry task);

    @Delete
    void deleteTask(TaskEntry task);

    @Query("Select * from task where id =:taskId")
    LiveData<TaskEntry> loadTAskById(int taskId);

    @Query("Select * from task where priority = 1")
    LiveData<List<TaskEntry>> loadTaskByPriority();
    @Query("Select * from task where priority = 2")
    LiveData<List<TaskEntry>> loadTaskByPriority2();
    @Query("Select * from task where priority = 3")
    LiveData<List<TaskEntry>> loadTaskByPriority3();

    @Query("SELECT COUNT(*) FROM task")
    LiveData<Integer> getCount();

}