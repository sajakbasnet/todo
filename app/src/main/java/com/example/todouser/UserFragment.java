package com.example.todouser;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;

import com.example.todouser.Model.User;
import com.example.todouser.data.UserDao;
import com.example.todouser.data.UserDatabase;

import static android.content.Intent.getIntent;

public class UserFragment extends Fragment {
    ProfileActivityViewModel viewModel;
    private LiveData<User> user;
    private TextView tvUsers;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_user, container, false);

    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(ProfileActivityViewModel.class);
        tvUsers = getView().findViewById(R.id.tvUser);
        if (user != null) {

        }
    }

}
