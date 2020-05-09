package com.example.ghiblirepertory.presentation.view;

import androidx.annotation.Nullable;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ghiblirepertory.Constants;
import com.example.ghiblirepertory.R;
import com.example.ghiblirepertory.presentation.controller.DescriptionController;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;

public class DescriptionActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener,
        YouTubePlayer.PlaybackEventListener, PlayerStateChangeListener {

    private DescriptionController descriptionController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        descriptionController = new DescriptionController(this, getApplicationContext());
        descriptionController.onStart();
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
        descriptionController.onClickComingSoonButton(this);
    }
}
