package com.example.todouser;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.todouser.Model.User;
import com.example.todouser.data.UserDatabase;
import com.example.todouser.data.UserRepository;



public class ProfileActivityViewModel extends AndroidViewModel {
    UserRepository repository;
    private LiveData<User> user;
    public ProfileActivityViewModel(Application application, int userId) {
        super(application);
       UserDatabase data = UserDatabase.getInstance(application);
        repository = new UserRepository(data);
        user = repository.getTaskById(userId);
    }
    public LiveData<User> getUserById(){
        return user;
    }
}
