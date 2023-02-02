package com.example.it193project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Add button
        Button btn_Add = findViewById(R.id.buttonAdd);
        //Show button
        Button btn_Show=findViewById(R.id.buttonShow);
        //Delete button
        Button btn_Delete = findViewById(R.id.buttonDelete);
        //Update button
        Button btn_Update = findViewById(R.id.buttonUpdate);


        //Moves the user to add activity
        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddDogsActivity.class));
            }
        });

        //Moves the user to the show all activity
        btn_Show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ShowDogsActivity.class));
            }
        });

        //Moves the user to the delete activity
        btn_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DeleteDogsActivity.class));
            }
        });

        //Moves the user to the update activity
        btn_Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, UpdateDogsActivity.class));
            }
        });
    }

}