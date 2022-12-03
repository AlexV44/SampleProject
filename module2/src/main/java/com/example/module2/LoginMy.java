package com.example.module2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.module2.db.MyDatabaseHelper;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginMy extends AppCompatActivity {

    Button btnlogin;
    TextInputLayout firstname, password;

    MyDatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_my);

        password = (TextInputLayout) findViewById(R.id.password1);
        firstname = (TextInputLayout) findViewById(R.id.firstname1);

        btnlogin = (Button) findViewById(R.id.btnSignIn1);

        DB = new MyDatabaseHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = String.valueOf(firstname.getEditText().getText());
                String pass = String.valueOf(password.getEditText().getText());
                if(pass.equals("") || name.equals("")) {
                    Toast.makeText(LoginMy.this, "Please input data", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkpass = DB.checkUpassword(name, pass);
                    if (checkpass == true) {
                        Toast.makeText(LoginMy.this, "Sign in successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Swipe.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginMy.this, "Invalid data", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}