package com.example.takemeout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class drink_categories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_categories);
    }

    public void Xalara(View view) {
        Intent i = new Intent(this,XalaroPoto.class);
        startActivity(i);
    }

    public void Club(View view){
        Intent i = new Intent(this,Clubs.class);
        startActivity(i);
    }
    public void Dance(View view){
        Intent i=new Intent(this,Dance.class);
        startActivity(i);
    }
}
