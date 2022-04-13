package com.example.takemeout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class Categories extends AppCompatActivity {
    RelativeLayout drinks_category;
    private android.view.View.OnClickListener View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);


        }
        public void openDrinks(View view){
            Intent intent = new Intent(this, drink_categories.class);
            startActivity(intent);
        }
        public void openFood(View view){
            Intent intent = new Intent(this, food_categories.class);
            startActivity(intent);
        }
        public void openCoffee(View view){
            Intent intent = new Intent(this, coffee.class);
            startActivity(intent);
        }
        
    }

