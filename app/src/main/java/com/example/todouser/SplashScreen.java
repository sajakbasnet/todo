package com.example.todouser;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
protected void onCreate(@Nullable Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
        startActivity(new Intent(this,MainActivity.class));
    finish();
}
}
