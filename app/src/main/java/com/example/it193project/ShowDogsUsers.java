package com.example.it193project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.it193project.adapter.DogAdapter;
import com.example.it193project.model.Dog;
import com.example.it193project.retrofit.RetrofitService;
import com.example.it193project.retrofit.DogApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowDogsUsers extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_show_dogs_users);

        Button button = findViewById(R.id.button);

        recyclerView = findViewById(R.id.recycler_dogsUsers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadDogs();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShowDogsUsers.this, AdoptionActivity.class));
            }
        });
    }

    private void loadDogs() {
        RetrofitService retrofitService = new RetrofitService();
        DogApi dogApi = retrofitService.getRetrofit().create(DogApi.class);
        dogApi.getAllDogs()
                .enqueue(new Callback<List<Dog>>() {
                    @Override
                    public void onResponse(Call<List<Dog>> call, Response<List<Dog>> response) {
                        populateListView(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Dog>> call, Throwable t) {
                        Toast.makeText(ShowDogsUsers.this,"Failed to load users", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void populateListView(List<Dog> dogList) {
        DogAdapter dogAdapter = new DogAdapter(dogList);
        recyclerView.setAdapter(dogAdapter);
    }


}