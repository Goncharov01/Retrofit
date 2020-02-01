package com.example.retrofit.dagger.model;

import com.example.retrofit.MainActivity;
import com.example.retrofit.SecondActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface MainActivityModule {

//Данная аннотация служит для генерации AndroidInjector для MainActivity
    @ContributesAndroidInjector
    abstract MainActivity contributesMainActivity();
    @ContributesAndroidInjector
    abstract SecondActivity cnrtibutesSecondActivity();
}
