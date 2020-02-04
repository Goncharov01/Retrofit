package com.example.retrofit;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterRecycler adapterRecycler;

    public List<ModelMotos> modelMotos = new ArrayList<>();

    @Inject
    ApiService apiService;

    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initRecyclerView();

        apiService.getMoto().enqueue(new Callback<List<ModelMotos>>() {
            @Override
            public void onResponse(Call<List<ModelMotos>> call, Response<List<ModelMotos>> response) {
                System.out.println("!!!!!" + response.body());
                System.out.println(response.code());
                List<ModelMotos> modelMotos = response.body();
                adapterRecycler.onChange(modelMotos);
            }

            @Override
            public void onFailure(Call<List<ModelMotos>> call, Throwable t) {
                System.out.println("ERROR" + t.getMessage());
            }
        });

        }

        public void initRecyclerView(){
        recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterRecycler = new AdapterRecycler(this,modelMotos);
        recyclerView.setAdapter(adapterRecycler);

        }

    }
