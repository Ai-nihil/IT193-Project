package com.example.it193project.retrofit;

import com.example.it193project.model.Dog;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface DogApi {

    @GET("/all-dogs")
    Call <List<Dog>> getAllDogs() ;

    @POST("/add-dog")
    Call <Dog> save(@Body Dog dog);

    @PUT("/update-dog")
    Call <Dog> update(@Body Dog dog);

    @DELETE("/dogs/{id}")
    Call <Dog> delete(@Body Dog dog);

}
