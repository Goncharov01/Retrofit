package com.example.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

        public static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://fluxjwt.herokuapp.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit;
        }else return retrofit;

    }

    public static ApiService getApi(){
        return getClient().create(ApiService.class);

    }
}
