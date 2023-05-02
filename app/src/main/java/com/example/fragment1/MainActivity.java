
 package com.example.fragment1;


import static android.view.View.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fragment1.databinding.ActivityMainBinding;

    public class MainActivity extends AppCompatActivity {
        ActivityMainBinding binding;
        MyDatabase myDb;
        UserDao userDao;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            binding = ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            myDb = Room.databaseBuilder(this, MyDatabase.class, "usertable")
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();
            userDao = myDb.getDao();


            binding.signup.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
//                    String userName = binding.username.getText().toString();
//                    String password = binding.password.getText().toString();
//                    if (userDao.login(userName, password)) {
//                        startActivity(new Intent(MainActivity.this, HomeActivity.class));
//                    }
//                    else{
//                        Toast.makeText(MainActivity.this,"Invalid username or password",Toast.LENGTH_SHORT).show();
//                    }
                }
            });
        }
    }

