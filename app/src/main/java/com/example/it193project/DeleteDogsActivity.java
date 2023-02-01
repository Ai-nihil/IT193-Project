package com.example.it193project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.it193project.model.Dog;
import com.example.it193project.retrofit.DogApi;
import com.example.it193project.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DeleteDogsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_dogs);

        initializeComponents();

    }

    private void initializeComponents() {

        Button btnDelete = findViewById(R.id.activity_btnDelete);
        EditText editText_ID = findViewById(R.id.editTextId);

        RetrofitService retrofitService = new RetrofitService();
        DogApi dogApi = retrofitService.getRetrofit().create(DogApi.class);

        btnDelete.setOnClickListener(view ->{
            int id = Integer.parseInt(String.valueOf(editText_ID));

            Dog dog = new Dog();
            dog.setId(id);

                    dogApi.delete(dog.getId())
                            .enqueue(new Callback<Dog>() {
                                    @Override
                                    public void onResponse(Call<Dog> call, Response<Dog> response) {
                                        Toast.makeText(DeleteDogsActivity.this,"Delete Successful!", Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onFailure(Call<Dog> call, Throwable t) {
                                         Toast.makeText(DeleteDogsActivity.this,"Failed to delete", Toast.LENGTH_SHORT).show();
                                    }
                                });
                });
    }
}