package com.example.todouser.data;

import androidx.lifecycle.LiveData;

import com.example.todouser.Model.User;

import java.util.List;

public class UserRepository {
    UserDao dao;
    public UserRepository(UserDatabase userDatabase){   dao = userDatabase.UserDao();
    }



    public LiveData<User> getTaskById(int userId){
        return dao.loadUserById(userId);
    }

    public void update(final User user){
        UserDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.update(user);
            }
        });
    }

    public void delete(final User user){
        UserDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.delete(user);
            }
        });
    }



}

