package com.example.module2.ui.screen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.module2.R;
import com.example.module2.data.db.MyDatabaseHelper;
import com.example.module2.data.db.dao.ClientDao;
import com.example.module2.data.model.Client;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    Button btnSignUp, btnGoSignIn;
    TextInputLayout password, firstname, repassword;

    MyDatabaseHelper DB;
    ClientDao clientDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDB();
        initView();
    }

    private void initView() {
        password = findViewById(R.id.password);
        firstname = findViewById(R.id.firstname);
        repassword = findViewById(R.id.repassword);

        initSignUpButton();
        initGoToSignInButton();
    }

    private void initDB() {
        DB = new MyDatabaseHelper(this);
        clientDao = new ClientDao(DB);
    }

    private void initSignUpButton() {
        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSignUpClick();
            }
        });
    }

    private void onSignUpClick() {
        String name = String.valueOf(firstname.getEditText().getText());
        String pass = String.valueOf(password.getEditText().getText());
        String repass = String.valueOf(repassword.getEditText().getText());

        if (pass.equals("") || repass.equals("") || name.equals("")) {
            Toast.makeText(this, getString(R.string.error_incorrect_user_input), Toast.LENGTH_SHORT).show();
        } else if (!pass.equals(repass)) {
            Toast.makeText(this, getString(R.string.error_passwords_not_matching), Toast.LENGTH_SHORT).show();
        } else if (clientDao.exists(name)) {
            Toast.makeText(this, getString(R.string.error_user_exists), Toast.LENGTH_SHORT).show();
        } else if (!clientDao.create(new Client(name, pass))) {
            Toast.makeText(this, getString(R.string.error_registration_failed), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.registration_succeeded), Toast.LENGTH_SHORT).show();
            SwipeActivity.startActivity(this);
            finish();
        }
    }

    private void initGoToSignInButton() {
        btnGoSignIn = findViewById(R.id.btnGoSignIn);
        btnGoSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onGoToSignInClick();
            }
        });
    }

    public void onGoToSignInClick() {
        LoginMyActivity.startActivity(this);
        finish();
    }
}