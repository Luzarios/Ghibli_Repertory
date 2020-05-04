package com.example.ghiblirepertory;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import com.squareup.picasso.Picasso;

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
                getIntent().hasExtra("running_time") &&
                getIntent().hasExtra("rt_score") &&
                getIntent().hasExtra("intro") &&
                getIntent().hasExtra("description") &&
                getIntent().hasExtra("movie_trailer")) {

            String movie_picture = getIntent().getStringExtra("movie_picture");
            String title = getIntent().getStringExtra("title");
            String director = getIntent().getStringExtra("director");
            String producer = getIntent().getStringExtra("producer");
            String composer = getIntent().getStringExtra("composer");
            String running_time = getIntent().getStringExtra("running_time");
            String rt_score = getIntent().getStringExtra("rt_score");
            String intro = getIntent().getStringExtra("intro");
            String description = getIntent().getStringExtra("description");
            String movie_trailer = getIntent().getStringExtra("movie_trailer");

            setIncomingIntent(movie_picture, title, director, producer, composer, running_time, rt_score, intro, description, movie_trailer);
        }
    }

    private void setIncomingIntent(String movie_picture, String title, String director, String producer, String composer, String running_time, String rt_score, String intro, String description, String movie_trailer) {

        TextView Title = findViewById(R.id.title);
        Title.setText(title);
        TextView Director = findViewById(R.id.director);
        Director.setText(director);
        TextView Producer = findViewById(R.id.producer);
        Producer.setText(producer);
        TextView Composer = findViewById(R.id.composer);
        Composer.setText(composer);
        TextView Running_time = findViewById(R.id.running_time);
        Running_time.setText(running_time);
        TextView Rt_score = findViewById(R.id.rt_score);
        Rt_score.setText(rt_score);
        TextView Intro = findViewById(R.id.intro);
        Intro.setText(intro);
        TextView Description = findViewById(R.id.description);
        Description.setText(description);

        ImageView Movie_picture = findViewById(R.id.movie_picture);
        Picasso.with(getApplicationContext())
                .load(movie_picture)
                .into(Movie_picture);

        VideoView Movie_trailer = findViewById(R.id.trailer);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(Movie_trailer);
        Movie_trailer.setVideoURI(Uri.parse(movie_trailer));
        Movie_trailer.setMediaController(mediaController);
        Movie_trailer.requestFocus();
        Movie_trailer.start();

    }

}
