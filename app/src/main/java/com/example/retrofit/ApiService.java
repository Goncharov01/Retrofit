package com.example.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiService {

    @POST("authorize/login")
    Call<TokenAuf> login (@Body Model model);

    @GET("/moto")
    Call<List<ModelMotos>> getMoto();

}

