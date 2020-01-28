package com.example.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface ApiService {

    @POST("authorize/login")
    Call<Object> login (@Body Model model);
}

