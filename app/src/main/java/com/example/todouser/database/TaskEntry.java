package com.example.todouser.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "task")
public class TaskEntry {


    @PrimaryKey(autoGenerate = true)
    private int taskid;
    public long id;
    private String title;
    private String description ;
    private int priority;
    private String tododa;
    @ColumnInfo(name="updated_at")
    private Date updatedAt;

    @Ignore
         public TaskEntry(long id , String title, String description, int priority, String tododa,Date updatedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.tododa = tododa;
        this.updatedAt = updatedAt;
    }

    public TaskEntry(int taskid,long id , String title, String description, int priority, String tododa,Date updatedAt) {

        this.taskid = taskid;
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.tododa = tododa;
        this.updatedAt = updatedAt;
    }

    public int getTaskid() {
        return taskid;
    }

    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTododa() {
        return tododa;
    }
    public void setTododa(String tododa) { this.tododa = tododa;   }

    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}