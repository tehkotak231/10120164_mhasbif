package com.hasbi.a10120164_mhasbi.view.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hasbi.a10120164_mhasbi.R;
import com.hasbi.a10120164_mhasbi.view.fragment.InfoFragment;
import com.hasbi.a10120164_mhasbi.view.fragment.NoteFragment;
import com.hasbi.a10120164_mhasbi.view.fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity { //10120164 - M Hasbi Fadilah- IF-4 - May 2023

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        //menampilkan halaman yang pertama muncul
        getFragmentPage(new NoteFragment());

        //insialisasi bottom nav
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                int itemId = item.getItemId();
                if (itemId == R.id.info) {
                    fragment = new InfoFragment();
                } else if (itemId == R.id.note) {
                    fragment = new NoteFragment();
                } else if (itemId == R.id.profile) {
                    fragment = new ProfileFragment();
                }
                return getFragmentPage(fragment);
            }
        });
    }

    private boolean getFragmentPage(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.page_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}

