package com.example.ghiblirepertory.presentation.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.Toast;

import com.example.ghiblirepertory.Constants;
import com.example.ghiblirepertory.R;
import com.example.ghiblirepertory.Singletons;
import com.example.ghiblirepertory.data.GhibliApi;
import com.example.ghiblirepertory.presentation.controller.ListController;
import com.example.ghiblirepertory.presentation.model.RestGhibliResponse;
import com.example.ghiblirepertory.presentation.model.movies;
import com.example.ghiblirepertory.presentation.view.ListAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

    public class ListActivity extends AppCompatActivity {

        private RecyclerView recyclerView;
        private RecyclerView.Adapter adapter;
        private RecyclerView.LayoutManager layoutManager;

        private ListController listController;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list);

            listController = new ListController(this,
                    Singletons.getGson(),
                    Singletons.getSharedPreferences(getApplicationContext())
            );

            listController.onStart();
        }


        /* Show list of elements */
        public void invokeList(List<movies> moviesList){
            recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            recyclerView.setHasFixedSize(true);
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);

            adapter = new ListAdapter(moviesList, getApplicationContext());
            recyclerView.setAdapter(adapter);
        }

        /* If Api doesn't respond */
        public void showError() {
            Toast.makeText(getApplicationContext(), "Ghibli API Error", Toast.LENGTH_LONG).show();
        }
    }

