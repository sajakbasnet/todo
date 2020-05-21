package com.example.todouser.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.todouser.Model.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao getUserDao();
}
