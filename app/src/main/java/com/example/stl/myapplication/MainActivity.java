package com.example.stl.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.stl.myapplication.controller.DogAdapter;
import com.example.stl.myapplication.model.DogBreed;
import com.example.stl.myapplication.view.DogViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static  final String DOG_HOUND="https://dog.ceo";


    private ImageView dogView;

    List<String> dogUrl = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dogView = findViewById(R.id.dog_image);




        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DOG_HOUND)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();


        DogApi api = retrofit.create(DogApi.class);


        Call<List<DogBreed>> call = api.getDogBreeds();


        call.enqueue(new Callback<List<DogBreed>>() {

            @Override
            public void onResponse(Call<List<DogBreed>> call, Response<List<DogBreed>> response) {
                DogBreed responseDog = (DogBreed) response.body();
                Log.d("Working", "onResponse: " + responseDog.getUrl());
                for (String s : responseDog.getUrl()) {
                    dogUrl.add(new String(s));

                }
                DogAdapter recyclerViewAdapter = new DogAdapter(dogUrl);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
                RecyclerView recyclerView = findViewById(R.id.recycler_view);

            }




            public void onFailure(Call<List<DogBreed>> call, Throwable t) {
                Log.d("Not working","OnFailure "+t.getMessage());
            }
        });

       // DogAdapter dogAdapter = new DogAdapter(DogBreed);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

       // dogRecyclerView.setAdapter(dogAdapter);





    }

}


