package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

import dagger.android.AndroidInjection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText userName,password;
    Button loginButton;



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
        });



    }


}
