package com.example.todouser.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;

import com.example.todouser.Model.ProfileActivityViewModel;
import com.example.todouser.Model.User;
import com.example.todouser.R;

public class UserFragment extends Fragment {
    ProfileActivityViewModel viewModel;
    private User user;
  TextView tvUser,et_email,tvUsers;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View v =  inflater.inflate(R.layout.fragment_user, container, false);

        user = (User) getActivity().getIntent().getSerializableExtra("User");
        tvUser = (TextView) v.findViewById(R.id.tvUser);
        tvUsers = (TextView) v.findViewById(R.id.tvUsers);

        et_email = (TextView) v.findViewById(R.id.et_email);
        if (user != null) {
            tvUser.setText(user.getUserName());
            tvUsers.setText(user.getUserName());
            et_email.setText(user.getEmail());
        }
        return  v;

    }



}
