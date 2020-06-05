package com.example.todouser;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;

import android.view.MenuItem;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.example.todouser.fragments.*;
import com.example.todouser.Model.User;
import com.example.todouser.database.UserDao;

import com.example.todouser.tasks.ListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    private TextView tvUser,et_email;
    private User user;
    UserDao db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

<<<<<<< HEAD
      /*  user = (User) getIntent().getSerializableExtra("User");
        tvUser = findViewById(R.id.tvUser);
        if (user != null) {
            tvUser.setText(user.getUserName());
        }*/
=======

>>>>>>> 6c058ce7b3ab479fd31560cbfa3ce59fd9190d1d

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new ListFragment()).commit();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                   Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_list:

                            selectedFragment = new ListFragment();

                            break;
                        case R.id.nav_profile:
                            user = (User) getIntent().getSerializableExtra("User");
                            tvUser = findViewById(R.id.tvUser);
                            if (user != null) {
                                tvUser.setText(user.getUserName());
                            }

                            selectedFragment = new UserFragment();
                            break;
                        case R.id.nav_notification:
                            selectedFragment = new NotificationFragment();
                            break;


                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }
    private void logout() {
        Intent in = getIntent();
        String string = in.getStringExtra("message");

            AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
            builder.setTitle("Confirmation !").
                    setMessage("You sure, that you want to logout?");
            builder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent i = new Intent(getApplicationContext(),
                                    MainActivity.class);
                            startActivity(i);
                        }
                    });
            builder.setNegativeButton("No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert11 = builder.create();
            alert11.show();
        }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.logout:
                logout();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public User getMyData(){
        return user;
    }
}