package com.example.carsrestful.rest;

import com.example.carsrestful.model.CarsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CarsApiService {
    //Get Request from API
    @GET("api/v1/cars")
    Call<CarsResponse> getCars(@Query("page") String pageNumber);
}
