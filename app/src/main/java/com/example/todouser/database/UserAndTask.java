package com.example.todouser.database;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class UserAndTask {

    @Embedded public User user;
    @Relation(
            parentColumn = "id",
            entityColumn = "taskid"
    )
    public List<TaskEntry> taskEntries;
}
