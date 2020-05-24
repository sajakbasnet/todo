package com.example.todouser.Model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.todouser.database.UserDatabase;
import com.example.todouser.database.UserRepository;



public class ProfileActivityViewModel extends AndroidViewModel {
    UserRepository repository;
    private LiveData<User> user;
    public ProfileActivityViewModel(Application application, String username, String email) {
        super(application);
       UserDatabase data = UserDatabase.getInstance(application);
        repository = new UserRepository(data);
        user = repository.getUserBy(username, email);
    }

}
