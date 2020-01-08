package com.example.retrofit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    HeaderInterceptor headerInterceptor;

    public RetrofitClient (HeaderInterceptor headerInterceptor){
        this.headerInterceptor=headerInterceptor;
    }

    private  OkHttpClient.Builder sHttpClient = new OkHttpClient.Builder();

        public  Retrofit retrofit = null;

    public  Retrofit getClient() {
        sHttpClient.addInterceptor(this.headerInterceptor);
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://fluxjwt.herokuapp.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(sHttpClient.build())
                    .build();
            return retrofit;
        }else return retrofit;

    }

    }

