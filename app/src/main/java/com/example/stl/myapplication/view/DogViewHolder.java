package com.example.stl.myapplication.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stl.myapplication.R;
import com.example.stl.myapplication.model.DogBreed;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DogViewHolder extends RecyclerView.ViewHolder {


    private ImageView imageView;

    public DogViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.dog_image);

    }

    public void onBind(String url){
        Picasso.get()
                .load(url)
                .centerCrop()
                .fit()
                .into(imageView);

    }
}




