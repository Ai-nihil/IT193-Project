package com.example.it193project.adapter;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.it193project.AdoptionActivity;
import com.example.it193project.MainActivity;
import com.example.it193project.R;
import com.example.it193project.ShowDogsActivity;
import com.example.it193project.UpdateDogsActivity;
import com.example.it193project.model.Dog;

import java.util.List;

public class DogAdapter extends RecyclerView.Adapter<DogHolder> {

    private List<Dog> dogList;

    public DogAdapter(List<Dog> dogList){
        this.dogList = dogList;
    }
    @NonNull
    @Override
    public DogHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_dogs_item, parent, false);
        return new DogHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogHolder holder, int position) {
        Dog dog = dogList.get(position);
        holder.dogName.setText(dog.getDogName());
        holder.dogBreed.setText(dog.getDogBreed());
        holder.dogAge.setText(dog.getDogAge());
        holder.dogWeight.setText(dog.getDogWeight());
        holder.dogStatus.setText(dog.getDogStatus());
    }

    @Override
    public int getItemCount() {
        return dogList.size();
    }
}
