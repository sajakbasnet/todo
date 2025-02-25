package com.example.todouser;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import com.example.todouser.database.UserDao;

import com.example.todouser.database.User;
import com.example.todouser.database.UserDatabase;

public class RegisterActivity extends AppCompatActivity {
    Button btn_register;
    TextView textViewLogin;
    EditText et_name, et_password, et_email, et_password1;
    String userName, password, pass1, email;
    private UserDao userDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_name = findViewById(R.id.et_name);
        et_password = findViewById(R.id.et_password);
        et_password1 = findViewById(R.id.et_password1);
        et_email = findViewById(R.id.et_email);

        btn_register = findViewById(R.id.btn_register);

        textViewLogin = findViewById(R.id.textViewLogin);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            }
        });

        userDao = Room.databaseBuilder(this, UserDatabase.class, "mi-database.db").allowMainThreadQueries()
                .build().UserDao();

        btn_register .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = et_name.getText().toString();
                password = et_password.getText().toString();
                pass1 = et_password1.getText().toString();
                email = et_email.getText().toString();
                if (userName.isEmpty()) {
                    et_name.setError("Username required");
                    et_name.requestFocus();
                    return;
                }
                if (email.isEmpty()) {
                    et_email.setError("Email required");
                    et_email.requestFocus();
                    return;
                }
                if (password.isEmpty()) {
                    et_password.setError("Password required");
                    et_password.requestFocus();
                    return;
                }
                if (pass1.isEmpty()) {
                    et_password1.setError("Re-Password  required");
                    et_password1.requestFocus();
                    return;
                }

                if (password.equals(pass1)) {
                    User user = new User(userName, password, email);
                    userDao.insert(user);

                    Intent moveToLogin = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(moveToLogin);
                    finish();

                } else {
                    Toast.makeText(RegisterActivity.this, "Password is not matching", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

}