package com.example.ghiblirepertory;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void touchEntryButton(View view) {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }
}