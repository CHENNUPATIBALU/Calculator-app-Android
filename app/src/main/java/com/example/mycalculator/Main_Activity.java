package com.example.mycalculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Main_Activity extends AppCompatActivity {

    Button standardButton,scientificButton;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);
        standardButton = findViewById(R.id.standardButton);
        scientificButton = findViewById(R.id.scientificButton);
        standardButton.setOnClickListener(view -> {
            Intent i = new Intent(Main_Activity.this, StandardActivity.class);
            startActivity(i);
        });
        scientificButton.setOnClickListener(view -> {
            Intent i = new Intent(Main_Activity.this, ScientificCalculatorActivity.class);
            startActivity(i);
        });
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(),"Made by CHENNUPATI BALU",Toast.LENGTH_LONG).show();
        });
    }

}