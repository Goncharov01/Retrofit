package com.example.retrofit.dagger.model;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.retrofit.ApiService;
import com.example.retrofit.HeaderInterceptor;
import com.example.retrofit.RetrofitClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;

//класс методы которого генерируют зависимости которые потом будут внедрятся(инжектится)
@Module
public class SharedPrefModule {


//@Singleton существует в единственном экземпляре @Provides делает привязку
       @Singleton
    //@Provides позволяет нам предоставить зависимость
    @Provides
    public Context provideContext(Application application) {
        return application;
    }

    @Singleton
    @Provides
    public SharedPreferences provideSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
    @Singleton
    @Provides
    public HeaderInterceptor provideHeaderInterceptor (SharedPreferences sharedPreferences){
        return new HeaderInterceptor(sharedPreferences);
    }

    @Singleton
    @Provides
    public RetrofitClient provideRetrofitClient(HeaderInterceptor headerInterceptor){
        return new RetrofitClient(headerInterceptor);
    }

    @Singleton
    @Provides
    public ApiService provideApiService (RetrofitClient retrofitClient){
        return retrofitClient.getClient().create(ApiService.class);
    }
}
