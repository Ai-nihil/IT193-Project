package com.example.it193project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.it193project.model.Dog;
import com.example.it193project.retrofit.DogApi;
import com.example.it193project.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateDogsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_dogs);

        initializeComponents();
    }

    private void initializeComponents() {
        EditText input_dogID = findViewById(R.id.form_textFieldDogID);
        EditText input_dogName = findViewById(R.id.form_textFieldDogName);
        EditText input_dogBreed = findViewById(R.id.form_textFieldDogBreed);
        EditText input_dogAge = findViewById(R.id.form_textFieldDogAge);
        EditText input_dogWeight = findViewById(R.id.form_textFieldDogWeight);
        EditText input_dogStatus = findViewById(R.id.form_textFieldDogStatus);
        Button btn_Add = findViewById(R.id.form_buttonAdd);

        RetrofitService retrofitService = new RetrofitService();
        DogApi dogApi= retrofitService.getRetrofit().create(DogApi.class);

        btn_Add.setOnClickListener(view ->{
            int dogID = Integer.parseInt(String.valueOf(input_dogID.getText()));
            String dogName = String.valueOf(input_dogName.getText());
            String dogBreed = String.valueOf(input_dogBreed.getText());
            String dogAge = String.valueOf(input_dogAge.getText());
            String dogWeight = String.valueOf(input_dogWeight.getText());
            String dogStatus = String.valueOf(input_dogStatus.getText());

            Dog dog = new Dog();
            dog.setDogName(dogName);
            dog.setDogBreed(dogBreed);
            dog.setDogAge(dogAge);
            dog.setDogWeight(dogWeight);
            dog.setDogStatus(dogStatus);

            dogApi.updateDog(dogID, dog)
                    .enqueue(new Callback<Dog>() {
                        @Override
                        public void onResponse(Call<Dog> call, Response<Dog> response) {
                            Toast.makeText(UpdateDogsActivity.this, "Update Successful!", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Dog> call, Throwable t) {
                            Toast.makeText(UpdateDogsActivity.this, "Update Failed!", Toast.LENGTH_SHORT).show();
                        }
                    });
            });

    }
}