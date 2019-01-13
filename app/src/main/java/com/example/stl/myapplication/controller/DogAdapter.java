package com.example.stl.myapplication.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.stl.myapplication.R;
import com.example.stl.myapplication.model.DogBreed;
import com.example.stl.myapplication.view.DogViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DogAdapter extends RecyclerView.Adapter<DogViewHolder> {

    private List<String> dogBreeds;

    public DogAdapter(List<String> dogBreeds) {
        this.dogBreeds = dogBreeds;
    }

    @Override
    public DogViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dog_text_view, viewGroup,false);
        return new DogViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull DogViewHolder dogViewHolder, int i) {
        String dogbreeds = dogBreeds.get(i);
        dogViewHolder.onBind(dogbreeds);
    }







    @Override
    public int getItemCount() {
        return dogBreeds.size();
    }
}
