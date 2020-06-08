package com.example.todouser.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class UserViewModel extends AndroidViewModel {
UserRepository repo;
User users;
    public UserViewModel(@NonNull Application application) {
        super(application);
        UserDatabase database = UserDatabase.getInstance(application);
       repo = new UserRepository(database);
       users = repo.getUsers();
    }

    public User getUsers() {
        return users;
    }
    public int loadUserBy(int id){
        return id;
    }

}
