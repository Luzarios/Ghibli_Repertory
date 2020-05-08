package com.example.ghiblirepertory.presentation.view;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.example.ghiblirepertory.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* Define button actions, go to another activity */
    public void touchEntryButton(View view) {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }
}