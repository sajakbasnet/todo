package com.example.todouser.database;

import androidx.lifecycle.LiveData;
import com.example.todouser.database.UserDao;
public class UserRepository {
    UserDao dao;
    public UserRepository(UserDatabase userDatabase){   dao = userDatabase.UserDao();
    }



    public LiveData<User> getUserBy(String username, String email){
        return dao.loadUserBy(username, email);
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