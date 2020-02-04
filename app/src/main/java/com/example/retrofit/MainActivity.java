package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import javax.inject.Inject;

import dagger.android.AndroidInjection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText userName,password;
    Button loginButton;


@Inject
SharedPreferences sharedPreferences;

@Inject
ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        loginButton = findViewById(R.id.login);
        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Model model = new Model();
                model.setPassword(password.getText().toString());
                model.setUserName(userName.getText().toString());


               apiService.login(model).enqueue(new Callback<TokenAuf>() {

                   @Override
                    public void onResponse(Call<TokenAuf> call, Response<TokenAuf> response) {
                       if (response.body() != null) {
                           SharedPreferences.Editor editor = sharedPreferences.edit();
                           editor.putString("token",response.body().getToken());
                           editor.apply();
                           System.out.println("sharedPreferences " + sharedPreferences.getString("token", " "));
                           System.out.println(model.getUserName());
                           ActivivtyBref();
                       }

                    }

                   @Override
                    public void onFailure(Call<TokenAuf> call, Throwable t) {
                        System.out.println("!!!!!!!!");
                    }
                });
            }

        });
    }

    public void ActivivtyBref (){

        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);

    }

}
