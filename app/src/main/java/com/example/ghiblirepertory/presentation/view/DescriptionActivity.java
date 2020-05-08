package com.example.ghiblirepertory.presentation.view;

import androidx.annotation.Nullable;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ghiblirepertory.Constants;
import com.example.ghiblirepertory.R;
import com.squareup.picasso.Picasso;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

public class DescriptionActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener,
        YouTubePlayer.PlaybackEventListener, PlayerStateChangeListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        /* Initialize YouTubePlayerView */
        YouTubePlayerView Movie_trailer = findViewById(R.id.movie_trailer);
        Movie_trailer.initialize(Constants.API_KEY,this);

        getIncomingIntent();
    }

    /* Get in coming intent from ListActivity */
    private void getIncomingIntent() {
        if(getIntent().hasExtra("movie_picture") &&
                getIntent().hasExtra("title") &&
                getIntent().hasExtra("director") &&
                getIntent().hasExtra("producer") &&
                getIntent().hasExtra("composer") &&
                getIntent().hasExtra("running_time") &&
                getIntent().hasExtra("rt_score") &&
                getIntent().hasExtra("intro") &&
                getIntent().hasExtra("description")) {

            String movie_picture = getIntent().getStringExtra("movie_picture");
            String title = getIntent().getStringExtra("title");
            String director = getIntent().getStringExtra("director");
            String producer = getIntent().getStringExtra("producer");
            String composer = getIntent().getStringExtra("composer");
            String running_time = getIntent().getStringExtra("running_time");
            String rt_score = getIntent().getStringExtra("rt_score");
            String intro = getIntent().getStringExtra("intro");
            String description = getIntent().getStringExtra("description");


            setIncomingIntent(movie_picture, title, director, producer, composer, running_time, rt_score, intro, description);
        }
    }

    /* Set in coming intent from ListActivity */
    private void setIncomingIntent(String movie_picture, String title, String director, String producer, String composer, String running_time, String rt_score, String intro, String description) {

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
    }

    /* Setting all YoutubePlayer methods */
    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.setPlayerStateChangeListener(this);
        youTubePlayer.setPlaybackEventListener(this);
        if(b){
            youTubePlayer.cueVideo(Constants.VIDEO);
        }
    }

    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this,"Failed...", Toast.LENGTH_LONG).show();
    }


    @Override
    public void onPlaying() {

    }

    @Override
    public void onPaused() {

    }

    @Override
    public void onStopped() {

    }

    @Override
    public void onBuffering(boolean b) {

    }

    @Override
    public void onSeekTo(int i) {

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onLoaded(String s) {

    }

    @Override
    public void onAdStarted() {

    }

    @Override
    public void onVideoStarted() {

    }

    @Override
    public void onVideoEnded() {

    }

    @Override
    public void onError(ErrorReason errorReason) {

    }

    /* Define button actions */
    public void touchCharacterButton(View view) {
        Toast.makeText(this,"Coming soon...",Toast.LENGTH_LONG).show();
    }
}
