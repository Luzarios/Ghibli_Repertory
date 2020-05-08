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
import com.example.ghiblirepertory.data.GhibliApi;
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
    private SharedPreferences sharedPreferences;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        sharedPreferences = getSharedPreferences(Constants.GHIBLI_APP,Context.MODE_PRIVATE);

        gson = new GsonBuilder()
                .setLenient()
                .create();

        List<movies> movies = getDataFromCache();
        if(movies!= null){
            invokeList(movies);
        }else{
            makeApiSummon();
        }

    }

    /* Get data from cache */
    private List<movies> getDataFromCache() {
        String jsonMovies = sharedPreferences.getString(Constants.KEY_GHIBLI_LIST, null);

        if(jsonMovies == null){
            return null;
        }else {
            Type listeType = new TypeToken<List<movies>>() {}.getType();
            return gson.fromJson(jsonMovies, listeType);
        }
    }

    /* Show list of elements */
    private void invokeList(List<movies> moviesList){
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ListAdapter(moviesList, getApplicationContext());
        recyclerView.setAdapter(adapter);
    }

    /* Call the Api */
    private void makeApiSummon(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.URL_DATA)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GhibliApi ghibliApi = retrofit.create(GhibliApi.class);

        Call<RestGhibliResponse> call = ghibliApi.getGhibliResponse();
        call.enqueue(new Callback<RestGhibliResponse>() {
            @Override
            public void onResponse(Call<RestGhibliResponse> call, Response<RestGhibliResponse> response) {
                if(response.isSuccessful() && response.body()!= null ){
                    List<movies> movies = response.body().getMovies();
                    saveList(movies);
                    invokeList(movies);
                }
            }

            @Override
            public void onFailure(Call<RestGhibliResponse> call, Throwable t) {
                showError();
            }
        });
    }

    /* Save list */
    private void saveList(List<movies> movies) {
        String jsonString = gson.toJson(movies);

        sharedPreferences
                .edit()
                .putString(Constants.KEY_GHIBLI_LIST, jsonString)
                .apply();
    }

    /* If Api doesn't respond */
    private void showError() {
        Toast.makeText(getApplicationContext(), "Ghibli API Error", Toast.LENGTH_LONG).show();
    }
}
