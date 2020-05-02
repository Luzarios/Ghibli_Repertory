package com.example.ghiblirepertory;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        getIncomingIntent();
    }

    private void getIncomingIntent() {
        if(getIntent().hasExtra("movie_picture") &&
                getIntent().hasExtra("title") &&
                getIntent().hasExtra("director") &&
                getIntent().hasExtra("producer") &&
                getIntent().hasExtra("composer") &&
                getIntent().hasExtra("intro") &&
                getIntent().hasExtra("description")) {

            String movie_picture = getIntent().getStringExtra("movie_picture");
            String title = getIntent().getStringExtra("title");
            String director = getIntent().getStringExtra("director");
            String producer = getIntent().getStringExtra("producer");
            String composer = getIntent().getStringExtra("composer");
            String intro = getIntent().getStringExtra("intro");
            String description = getIntent().getStringExtra("description");

            setIncomingIntent(movie_picture, title, director, producer, composer, intro, description);
        }
    }

    private void setIncomingIntent(String movie_picture, String title, String director, String producer, String composer, String intro, String description) {

        TextView Title = findViewById(R.id.title);
        Title.setText(title);
        TextView Director = findViewById(R.id.director);
        Director.setText(director);
        TextView Producer = findViewById(R.id.producer);
        Producer.setText(producer);
        TextView Composer = findViewById(R.id.composer);
        Composer.setText(composer);
        TextView Intro = findViewById(R.id.intro);
        Intro.setText(intro);
        TextView Description = findViewById(R.id.description);
        Description.setText(description);

        ImageView Movie_picture = findViewById(R.id.movie_picture);
        Picasso.with(getApplicationContext())
                .load(movie_picture)
                .into(Movie_picture);

    }

}
