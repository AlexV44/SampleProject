package com.example.module2.ui.screen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.module2.R;

public class SwipeActivity extends AppCompatActivity {
    public static void startActivity(Activity srcActivity) {
        Intent intent = new Intent(srcActivity, SwipeActivity.class);
        srcActivity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);
    }
}