package com.example.it193project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telecom.Call;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.it193project.model.User;
import com.example.it193project.retrofit.RetrofitService;
import com.example.it193project.retrofit.UserApi;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();
    }

    private void initializeComponents() {
        EditText input_username = findViewById(R.id.form_textFieldUserName);
        EditText input_email = findViewById(R.id.form_textFieldEmail);
        Button btn_Add = findViewById(R.id.form_buttonAdd);

        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);

        btn_Add.setOnClickListener(view -> {
            String username = String.valueOf(input_username.getText());
            String email = String.valueOf(input_email.getText());

            User user = new User();
            user.setUsername(username);
            user.setEmail(email);

            userApi.save(user)
                    .enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(retrofit2.Call<User> call, Response<User> response) {
                            Toast.makeText(MainActivity.this, "Save Successful", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(retrofit2.Call<User> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Save Failed", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "Error Occurred", t);
                        }
                    }
                );
        });
    }
}