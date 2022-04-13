package com.example.takemeout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomePage extends AppCompatActivity {

    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);


        name = findViewById(R.id.name);

        Intent intent = getIntent();
        String Name = intent.getStringExtra("Name");

        name.setText("Καλωσήρθες "+Name+"!");
    }


    public void goToChoices(View view) {
        Intent i = new Intent(this,Categories.class);
        startActivity(i);
    }
    public void goToFavorite(View view) {
        Intent i = new Intent(this,FavoriteList.class);
        startActivity(i);
    }
}