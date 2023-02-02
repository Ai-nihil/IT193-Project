package com.example.it193project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AdoptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_adoption);
    }
}