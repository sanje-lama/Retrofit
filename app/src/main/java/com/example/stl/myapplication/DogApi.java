package com.example.stl.myapplication;

import com.example.stl.myapplication.model.DogBreed;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DogApi {
    String ENDPOINT_DOG = "api/breed/hound/images";


    @GET(ENDPOINT_DOG)
    Call<List<DogBreed>> getDogBreeds();
}
