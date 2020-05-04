package com.example.ghiblirepertory;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.os.Bundle;

public class ListActivity extends AppCompatActivity {

    private static final  String URL_DATA = "https://raw.githubusercontent.com/";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private SharedPreferences sharedPreferences;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //Intent intent = getIntent();

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

    private List<movies> getDataFromCache() {
        String jsonMovies = sharedPreferences.getString(Constants.KEY_GHIBLI_LIST, null);

        if(jsonMovies == null){
            return null;
        }else {
            Type listeType = new TypeToken<List<movies>>() {}.getType();
            return gson.fromJson(jsonMovies, listeType);
        }
    }

    private void invokeList(List<movies> moviesList){
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ListAdapter(moviesList, getApplicationContext());
        recyclerView.setAdapter(adapter);
    }

    private void makeApiSummon(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_DATA)
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

    private void saveList(List<movies> movies) {
        String jsonString = gson.toJson(movies);

        sharedPreferences
                .edit()
                .putString(Constants.KEY_GHIBLI_LIST, jsonString)
                .apply();
        //Toast.makeText(getApplicationContext(), "List saved", Toast.LENGTH_LONG).show();

    }

    private void showError() {
        Toast.makeText(getApplicationContext(), "Ghibli API Error", Toast.LENGTH_LONG).show();
    }


   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
