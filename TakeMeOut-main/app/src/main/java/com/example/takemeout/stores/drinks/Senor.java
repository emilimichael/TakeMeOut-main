package com.example.takemeout.stores.drinks;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.takemeout.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Senor extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.senor);
    }
    public void openMap(View view) {
        Uri gmmIntentUri = Uri.parse("geo:40.6343289,22.9421804?q=senor+thessaloniki");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
}
