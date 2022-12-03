package com.example.module2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.module2.db.MyDatabaseHelper;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity  {

    Button btnSignUp, btnGoSignIn;
    TextInputLayout password, firstname, repassword;

    MyDatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        DB = new MyDatabaseHelper(this);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = String.valueOf(firstname.getEditText().getText());
                String pass = String.valueOf(password.getEditText().getText());
                String repass = String.valueOf(repassword.getEditText().getText());

                checkValidData(name, pass, repass);
               }
        });

        btnGoSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginMy.class);
                startActivity(intent);
                finish();
            }
        });
    }







    private void initViews() {
        password = findViewById(R.id.password);
        firstname = findViewById(R.id.firstname);
        repassword = findViewById(R.id.repassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnGoSignIn = findViewById(R.id.btnGoSignIn);
    }

    private void checkValidData(String name, String password, String repassword) {
        if(name.equals("") || password.equals("") || repassword.equals("")) {
            Toast.makeText(MainActivity.this, "Please input correct data!", Toast.LENGTH_SHORT).show();
        } else {
            check(name, password, repassword);
        }
    }

    private void check(String name, String password, String repassword) {
        if(password.equals(repassword)) {
            Boolean checkuser = DB.checkfirstname(name);
            if(checkuser == false) {
                Boolean insert = DB.insertData(name, password);
                if(insert == true) {
                    Toast.makeText(MainActivity.this, "You were registered successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), Swipe.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "User already exists", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(MainActivity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
        }
    }
}