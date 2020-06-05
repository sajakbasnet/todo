package com.example.todouser;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
<<<<<<< HEAD

import com.example.todouser.database.User;

import com.example.todouser.database.UserDao;
import com.example.todouser.database.UserDatabase;

=======
import com.example.todouser.Model.User;
import com.example.todouser.database.UserDao;
import com.example.todouser.database.UserDatabase;
>>>>>>> user_description
public class MainActivity extends AppCompatActivity  {

    Button btn_login,btn_register;
    EditText et_email, et_password;
    UserDao db;
    UserDatabase dataBase;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_email= findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        btn_login =findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);

        dataBase = Room.databaseBuilder(this, UserDatabase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();
        db = dataBase.UserDao();
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email =  et_email.getText().toString().trim();
                String password = et_password.getText().toString().trim();

                User user = db.getUser(email, password);
                if (user != null) {
                    Intent i = new Intent(MainActivity.this, HomeActivity.class);
                    i.putExtra("User", user);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(MainActivity.this, "Unregistered user, or incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}