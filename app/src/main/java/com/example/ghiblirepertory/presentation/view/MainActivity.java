package com.example.ghiblirepertory.presentation.view;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.example.ghiblirepertory.R;
import com.example.ghiblirepertory.presentation.controller.MainController;

public class MainActivity extends AppCompatActivity {

    private MainController mainController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainController = new MainController(this);
        mainController.onStart();
    }

    /* Define button actions, go to another activity */
    public void touchEntryButton(View view) {
        mainController.onClickEntryButton(this);
    }
}