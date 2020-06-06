package com.example.newsapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitClient {


    Call<articles> getSinglePost();


    @GET("top-headlines")

    Call<ResponseM> getAllnews(@Query("country") String country, @Query("category") String category ,@Query("apiKey") String apikey);

    @GET("/sport/football/livescores")
    Call<LiveResponse> getallive(@Query("api_key") String api);

    @GET("summary")
    Call<ReGlobal> getglobal();



}
