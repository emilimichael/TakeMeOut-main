package com.example.takemeout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class food_categories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_categories);
    }
    public void StreetFood(View view) {
        Intent i = new Intent(this,StreetFood.class);
        startActivity(i);
    }
    public void Taverns(View view) {
        Intent i = new Intent(this,Taverns.class);
        startActivity(i);
    }
    public void Diethnis(View view) {
        Intent i = new Intent(this,Diethnis.class);
        startActivity(i);
    }
}
