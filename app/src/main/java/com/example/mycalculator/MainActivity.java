package com.example.mycalculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    Button standardButton,scientificButton;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        standardButton = (Button)findViewById(R.id.standardButton);
        scientificButton = (Button)findViewById(R.id.scientificButton);
        standardButton.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, StandardActivity.class);
            startActivity(i);
        });
        scientificButton.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, ScientificActivity.class);
            startActivity(i);
        });
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(),"Made by CHENNUPATI BALU",Toast.LENGTH_LONG).show();
        });
    }

}