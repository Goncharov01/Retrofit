package com.example.retrofit.dagger.component;

import android.app.Application;

import com.example.retrofit.App;
import com.example.retrofit.dagger.model.MainActivityModule;
import com.example.retrofit.dagger.model.SharedPrefModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by anupamchugh on 06/11/17.
 */
//Component мост между модулем который предоставляет зависимости и внедрением зависимости
@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, SharedPrefModule.class, MainActivityModule.class})
public interface MyComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        MyComponent build();
    }
    void inject(App app);
}
