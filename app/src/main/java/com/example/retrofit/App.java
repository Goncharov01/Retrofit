package com.example.retrofit;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.example.retrofit.dagger.component.DaggerMyComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class App extends Application implements HasActivityInjector {

    Context context;
    @Inject
    //DispatchingAndroidInjector нужен для поиска AndroidInector для конкретного Activity.
            DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
        context=getApplicationContext();
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
    //инициализируем даггер( создали, постороили и сделали "иньекцию" в тукущую app
    private void initDagger(){
        DaggerMyComponent.builder().application(this).build().inject(this);
    }
}
