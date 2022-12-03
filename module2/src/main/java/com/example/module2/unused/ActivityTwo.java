package com.example.module2.unused;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.module2.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActivityTwo extends AppCompatActivity {

    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);



        navigationView = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();
        navigationView.setSelectedItemId(R.id.home);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.profile:
                        fragment = new ProfileFragment();
                        break;
                    case R.id.settings:
                        fragment = new SettingsFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();

                return true;
            }
        });
    }
}