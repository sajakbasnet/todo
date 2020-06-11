package com.example.todouser.fragments;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.todouser.R;
import com.example.todouser.database.User;
import com.example.todouser.tasks.TaskActivityViewModel;

public class UserFragment extends Fragment {

     private User user;
     TextView tvUser,et_email,tvUsers,count;
      TaskActivityViewModel taskActivitymodel;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       taskActivitymodel = ViewModelProviders.of(requireActivity()).get(TaskActivityViewModel.class);

    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_user, container, false);

        user = (User) getActivity().getIntent().getSerializableExtra("User");

        tvUser = (TextView) v.findViewById(R.id.tvUser);
        tvUsers = (TextView) v.findViewById(R.id.tvUsers);
        count = (TextView) v.findViewById(R.id.count);

        et_email = (TextView) v.findViewById(R.id.et_email);



        taskActivitymodel.getCount().observe(getActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {


                count.setText(String.valueOf(integer));
            }
        });

        if (user != null) {

            tvUser.setText(user.getUserName());

            tvUsers.setText(user.getUserName());
            et_email.setText(user.getEmail());
        }
        return  v;

    }



}