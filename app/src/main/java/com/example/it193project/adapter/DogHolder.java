package com.example.it193project.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.it193project.R;

public class DogHolder extends RecyclerView.ViewHolder {
    TextView dogName, dogBreed, dogAge, dogWeight, dogStatus;

    public DogHolder(@NonNull View itemView) {
        super(itemView);
        //@NOTE: For the front end this should be the name of the list of the details regarding the
        //dog.
        dogName = itemView.findViewById(R.id.list_dogName);
        dogBreed = itemView.findViewById(R.id.list_dogBreed);
        dogAge = itemView.findViewById(R.id.list_dogAge);
        dogWeight = itemView.findViewById(R.id.list_dogWeight);
        dogStatus = itemView.findViewById(R.id.list_dogStatus);
    }
}

