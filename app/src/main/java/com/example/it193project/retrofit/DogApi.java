package com.example.it193project.retrofit;

import com.example.it193project.model.Dog;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface DogApi {

    @GET("/api/all-dogs")
    Call <List<Dog>> getAllDogs();

    @GET("/api/show-dog/{id}")
    Call<Dog> getDog(@Path("id") long id);

    @POST("/api/add-dog")
    Call <Dog> save(@Body Dog dog);

    @PUT("/api/update-dog/{id}")
    Call <Dog> updateDog(@Path("id") int id, @Body Dog dog);

    @DELETE("/api/dogs/{id}")
    Call <Dog> deleteDog(@Path("id") int id);

}
