package com.example.newsapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitClient {
    @GET("posts/1")

    Call<articles> getSinglePost();


    @GET("top-headlines")

    Call<ResponseM> getAllnews(@Query("country") String country, @Query("category") String category ,@Query("apiKey") String apikey);
}
