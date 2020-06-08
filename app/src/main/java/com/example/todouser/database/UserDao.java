package com.example.todouser.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


@Dao
public interface UserDao {
    @Query("SELECT * FROM User where email= :mail and password= :password")
    User getUser(String mail, String password);

    @Query("select * from User ")
    User loadAllUsers();

    @Insert
     long insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);


    @Query("SELECT * FROM User WHERE id = :id")
    User loadUserBy(int id);



}