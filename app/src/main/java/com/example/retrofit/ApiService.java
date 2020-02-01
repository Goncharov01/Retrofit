package com.example.retrofit;

import android.media.session.MediaSession;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface ApiService {

    @POST("authorize/login")
    Call<TokenAuf> login (@Body Model model);
}

