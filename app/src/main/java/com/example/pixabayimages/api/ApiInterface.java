package com.example.pixabayimages.api;

import com.example.pixabayimages.modalresponse.PixaImagesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("api")
    Call<PixaImagesResponse> getData(@Query("key") String key, @Query("q") String q);
}

