package com.example.takemeout.stores.drinks;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.takemeout.R;

import java.util.Locale;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StoreParaty extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paraty);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void openMap(View view) {
         /*40.635533, 22.9357378*/
        Uri gmmIntentUri = Uri.parse("geo:40.635533,22.9357378?q=paraty+and+loft+multispace");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }


}
