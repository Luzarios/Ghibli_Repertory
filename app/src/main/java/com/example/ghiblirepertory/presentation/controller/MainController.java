package com.example.ghiblirepertory.presentation.controller;

import android.content.Intent;

import com.example.ghiblirepertory.presentation.view.ListActivity;
import com.example.ghiblirepertory.presentation.view.MainActivity;

public class MainController {

    private MainActivity view;

    public MainController(MainActivity mainActivity){
        this.view = mainActivity;
    }

    public void onStart(){
    }

    /* Define button actions, go to another activity */
    public void onClickEntryButton(MainActivity view) {
        Intent intent = new Intent(view, ListActivity.class);
        view.startActivity(intent);
    }

}
