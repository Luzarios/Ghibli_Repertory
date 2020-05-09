package com.example.ghiblirepertory.presentation.controller;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.ghiblirepertory.Constants;
import com.example.ghiblirepertory.Singletons;
import com.example.ghiblirepertory.data.GhibliApi;
import com.example.ghiblirepertory.presentation.model.RestGhibliResponse;
import com.example.ghiblirepertory.presentation.model.movies;
import com.example.ghiblirepertory.presentation.view.ListActivity;
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

public class ListController {

    private SharedPreferences sharedPreferences;
    private Gson gson;
    private ListActivity view;

    public ListController(ListActivity listActivity, Gson gson, SharedPreferences sharedPreferences){
        this.view = listActivity;
        this.gson = gson;
        this.sharedPreferences = sharedPreferences;
    }

    public void onStart(){

        List<movies> movies = getDataFromCache();
        if(movies!= null){
            view.invokeList(movies);
        }else{
            makeApiSummon();
        }
    }


    /* Call the Api */
    private void makeApiSummon(){
        Call<RestGhibliResponse> call = Singletons.getGhibliApi().getGhibliResponse();
        call.enqueue(new Callback<RestGhibliResponse>() {
            @Override
            public void onResponse(Call<RestGhibliResponse> call, Response<RestGhibliResponse> response) {
                if(response.isSuccessful() && response.body()!= null ){
                    List<movies> movies = response.body().getMovies();
                    saveList(movies);
                    view.invokeList(movies);
                }
            }

            @Override
            public void onFailure(Call<RestGhibliResponse> call, Throwable t) {
                view.showError();
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
    public void onItemClick(movies movies){

    }
}
