package com.example.fragment1;


import static android.view.View.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fragment1.databinding.ActivityMainBinding;
import com.example.fragment1.databinding.ActivitySignupBinding;

public class Signup extends AppCompatActivity {

    ActivitySignupBinding binding;
    MyDatabase myDb;
    UserDao userDao;
    public static boolean isAllowed=false;
    EditText username, password;
    AppConstants ad = new AppConstants();
    Button login, signup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        myDb= Room.databaseBuilder(this,MyDatabase.class,"usertable")
                .allowMainThreadQueries().fallbackToDestructiveMigration().build();
        userDao=myDb.getDao();
        binding.username1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String userName=s.toString();
                if(userDao.is_taken(userName)){
                    isAllowed=false;
                    Toast.makeText(Signup.this,"Already taken",Toast.LENGTH_SHORT).show();
                }
                else{
                    isAllowed=true;
                }
            }


        });
        binding.goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isAllowed){
                    UserTable userTable=new UserTable();
                    userDao.insertUser(userTable);
                    startActivity(new Intent(Signup.this, MainActivity.class));
                }
                else{
                    Toast.makeText(Signup.this,"Already Taken",Toast.LENGTH_SHORT).show();
                }
            }
        });
//        binding.login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(Signup.this, MainActivity.class));
//            }
//        });

    }
}
