package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Model model = new Model();
        model.setPassword("password");
        model.setUserName("Andrew");

        RetrofitClient.getApi().login(model).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                System.out.println(model);
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                System.out.println("!!!!!!!!");
            }
        });

    }


}
