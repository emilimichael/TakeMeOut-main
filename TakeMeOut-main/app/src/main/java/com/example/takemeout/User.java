package com.example.takemeout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class User extends AppCompatActivity {

    private EditText inputName;
    private Button sbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);



        // χρήση του SharedPreference για να γίνει έλεγχος, αν έχει ξανατρέξει η εφαρμογή
        // δεν εμφανίζεται η σελίδα User.
        SharedPreferences preferences = getSharedPreferences("PREFERENCE",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();


        String FirstTime = preferences.getString("FirstTimeInstall","");

        if(FirstTime.equals("Yes")){ //αν εχει ξανατρεξει η εφαρμογη

            Intent intent = new Intent(User.this,WelcomePage.class);
            startActivity(intent);
        } else {

            editor.putString("FirstTimeInstall", "Yes");
            editor.apply();
        }

        inputName = findViewById(R.id.inputName);
        sbutton = findViewById(R.id.sbutton);


        sbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String SavedNames = inputName.getText().toString();
                goToWelcomePage(v, SavedNames);


            }

        });
    }


    public void goToWelcomePage(View view, String SavedNames) {
        Intent intent = new Intent(getApplicationContext(), WelcomePage.class);
        intent.putExtra("Name", SavedNames);


        startActivity(intent);

    }
}
