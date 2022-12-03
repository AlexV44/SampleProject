package com.example.module2.ui.screen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.module2.R;
import com.example.module2.data.db.MyDatabaseHelper;
import com.example.module2.data.db.dao.ClientDao;
import com.google.android.material.textfield.TextInputLayout;

public class LoginMyActivity extends AppCompatActivity {
    Button btnlogin;
    TextInputLayout firstname, password;

    MyDatabaseHelper DB;
    ClientDao clientDao;

    public static void startActivity(Activity srcActivity) {
        Intent intent = new Intent(srcActivity, LoginMyActivity.class);
        srcActivity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_my);

        initDB();
        initView();
    }

    private void initView() {
        password = findViewById(R.id.password1);
        firstname = findViewById(R.id.firstname1);
        initLoginButton();
    }

    private void initLoginButton() {
        btnlogin = findViewById(R.id.btnSignIn1);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoginClick();
            }
        });
    }

    private void onLoginClick() {
        String name = String.valueOf(firstname.getEditText().getText());
        String pass = String.valueOf(password.getEditText().getText());

        if (pass.equals("") || name.equals("")) {
            Toast.makeText(LoginMyActivity.this, getString(R.string.error_no_data), Toast.LENGTH_SHORT).show();
        } else if (!clientDao.exists(name, pass)) {
            Toast.makeText(LoginMyActivity.this, getString(R.string.error_login), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(LoginMyActivity.this, getString(R.string.login_succeeded), Toast.LENGTH_SHORT).show();
            SwipeActivity.startActivity(this);
            finish();
        }
    }

    private void initDB() {
        DB = new MyDatabaseHelper(this);
        clientDao = new ClientDao(DB);
    }
}