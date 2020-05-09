package com.example.ghiblirepertory.presentation.controller;


import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ghiblirepertory.Constants;
import com.example.ghiblirepertory.R;
import com.example.ghiblirepertory.presentation.view.DescriptionActivity;
import com.google.android.youtube.player.YouTubePlayerView;
import com.squareup.picasso.Picasso;

public class DescriptionController {

    private DescriptionActivity view;
    private Context context;

    public DescriptionController(DescriptionActivity descriptionActivity, Context context){
        this.view = descriptionActivity;
        this.context = context;
    }
    public void onStart() {
        /* Initialize YouTubePlayerView */
        YouTubePlayerView Movie_trailer = view.findViewById(R.id.movie_trailer);
        Movie_trailer.initialize(Constants.API_KEY,view);

        getIncomingIntent();
    }

    /* Get in coming intent from ListActivity */
    private void getIncomingIntent() {
        if(view.getIntent().hasExtra("movie_picture") &&
                view.getIntent().hasExtra("title") &&
                view.getIntent().hasExtra("director") &&
                view.getIntent().hasExtra("producer") &&
                view.getIntent().hasExtra("composer") &&
                view.getIntent().hasExtra("running_time") &&
                view.getIntent().hasExtra("rt_score") &&
                view.getIntent().hasExtra("intro") &&
                view.getIntent().hasExtra("description")) {

            String movie_picture = view.getIntent().getStringExtra("movie_picture");
            String title = view.getIntent().getStringExtra("title");
            String director = view.getIntent().getStringExtra("director");
            String producer = view.getIntent().getStringExtra("producer");
            String composer = view.getIntent().getStringExtra("composer");
            String running_time = view.getIntent().getStringExtra("running_time");
            String rt_score = view.getIntent().getStringExtra("rt_score");
            String intro = view.getIntent().getStringExtra("intro");
            String description = view.getIntent().getStringExtra("description");


            setIncomingIntent(movie_picture, title, director, producer, composer, running_time, rt_score, intro, description);
        }
    }

    /* Set in coming intent from ListActivity */
    private void setIncomingIntent(String movie_picture, String title, String director, String producer, String composer, String running_time, String rt_score, String intro, String description) {

        TextView Title = view.findViewById(R.id.title);
        Title.setText(title);
        TextView Director = view.findViewById(R.id.director);
        Director.setText(director);
        TextView Producer = view.findViewById(R.id.producer);
        Producer.setText(producer);
        TextView Composer = view.findViewById(R.id.composer);
        Composer.setText(composer);
        TextView Running_time = view.findViewById(R.id.running_time);
        Running_time.setText(running_time);
        TextView Rt_score = view.findViewById(R.id.rt_score);
        Rt_score.setText(rt_score);
        TextView Intro = view.findViewById(R.id.intro);
        Intro.setText(intro);
        TextView Description = view.findViewById(R.id.description);
        Description.setText(description);

        ImageView Movie_picture = view.findViewById(R.id.movie_picture);
        Picasso.with(context)
                .load(movie_picture)
                .into(Movie_picture);
    }


    /* Define button actions */
    public void onClickComingSoonButton(DescriptionActivity view) {
        Toast.makeText(view,"Coming soon...",Toast.LENGTH_LONG).show();
    }
}
