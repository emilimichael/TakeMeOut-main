package com.example.takemeout.stores.food;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.takemeout.R;

public class OuzeriToNisi extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ouzeri);
    }
    public void openMap(View view) {
        Uri gmmIntentUri = Uri.parse("geo:40.6343289,22.9421804?q=Ουζέρι+το+νησί+θεσσαλονίκη");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
}
